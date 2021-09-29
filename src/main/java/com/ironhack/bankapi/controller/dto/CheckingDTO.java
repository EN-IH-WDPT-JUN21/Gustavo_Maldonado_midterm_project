package com.ironhack.bankapi.controller.dto;

import com.ironhack.bankapi.dao.users.AccountHolder;
import com.ironhack.bankapi.utils.Money;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class CheckingDTO {

    private BigDecimal balance;
    private Long primaryOwnerId;
    @Nullable
    private Long secondaryOwnerId;
    private String secretKey;

}
