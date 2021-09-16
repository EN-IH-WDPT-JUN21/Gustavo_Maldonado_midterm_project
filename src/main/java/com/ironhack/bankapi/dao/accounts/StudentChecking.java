package com.ironhack.bankapi.dao.accounts;

import com.ironhack.bankapi.enums.Status;
import com.ironhack.bankapi.util.Money;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class StudentChecking extends Account {
    private String secretKey; // What is this for? Should be encrypted?

}
