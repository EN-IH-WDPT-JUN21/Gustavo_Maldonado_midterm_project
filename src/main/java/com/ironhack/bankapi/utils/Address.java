package com.ironhack.bankapi.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class Address {

    private String street;
    private String number;
    private String state;
    private String country;
    private String zipCode;
}
