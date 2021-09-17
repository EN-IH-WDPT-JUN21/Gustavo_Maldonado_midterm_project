package com.ironhack.bankapi.repository;

import com.ironhack.bankapi.dao.accounts.Account;
import com.ironhack.bankapi.dao.users.AccountHolder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountHolderRepository extends JpaRepository<AccountHolder, Long> {
}
