package com.ironhack.bankapi.dao.users;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ironhack.bankapi.dao.accounts.Account;
import com.ironhack.bankapi.utils.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.validation.constraints.Null;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class AccountHolder extends User {

    public AccountHolder(String username, String password, LocalDate dateOfBirth, Address address, @Nullable Address mailingAddress) {
        super(username, password);
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.mailingAddress = mailingAddress;
        super.setRole("ACCOUNT_HOLDER");
    }

    private LocalDate dateOfBirth;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(nullable = false)),
            @AttributeOverride(name = "number", column = @Column(name = "street_number", nullable = false)),
            @AttributeOverride(name = "state", column = @Column(nullable = false)),
            @AttributeOverride(name = "country", column = @Column(nullable = false)),
            @AttributeOverride(name = "zipCode", column = @Column(name = "zip_code", nullable = false))
    })
    private Address address; // Should be a separate Address class

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "mailing_street")),
            @AttributeOverride(name = "number", column = @Column(name = "mailing_street_number")),
            @AttributeOverride(name = "state", column = @Column(name = "mailing_state")),
            @AttributeOverride(name = "country", column = @Column(name = "mailing_country")),
            @AttributeOverride(name = "zipCode", column = @Column(name = "mailing_zip_code"))
    })
    private Address mailingAddress; // Should be optional

    @JsonIgnoreProperties
    @OneToMany(mappedBy = "primaryOwner", cascade = CascadeType.ALL)
    private List<Account> accountsPrimary;

    @JsonIgnoreProperties
    @Nullable
    @OneToMany(mappedBy = "secondaryOwner", cascade = CascadeType.ALL)
    private List<Account> accountsSecondary;

}
