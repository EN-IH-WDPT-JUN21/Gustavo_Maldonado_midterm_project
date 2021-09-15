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
public class Savings extends Account {
    private String secretKey; // What is this for? Should be encrypted?
//    private BigDecimal minimumBalance; // Is this necessary?
//    private BigDecimal penaltyFee; // Is this necessary?
//    private BigDecimal interestRate;
//    private Date creationDate;
//    private Status status;
}
