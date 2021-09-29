package com.ironhack.bankapi.controller.impl;

import com.ironhack.bankapi.controller.dto.CheckingDTO;
import com.ironhack.bankapi.controller.interfaces.ICheckingAccount;
import com.ironhack.bankapi.dao.accounts.Checking;
import com.ironhack.bankapi.dao.users.AccountHolder;
import com.ironhack.bankapi.repository.AccountHolderRepository;
import com.ironhack.bankapi.repository.CheckingRepository;
import com.ironhack.bankapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/account")
public class CheckingController implements ICheckingAccount {

    @Autowired
    CheckingRepository checkingRepository;
    @Autowired
    AccountHolderRepository accountHolderRepository;

    @PostMapping("/checking")
    @ResponseStatus(HttpStatus.CREATED)
    public Checking store(@RequestBody CheckingDTO checkingDTO) {
        Optional<AccountHolder> primaryOwner = accountHolderRepository.findById(checkingDTO.getPrimaryOwnerId());
        Optional<AccountHolder> secondaryOwner = accountHolderRepository.findById(checkingDTO.getSecondaryOwnerId());

        Checking checking = new Checking(
                                        checkingDTO.getBalance(),
                                        primaryOwner.get(),
                                        secondaryOwner.get(),
                                        checkingDTO.getSecretKey());
        return checkingRepository.save(checking);
    }
}
