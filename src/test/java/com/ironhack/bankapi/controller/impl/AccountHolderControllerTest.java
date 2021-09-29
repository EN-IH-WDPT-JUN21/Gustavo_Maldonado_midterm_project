package com.ironhack.bankapi.controller.impl;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.bankapi.controller.dto.AccountHolderDTO;
import com.ironhack.bankapi.controller.dto.MoneyDTO;
import com.ironhack.bankapi.controller.dto.TransferDTO;
import com.ironhack.bankapi.dao.accounts.Checking;
import com.ironhack.bankapi.dao.users.AccountHolder;
import com.ironhack.bankapi.dao.users.Admin;
import com.ironhack.bankapi.repository.AccountHolderRepository;
import com.ironhack.bankapi.repository.AdminRepository;
import com.ironhack.bankapi.repository.CheckingRepository;
import com.ironhack.bankapi.security.CustomUserDetails;
import com.ironhack.bankapi.utils.Address;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import static org.junit.jupiter.api.Assertions.*;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class AccountHolderControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    private CheckingRepository checkingRepository;
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private AccountHolderRepository accountHolderRepository;
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private MockMvc mockMvc;
    private ObjectMapper objectMapper = new ObjectMapper();

    private Admin admin;
    private AccountHolder userOne;
    private AccountHolder userTwo;
    private Address address1 = new Address("Santana", "7", "Valencia", "Spain", "75640");
    private Address address2 = new Address("Pelayo", "20", "Sevilla", "Spain", "41900");
    private MoneyDTO moneyOne = new MoneyDTO(new BigDecimal("500"));
    private MoneyDTO moneyTwo = new MoneyDTO(new BigDecimal("1500"));
    private MoneyDTO moneyThree = new MoneyDTO(new BigDecimal("100"));


    @BeforeEach
    void setUp() {
        objectMapper.findAndRegisterModules();
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).apply(springSecurity()).build();
        admin = new Admin("admin", passwordEncoder.encode("123456"));
        adminRepository.save(admin);
        userOne = new AccountHolder("Wanda Windows", passwordEncoder.encode("654321"),
                LocalDate.of(1980, 6, 12), address1, address2);
        userTwo = new AccountHolder("Vilma Flinstone", passwordEncoder.encode("654321"),
                LocalDate.of(2000, 8, 30), address2, address1);
        accountHolderRepository.saveAll(List.of(userOne, userTwo));
        Checking checkingAccountOne = new Checking(moneyOne.getNewBalance(), userOne, userOne, passwordEncoder.encode("secretKey"));
        Checking checkingAccountTwo = new Checking(moneyOne.getNewBalance(), userTwo, userTwo, passwordEncoder.encode("secretKey"));
        checkingRepository.saveAll(List.of(checkingAccountOne, checkingAccountTwo));
    }

    @AfterEach
    void tearDown() {
        adminRepository.deleteAll();
        accountHolderRepository.deleteAll();
        checkingRepository.deleteAll();
    }

    @Test
    void storeTest() throws Exception{
        AccountHolderDTO newUserOne = new AccountHolderDTO("Michael Jordan",
                passwordEncoder.encode("nbachampion"),
                LocalDate.of(1980, 3, 20),
                address1, address2);

        MvcResult mvcResult = mockMvc.perform(post("/client/new")
                .with(user(new CustomUserDetails(admin)))
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(newUserOne)))
                .andExpect(status().isCreated()).andReturn();

        assertTrue(accountHolderRepository.findAll().size() == 3);
    }

//    @Test
//    void transferTest() throws Exception {
//        TransferDTO transferDTO = new TransferDTO(moneyThree, 2L, "Vilma Flinstone");
////        System.out.println(checkingRepository.getById(1L).getPrimaryOwner().getUsername());
////        System.out.println(checkingRepository.getById(2L).getPrimaryOwner().getUsername());
//        MvcResult mvcResult = mockMvc.perform(patch("/client/transfer/1")
//                .with(user(new CustomUserDetails(userOne)))
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(transferDTO)))
//                .andExpect(status().isAccepted()).andReturn();
//
//        assertThat(new BigDecimal("400"), Matchers.comparesEqualTo(checkingRepository.getById(1L).getBalance().getAmount()));
//        assertThat(new BigDecimal("1600"), Matchers.comparesEqualTo(checkingRepository.getById(2L).getBalance().getAmount()));
//    }
}