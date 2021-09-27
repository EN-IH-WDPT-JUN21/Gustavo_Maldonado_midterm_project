package com.ironhack.bankapi.dao.users;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Admin extends User {
    public Admin (String username, String password) {
        super(username, password);
    }
}