package com.ironhack.bankapi.controller.impl;

import com.ironhack.bankapi.controller.dto.SavingsDTO;
import com.ironhack.bankapi.dao.accounts.Savings;
import com.ironhack.bankapi.service.SavingsAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class SavingsController {

    @Autowired
    SavingsAccountService savingsAccountService;

    @PostMapping("/savings")
    @ResponseStatus(HttpStatus.CREATED)
    public Savings store(@RequestBody SavingsDTO savingsDTO) {
        return savingsAccountService.create(savingsDTO);
    }

}
