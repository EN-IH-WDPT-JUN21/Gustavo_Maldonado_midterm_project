package com.ironhack.bankapi.controller.dto;

import com.ironhack.bankapi.utils.Money;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
public class TransferDTO {
    private MoneyDTO transferAmount;
    private Long accountToTransferId;
    private String anyOwnerName;
}
