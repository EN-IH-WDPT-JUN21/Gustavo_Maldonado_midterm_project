package com.ironhack.bankapi.util;

import java.math.BigDecimal;

public abstract class Constants {

    public final static BigDecimal PENALTY_FEE = new BigDecimal(40);

    // SAVINGS CONSTANTS
    public final static BigDecimal SAVINGS_DFT_INTEREST_RATE = new BigDecimal("0.0025"); // What should be BigDecimal?
    public final static BigDecimal MAX_SAVINGS_INTEREST_RATE = new BigDecimal("0.5");
    public final static BigDecimal SAVINGS_DEFAULT_BALANCE = new BigDecimal(1000);
    public final static BigDecimal SAVINGS_MIN_BALANCE = new BigDecimal(100);

    // CREDITCARDS CONSTANTS
    public final static BigDecimal CC_DEFAULT_LIMIT = new BigDecimal(100);
    public final static BigDecimal CC_MAX_LIMIT = new BigDecimal(100000);
    public final static BigDecimal CC_DFT_INTEREST_RATE = new BigDecimal("0.2");
    public final static BigDecimal CC_MIN_INTEREST_RATE = new BigDecimal("0.1");

    // CHECKING CONSTANTS
    public final static int STUDENT_ACCOUNT_AGE_LIMIT = 24;
    public final static BigDecimal CHECKING_MIN_BALANCE = new BigDecimal(250);
    public final static BigDecimal MONTHLY_MTC_FEE = new BigDecimal(12);
}
