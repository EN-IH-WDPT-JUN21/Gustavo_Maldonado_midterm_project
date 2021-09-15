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
public class CreditCard extends Account {
    private BigDecimal creditLimit; // Is this necessary?
//    private BigDecimal interestRate;
//    private Date creationDate; // While not in the requirements, necessary to check monthly for interest or penalty fee

}
