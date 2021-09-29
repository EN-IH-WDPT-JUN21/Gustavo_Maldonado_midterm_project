package com.ironhack.bankapi.service;

import com.ironhack.bankapi.controller.dto.AccountDTO;
import com.ironhack.bankapi.controller.dto.AccountHolderDTO;
import com.ironhack.bankapi.controller.dto.MoneyDTO;
import com.ironhack.bankapi.dao.accounts.Account;
import com.ironhack.bankapi.repository.AccountHolderRepository;
import com.ironhack.bankapi.repository.AccountRepository;
import com.ironhack.bankapi.utils.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    AccountHolderRepository accountHolderRepository;
    @Autowired
    AccountRepository accountRepository;

    public List<AccountDTO> findAccountsFromUser(Long userId){
        List<AccountDTO> accountList = new ArrayList<>();
        for(Account account : accountHolderRepository.findById(userId).get().getAccountsPrimary()) {
            accountList.add(convertAccount(account));
        }
        return accountList;
    }

    public AccountDTO updateBalance(Long accountId, MoneyDTO newBalance) {
        if(accountRepository.findById(accountId).isPresent()) {
            Account account = accountRepository.findById(accountId).get();
            account.setBalance(newBalance.getNewBalance());
            accountRepository.save(account);
            return convertAccount(account);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This account doesn't exists in the database");
        }
    }

    public void decreaseBalance(Long accountId, BigDecimal amountToSubtract) {
        Account account = accountRepository.getById(accountId);
        account.setBalance(account.getBalance().getAmount().subtract(amountToSubtract));
        accountRepository.save(account);
    }

    public void incrementBalance(Long accountId, BigDecimal amountToIncrease) {
        Account account = accountRepository.getById(accountId);
        account.setBalance(account.getBalance().getAmount().add(amountToIncrease));
        accountRepository.save(account);
    }

    private AccountDTO convertAccount(Account account) {
        return new AccountDTO(
                account.getId(),
                account.getBalance(),
                new AccountHolderDTO(
                        account.getPrimaryOwner().getUsername(),
                        account.getPrimaryOwner().getPassword(),
                        account.getPrimaryOwner().getDateOfBirth(),
                        account.getPrimaryOwner().getAddress(),
                        account.getPrimaryOwner().getMailingAddress()),
                new AccountHolderDTO(
                        account.getSecondaryOwner().getUsername(),
                        account.getSecondaryOwner().getPassword(),
                        account.getSecondaryOwner().getDateOfBirth(),
                        account.getSecondaryOwner().getAddress(),
                        account.getSecondaryOwner().getMailingAddress()),
                account.getCreationDate());
    }
}
