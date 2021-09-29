package com.ironhack.bankapi.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.bankapi.dao.accounts.Checking;
import com.ironhack.bankapi.dao.users.AccountHolder;
import com.ironhack.bankapi.dao.users.Admin;
import com.ironhack.bankapi.repository.AccountHolderRepository;
import com.ironhack.bankapi.repository.AccountRepository;
import com.ironhack.bankapi.repository.UserRepository;
import com.ironhack.bankapi.utils.Address;
import com.ironhack.bankapi.utils.Money;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class AccountControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AccountHolderRepository accountHolderRepository;
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private MockMvc mockMvc;
    private ObjectMapper objectMapper = new ObjectMapper();
    private Address address1 = new Address("Santana", "7", "Valencia", "Spain", "75640");
    private Address address2 = new Address("Pelayo", "20", "Sevilla", "Spain", "41900");
    private BigDecimal moneyOne = new BigDecimal("500");
    private BigDecimal moneyTwo = new BigDecimal("1500");

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).apply(springSecurity()).build();
        Admin admin = new Admin("admin", passwordEncoder.encode("123456"));
        userRepository.save(admin);
        AccountHolder userOne = new AccountHolder("Wanda Windows", passwordEncoder.encode("654321"),
            LocalDate.of(1980, 6, 12), address1, null);
        AccountHolder userTwo = new AccountHolder("Vilma Flinstone", passwordEncoder.encode("654321"),
            LocalDate.of(2000, 8, 30), address2, address1);
        userRepository.saveAll(List.of(userOne, userTwo));
        Checking checkingAccountOne = new Checking(moneyOne, userOne, null, passwordEncoder.encode("secretKey"));
        Checking checkingAccountTwo = new Checking(moneyOne, userTwo, null, passwordEncoder.encode("secretKey"));
        account

    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void homeTest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andReturn();
        assertTrue(mvcResult.getResponse().getContentAsString().contains("home"));

    }

}