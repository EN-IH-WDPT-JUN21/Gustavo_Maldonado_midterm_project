package com.ironhack.bankapi.dao.accounts;

import com.ironhack.bankapi.dao.users.AccountHolder;
import com.ironhack.bankapi.utils.Money;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Savings extends Account {
    private String secretKey; // This should be encrypted

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "minimum_balance")),
            @AttributeOverride(name = "currency", column = @Column(name = "minimum_balance_currency"))
    })
    @DecimalMin(value = "100", message = "Minimum balance to open a savings account is 100")
    private Money minimumBalance;

    @DecimalMax(value = "0.5", message = "Max interest rate is 0.5")
    private BigDecimal interestRate;

    public Savings(BigDecimal balance, AccountHolder primaryOwner, AccountHolder secondaryOwner, String secretKey, Money minimumBalance, BigDecimal interestRate) {
        super(balance, primaryOwner, secondaryOwner);
        this.secretKey = secretKey;
        setMinimumBalance(minimumBalance);
        setInterestRate(interestRate);
    }

    public void setMinimumBalance(Money minimumBalance) {
        this.minimumBalance = minimumBalance == null ? new Money(new BigDecimal("1000")) : minimumBalance;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate == null ? new BigDecimal("0.0025") : interestRate;
    }
}
