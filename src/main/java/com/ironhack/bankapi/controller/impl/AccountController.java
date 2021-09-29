package com.ironhack.bankapi.controller.impl;

import com.ironhack.bankapi.controller.dto.AccountDTO;
import com.ironhack.bankapi.controller.dto.MoneyDTO;
import com.ironhack.bankapi.controller.interfaces.IAccountController;
import com.ironhack.bankapi.dao.accounts.Account;
import com.ironhack.bankapi.dao.users.AccountHolder;
import com.ironhack.bankapi.repository.AccountHolderRepository;
import com.ironhack.bankapi.repository.AccountRepository;
import com.ironhack.bankapi.security.CustomUserDetails;
import com.ironhack.bankapi.service.AccountService;
import com.ironhack.bankapi.utils.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
public class AccountController implements IAccountController {

    @Autowired
    AccountService accountService;
    @Autowired
    AccountHolderRepository accountHolderRepository;

    @GetMapping("/my-account/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<AccountDTO> getAccountById(@PathVariable("id") Long userId) {
        CustomUserDetails customUserDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String password = accountHolderRepository.getById(userId).getPassword();
        if(customUserDetails.getPassword().equals(password)) {
            return accountService.findAccountsFromUser(userId);
        }
        else throw new AccessDeniedException("You have no permission to access this account");
    }

    @PatchMapping("/admin/account/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AccountDTO updateAccount(@PathVariable("id") Long accountId, @RequestBody MoneyDTO newBalance) {
        return accountService.updateBalance(accountId, newBalance);
    }

}
