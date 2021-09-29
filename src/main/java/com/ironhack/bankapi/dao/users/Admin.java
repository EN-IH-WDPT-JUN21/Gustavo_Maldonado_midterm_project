package com.ironhack.bankapi.dao.users;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@NoArgsConstructor
public class Admin extends User {

    public Admin (@NotNull(message = "Username required") String username, @NotNull(message = "Password required") String password) {
        super(username, password);
        this.setRole("ADMIN");
    }
}