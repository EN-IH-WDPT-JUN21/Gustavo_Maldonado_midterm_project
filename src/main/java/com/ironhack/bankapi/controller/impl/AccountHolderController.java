package com.ironhack.bankapi.controller.impl;

import com.ironhack.bankapi.controller.dto.AccountHolderDTO;
import com.ironhack.bankapi.dao.users.AccountHolder;
import com.ironhack.bankapi.repository.AccountHolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Optional;

import static com.ironhack.bankapi.utils.PasswordUtil.encryptedPassword;

@RestController
@RequestMapping("/client")
public class AccountHolderController {

    @Autowired
    AccountHolderRepository accountHolderRepository;

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public AccountHolder store(@RequestBody AccountHolderDTO accountHolderDTO){
        AccountHolder accountHolder = new AccountHolder(
                                                        accountHolderDTO.getUsername(),
                                                        encryptedPassword(accountHolderDTO.getPassword()),
                                                        accountHolderDTO.getDateOfBirth(),
                                                        accountHolderDTO.getAddress(),
                                                        accountHolderDTO.getMailingAddress());
        return accountHolderRepository.save(accountHolder);
    }

}
