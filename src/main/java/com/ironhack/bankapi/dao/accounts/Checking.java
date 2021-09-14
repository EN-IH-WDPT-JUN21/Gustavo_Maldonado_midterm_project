package com.ironhack.bankapi.dao.accounts;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class Checking extends Account {
        private String secretKey; // What is this for? Should be encrypted?
        private BigDecimal minimumBalance;
        private BigDecimal penaltyFee;
        private double interestRate;

}
