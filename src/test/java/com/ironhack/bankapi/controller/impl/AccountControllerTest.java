package com.ironhack.bankapi.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.bankapi.controller.dto.MoneyDTO;
import com.ironhack.bankapi.dao.accounts.Checking;
import com.ironhack.bankapi.dao.users.AccountHolder;
import com.ironhack.bankapi.dao.users.Admin;
import com.ironhack.bankapi.repository.*;
import com.ironhack.bankapi.security.CustomUserDetails;
import com.ironhack.bankapi.utils.Address;
import com.ironhack.bankapi.utils.Money;
import org.hamcrest.Matchers;
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

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.web.servlet.function.RequestPredicates.contentType;

import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class AccountControllerTest {

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

    @BeforeEach
    void setUp() {
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
    void getAccountByIdTest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/my-account/" + accountHolderRepository.findAll().get(0).getId())
                .with(user(new CustomUserDetails(userOne))))
                .andExpect(status().isOk()).andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Wanda Windows"));
        assertFalse(mvcResult.getResponse().getContentAsString().contains("Vilma Flinstone"));
    }

    @Test
    void updateAccountTest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(patch("/admin/account/" + checkingRepository.findAll().get(0).getId())
                .with(user(new CustomUserDetails(admin)))
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(moneyTwo)))
                .andExpect(status().isOk()).andReturn();

        assertThat(moneyTwo.getNewBalance(), Matchers.comparesEqualTo(checkingRepository.findAll().get(0).getBalance().getAmount()));
    }


}