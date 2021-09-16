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
public class CreditCard extends Account {
    private BigDecimal creditLimit;
    private BigDecimal interestRate;

}
