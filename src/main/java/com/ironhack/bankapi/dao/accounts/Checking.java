package com.ironhack.bankapi.dao.accounts;

import com.ironhack.bankapi.dao.users.AccountHolder;
import com.ironhack.bankapi.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
public class Checking extends Account {
        private String secretKey; // This should be encrypted
        private BigDecimal minimumBalance;
        private BigDecimal monthlyMaintenanceFee;

        public Checking(BigDecimal balance, String secretKey, BigDecimal minimumBalance, BigDecimal monthlyMaintenanceFee) {
                super(balance);
                this.secretKey = secretKey;
                this.minimumBalance = minimumBalance;
                this.monthlyMaintenanceFee = monthlyMaintenanceFee;
        }

//        public Checking(BigDecimal balance, AccountHolder primaryOwner, AccountHolder secondaryOwner, BigDecimal penaltyFee, String secretKey, BigDecimal minimumBalance, BigDecimal monthlyMaintenanceFee) {
//                super(balance, primaryOwner, secondaryOwner, penaltyFee);
//                this.secretKey = secretKey;
//                this.minimumBalance = minimumBalance;
//                this.monthlyMaintenanceFee = monthlyMaintenanceFee;
//        }
}
