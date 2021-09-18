package com.ironhack.bankapi.dao.transaction;

import com.ironhack.bankapi.enums.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "transaction_request_id")
    private TransactionRequest transactionRequest;

    @Enumerated(EnumType.STRING)
    private TransactionStatus status;

    public Transaction(TransactionRequest transactionRequest, TransactionStatus status) {
        this.transactionRequest = transactionRequest;
        this.status = status;
    }

    // Add field message: Transaction approved or transaction denied

}
