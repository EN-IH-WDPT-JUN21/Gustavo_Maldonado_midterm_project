package com.ironhack.bankapi.controller.interfaces;

import com.ironhack.bankapi.controller.dto.CheckingDTO;
import com.ironhack.bankapi.dao.accounts.Checking;

public interface ICheckingAccount {

    public Checking store(CheckingDTO checkingDTO);
}
