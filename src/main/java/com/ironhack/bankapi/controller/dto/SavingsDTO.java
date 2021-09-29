package com.ironhack.bankapi.controller.dto;

import com.ironhack.bankapi.dao.users.AccountHolder;
import com.ironhack.bankapi.utils.Money;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import org.springframework.lang.Nullable;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
public class SavingsDTO {

    private BigDecimal balance;
    private AccountHolder primaryOwnerId;
    @Nullable
    private AccountHolder secondaryOwnerId;
    private String secretKey;
    private Money minimumBalance;
    private BigDecimal interestRate;

    public SavingsDTO(BigDecimal balance, AccountHolder primaryOwnerId, @Nullable AccountHolder secondaryOwnerId, String secretKey) {
        this.balance = balance;
        this.primaryOwnerId = primaryOwnerId;
        this.secondaryOwnerId = secondaryOwnerId;
        this.secretKey = secretKey;
        this.minimumBalance = new Money(new BigDecimal("1000"));
        this.interestRate = new BigDecimal("0.0025");
    }

}
