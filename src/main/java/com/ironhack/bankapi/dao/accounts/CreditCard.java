package com.ironhack.bankapi.dao.accounts;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class CreditCard extends Account {
    private BigDecimal creditLimit;
    private BigDecimal interestRate;

}
