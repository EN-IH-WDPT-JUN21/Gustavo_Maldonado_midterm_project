package com.ironhack.bankapi.dao.users;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.ironhack.bankapi.dao.accounts.Account;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class AccountHolder extends User {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "account_id")
    private Account account;
}
