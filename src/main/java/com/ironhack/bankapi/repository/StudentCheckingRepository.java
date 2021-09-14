package com.ironhack.bankapi.repository;

import com.ironhack.bankapi.dao.accounts.StudentChecking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCheckingRepository extends JpaRepository<StudentChecking, String> {
}
