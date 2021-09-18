package com.ironhack.bankapi.dao.accounts;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Savings extends Account {
    private String secretKey; // This should be encrypted
    private BigDecimal minimumBalance;
    private BigDecimal interestRate;

}
