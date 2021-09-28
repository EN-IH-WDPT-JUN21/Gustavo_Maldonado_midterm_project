package com.ironhack.bankapi.controller.dto;

import com.ironhack.bankapi.utils.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
public class AccountHolderDTO {

    private String username;
    private String password;
    private LocalDate dateOfBirth;
    private Address address;
    private Address mailingAddress;

}
