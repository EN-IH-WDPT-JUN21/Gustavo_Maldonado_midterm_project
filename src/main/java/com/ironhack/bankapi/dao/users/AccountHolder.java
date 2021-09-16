package com.ironhack.bankapi.dao.users;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.ironhack.bankapi.dao.accounts.Account;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AccountHolder extends User {

    private Date dateOfBirth;

    private String address; // Should be a separate Address class

    private String mailingAddress; // Should be optional

//    @OneToMany(mappedBy = "primaryOwner", cascade = CascadeType.ALL)
//    private List<Account> accountPrimary;
//
//    @OneToMany(mappedBy = "secondaryOwner", cascade = CascadeType.ALL)
//    private List<Account> accountSecondary;
}
