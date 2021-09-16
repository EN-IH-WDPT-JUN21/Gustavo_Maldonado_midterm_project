package com.ironhack.bankapi.dao.accounts;

import com.ironhack.bankapi.dao.users.AccountHolder;
import com.ironhack.bankapi.enums.Status;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long id;

    @Column(name = "balance",
            nullable = false,
            columnDefinition = "DECIMAL(10, 2)")
    private BigDecimal balance; // Should this be the Money class??

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "primary_owner")
//    private AccountHolder primaryOwner;
//
//    @ManyToOne(fetch = FetchType.LAZY, optional = true) // Will optional=true make account not require secondaryOwner (make it optional)
//    @JoinColumn(name = "secondary_owner")
//    private AccountHolder secondaryOwner;
//
//    private BigDecimal penaltyFee; // Is this necessary? Just use constants when necessary

//    private Date creationDate;

//    private Status status;


//    public Account(BigDecimal balance, AccountHolder primaryOwner, AccountHolder secondaryOwner, BigDecimal penaltyFee) {
//        this.balance = balance;
//        this.primaryOwner = primaryOwner;
//        this.secondaryOwner = secondaryOwner;
//        this.penaltyFee = penaltyFee;
//    }


    public Account(BigDecimal balance) {
        this.balance = balance;
    }
}
