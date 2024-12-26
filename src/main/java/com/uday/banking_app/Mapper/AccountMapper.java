package com.uday.banking_app.Mapper;

import com.uday.banking_app.Entity.Account;
import com.uday.banking_app.RequestDto.AccountRequestDto;
import com.uday.banking_app.ResponseDto.AccountResponseDto;

public class AccountMapper {
    public Account toAccount(AccountRequestDto accountRequestDto)
    {
        Account account = new Account(accountRequestDto.id(),accountRequestDto.name(),accountRequestDto.balance());
        return account;

    }
    public AccountResponseDto toAccountResponseDto(Account account)
    {
        AccountResponseDto accountResponseDto= new AccountResponseDto(account.getAccountNo(), account.getName(), account.getBalance());
        return accountResponseDto;
    }
}
