package com.ironhack.bankapi.dao.accounts;

import com.ironhack.bankapi.dao.users.AccountHolder;
import com.ironhack.bankapi.utils.Money;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class CreditCard extends Account {
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "credit_limit")),
            @AttributeOverride(name = "currency", column = @Column(name = "credit_limit_currency"))
    })
    @DecimalMax(value = "100000", message = "Max limit for credit cards is 100000")
    private Money creditLimit;

    @DecimalMin(value = "0.1", message = "Minimum interest rate is 0.1")
    private BigDecimal interestRate;

    public CreditCard(BigDecimal balance, AccountHolder primaryOwner, AccountHolder secondaryOwner, Money creditLimit, BigDecimal interestRate) {
        super(balance, primaryOwner, secondaryOwner);
        setCreditLimit(creditLimit);
        setInterestRate(interestRate);
    }

    public void setCreditLimit(Money creditLimit) {
        this.creditLimit = creditLimit == null ? new Money(new BigDecimal("100")) : creditLimit;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate == null ? new BigDecimal("0.2") : interestRate;
    }
}
