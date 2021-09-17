package com.ironhack.bankapi.dao.accounts;

import com.ironhack.bankapi.dao.users.AccountHolder;
import com.ironhack.bankapi.enums.Status;
import com.ironhack.bankapi.utils.Money;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

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


        public Checking(BigDecimal balance, AccountHolder primaryOwner, AccountHolder secondaryOwner, String secretKey, BigDecimal minimumBalance, BigDecimal monthlyMaintenanceFee) {
                super(balance, primaryOwner, secondaryOwner);
                setSecretKey(secretKey);
                setMinimumBalance(minimumBalance);
                setMonthlyMaintenanceFee(monthlyMaintenanceFee);
        }

        public void setSecretKey(String secretKey) {
                this.secretKey = secretKey;
        }

        public void setMinimumBalance(BigDecimal minimumBalance) {
                this.minimumBalance = new Money(minimumBalance);
        }

        public void setMonthlyMaintenanceFee(BigDecimal monthlyMaintenanceFee) {
                this.monthlyMaintenanceFee = new Money(monthlyMaintenanceFee);
        }
}
