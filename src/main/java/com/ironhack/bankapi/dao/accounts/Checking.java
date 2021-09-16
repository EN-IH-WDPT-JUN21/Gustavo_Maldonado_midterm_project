package com.ironhack.bankapi.dao.accounts;

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
}
