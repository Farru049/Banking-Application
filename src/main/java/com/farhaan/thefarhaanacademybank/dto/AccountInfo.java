package com.farhaan.thefarhaanacademybank.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountInfo {
    private String firstName;      // Add this field
    private String lastName;       // Add this field
    private String accountNumber;   // Keep this field
    private BigDecimal accountBalance; // Keep this field
    private String email;          // Add this field
    private String status;         // Add this field if needed
}
