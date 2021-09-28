package com.ironhack.bankapi.dao.accounts;

import com.ironhack.bankapi.dao.users.AccountHolder;
import com.ironhack.bankapi.utils.Money;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Checking extends Account {

        private String secretKey; // This should be encrypted

        @Embedded
        @AttributeOverrides({
                @AttributeOverride(name = "amount", column = @Column(name = "minimum_balance")),
                @AttributeOverride(name = "currency", column = @Column(name = "minimum_balance_currency"))
                })
        private Money minimumBalance;

        @AttributeOverrides({
                @AttributeOverride(name = "amount", column = @Column(name = "monthly_maintenance_fee")),
                @AttributeOverride(name = "currency", column = @Column(name = "maintenance_fee_currency"))
                })
        @Embedded
        private Money monthlyMaintenanceFee;


        public Checking(BigDecimal balance, AccountHolder primaryOwner, AccountHolder secondaryOwner, String secretKey) {
                super(balance, primaryOwner, secondaryOwner);
                setSecretKey(secretKey);
                setMinimumBalance();
                setMonthlyMaintenanceFee();
        }



        public void setMinimumBalance() {
                this.minimumBalance = new Money(new BigDecimal("250"));
        }

        public void setMonthlyMaintenanceFee() {
                this.monthlyMaintenanceFee = new Money(new BigDecimal("12"));
        }
}
