package com.ironhack.bankapi.controller.dto;

import com.ironhack.bankapi.dao.users.AccountHolder;
import com.ironhack.bankapi.utils.Money;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
public class AccountDTO {

    private Long accountId;
    private Money balance;
    private AccountHolderDTO primaryOwner;
    private AccountHolderDTO secondaryOwner;
    private LocalDateTime creationDate;

    public AccountDTO(Long accountId, Money balance, AccountHolderDTO primaryOwner, AccountHolderDTO secondaryOwner, LocalDateTime creationDate) {
        this.accountId = accountId;
        this.balance = balance;
        this.primaryOwner = primaryOwner;
        this.secondaryOwner = secondaryOwner;
        this.creationDate = creationDate;
    }
}
