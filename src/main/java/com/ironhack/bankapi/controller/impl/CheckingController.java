package com.ironhack.bankapi.controller.impl;

import com.ironhack.bankapi.controller.interfaces.ICheckingAccount;
import com.ironhack.bankapi.dao.accounts.Checking;
import com.ironhack.bankapi.repository.CheckingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class CheckingController implements ICheckingAccount {

    @Autowired
    CheckingRepository checkingRepository;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Checking store(@RequestBody Checking checking) {
        return checkingRepository.save(checking);
    }
}
