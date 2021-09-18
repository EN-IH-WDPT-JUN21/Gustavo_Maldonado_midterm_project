package com.ironhack.bankapi.controller.impl;

import com.ironhack.bankapi.controller.interfaces.IAccountController;
import com.ironhack.bankapi.dao.accounts.Account;
import com.ironhack.bankapi.dao.users.AccountHolder;
import com.ironhack.bankapi.repository.AccountHolderRepository;
import com.ironhack.bankapi.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
//@RequestMapping("/my-account/overview")
public class AccountController implements IAccountController {

    @Autowired
    AccountHolderRepository accountHolderRepository;

    @Autowired
    AccountRepository accountRepository;

    @GetMapping("/hello-world")
    @ResponseStatus(HttpStatus.OK)
    public String home(){
        return "Hello Stranger!";
    }

//    @GetMapping
//    @ResponseStatus(HttpStatus.OK)
//    public Account findById (@RequestBody AccountHolder accountHolder) {
//        Optional<Account> optionalAccount = accountRepository.findById(accountHolder.getId());
//        return accountRepository.findById();
//    }

}
