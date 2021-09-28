package com.ironhack.bankapi.controller.dto;

import com.ironhack.bankapi.dao.users.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
public class AdminDTO {

    private String username;
    private String password;

}
