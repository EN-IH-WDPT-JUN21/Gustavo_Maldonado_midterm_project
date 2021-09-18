package com.ironhack.bankapi.dao.accounts;

import com.ironhack.bankapi.dao.users.AccountHolder;
import com.ironhack.bankapi.enums.AccountStatus;
import com.ironhack.bankapi.utils.Money;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;

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

    @Column(name = "balance")
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "account_balance", nullable = false)),
            @AttributeOverride(name = "currency", column = @Column(name = "account_balance_currency", nullable = false))
            }
    )
    private Money balance;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "primary_owner")
    private AccountHolder primaryOwner;

    @ManyToOne(fetch = FetchType.LAZY, optional = true) // Will optional=true make account not require secondaryOwner (make it optional)
    @JoinColumn(name = "secondary_owner")
    private AccountHolder secondaryOwner;

    // So all time dependant operations work on the same time zone
    private LocalDateTime creationDate = LocalDateTime.now(ZoneId.of("Europe/Madrid"));

    // On creation accounts default to active
    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus = AccountStatus.valueOf("ACTIVE");

    public Account(BigDecimal balance, AccountHolder primaryOwner, AccountHolder secondaryOwner) {
        setBalance(balance);
        setPrimaryOwner(primaryOwner);
        setSecondaryOwner(secondaryOwner);
    }

    public void setBalance(BigDecimal balance) {
        this.balance = new Money(balance);
    }
}
