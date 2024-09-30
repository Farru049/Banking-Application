package com.farhaan.thefarhaanacademybank.utils;

import java.time.Year;

public class AccountUtils {
    public static final String ACCOUNT_EXIST_CODE = "001";
    public static final String ACCOUNT_EXIST_MESSAGE = "This user already has an account!"; // Add this line
    public static final String ACCOUNT_CREATION_SUCCESS = "002";
    public static final String ACCOUNT_CREATION_MESSAGE = "Account has been successfully created"; // Fixed spelling

    public static String generateAccountNumber() {
        // Get the current year
        Year currentYear = Year.now();
        int min = 100000;
        int max = 999999;

        // Generate a random number between min and max
        int randNumber = (int) Math.floor(Math.random() * (max - min + 1) + min);

        // Convert the current year and random number to strings
        String year = String.valueOf(currentYear);
        String randomNumber = String.valueOf(randNumber);

        // Create the account number by concatenating year and random number
        return year + randomNumber;
    }
}
