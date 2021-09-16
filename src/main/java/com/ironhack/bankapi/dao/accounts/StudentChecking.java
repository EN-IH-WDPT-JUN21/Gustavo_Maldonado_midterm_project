package com.ironhack.bankapi.dao.accounts;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class StudentChecking extends Account {
    private String secretKey; // What is this for? Should be encrypted?

}
