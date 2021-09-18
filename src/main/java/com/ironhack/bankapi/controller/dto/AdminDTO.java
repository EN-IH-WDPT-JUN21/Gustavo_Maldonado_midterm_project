package com.ironhack.bankapi.controller.dto;

import com.ironhack.bankapi.dao.users.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class AdminDTO {

    private String username;
    private String password;
    private Role role;

    public AdminDTO(String username, String password) {
        this.username = username;
        this.password = password;
        this.role = new Role("ADMIN");
    }
}
