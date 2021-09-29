package com.ironhack.bankapi.controller.impl;

import com.ironhack.bankapi.controller.dto.AccountDTO;
import com.ironhack.bankapi.controller.dto.AccountHolderDTO;
import com.ironhack.bankapi.controller.dto.MoneyDTO;
import com.ironhack.bankapi.controller.dto.TransferDTO;
import com.ironhack.bankapi.dao.accounts.Account;
import com.ironhack.bankapi.dao.users.AccountHolder;
import com.ironhack.bankapi.repository.AccountHolderRepository;
import com.ironhack.bankapi.repository.AccountRepository;
import com.ironhack.bankapi.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.swing.text.html.Option;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.ironhack.bankapi.utils.PasswordUtil.encryptedPassword;

@RestController
@RequestMapping("/client")
public class AccountHolderController {

    @Autowired
    AccountHolderRepository accountHolderRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AccountService accountService;

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

    @PatchMapping("/transfer/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Account> transfer(@PathVariable("id") Long accountId, @RequestBody TransferDTO transferDTO){
        List<Account> accounts = new ArrayList<>();
        Optional<Account> senderAccount = accountRepository.findById(accountId);
        Optional<Account> receiverAccount = accountRepository.findById(transferDTO.getAccountToTransferId());

        if(senderAccount.isPresent() && receiverAccount.isPresent()) {
            if(senderAccount.get().getBalance().getAmount().compareTo(transferDTO.getTransferAmount().getNewBalance()) > 0) {
               accountService.decreaseBalance(senderAccount.get().getId(), transferDTO.getTransferAmount().getNewBalance());
               accountService.incrementBalance(receiverAccount.get().getId(), transferDTO.getTransferAmount().getNewBalance());
               accounts.add(accountRepository.getById(accountId));
               accounts.add(accountRepository.getById(transferDTO.getAccountToTransferId()));

            } else throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You don't have enough balance for this transaction");
        } else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Please provide correct account id's");
        return accounts;
    }
}
