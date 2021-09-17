package com.ironhack.bankapi.controller.impl;

import com.ironhack.bankapi.dao.users.AccountHolder;
import com.ironhack.bankapi.repository.AccountHolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class AccountHolderController {

    @Autowired
    AccountHolderRepository accountHolderRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AccountHolder store(@RequestBody AccountHolder accountHolder){
        return accountHolderRepository.save(accountHolder);
    }

}
