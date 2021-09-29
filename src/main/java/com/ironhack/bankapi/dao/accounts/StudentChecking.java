package com.ironhack.bankapi.dao.accounts;

import com.ironhack.bankapi.dao.users.AccountHolder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class StudentChecking extends Account {
    private String secretKey; // What is this for? Should be encrypted?

    public StudentChecking(BigDecimal balance, AccountHolder primaryOwner, AccountHolder secondaryOwner, String secretKey) {
        super(balance, primaryOwner, secondaryOwner);
        this.secretKey = secretKey;
    }
}
