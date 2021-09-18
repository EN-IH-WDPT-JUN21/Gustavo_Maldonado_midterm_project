package com.ironhack.bankapi.repository;

import com.ironhack.bankapi.dao.transaction.TransactionRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRequestRepository extends JpaRepository<TransactionRequest, Long> {

}
