package com.ironhack.bankapi.service;

import com.ironhack.bankapi.controller.dto.SavingsDTO;
import com.ironhack.bankapi.dao.accounts.Savings;
import com.ironhack.bankapi.repository.SavingsRepository;
import com.ironhack.bankapi.utils.PasswordUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.ironhack.bankapi.utils.PasswordUtil.encryptedPassword;

@Service
public class SavingsAccountService {

    private final SavingsRepository savingsRepository;

    public SavingsAccountService(SavingsRepository savingsRepository) {
        this.savingsRepository = savingsRepository;
    }

    public Savings create(SavingsDTO savingsDTO) {
        Savings savings = new Savings(
                savingsDTO.getBalance(),
                savingsDTO.getPrimaryOwnerId(),
                savingsDTO.getSecondaryOwnerId(),
                encryptedPassword(savingsDTO.getSecretKey()),
                savingsDTO.getMinimumBalance(),
                savingsDTO.getInterestRate());

        return savingsRepository.save(savings);
    }
}
