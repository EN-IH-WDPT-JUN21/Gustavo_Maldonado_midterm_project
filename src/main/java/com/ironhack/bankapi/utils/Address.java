package com.ironhack.bankapi.utils;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Data
@NoArgsConstructor(force = true)
public class Address {

    private String street;
    private String number;
    private String state;
    private String country;
    private String zipCode;
}
