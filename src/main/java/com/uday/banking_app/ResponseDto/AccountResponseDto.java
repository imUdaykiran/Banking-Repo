package com.uday.banking_app.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountResponseDto {
    private int accountNo;
    private String name;
    private double balance;
}
