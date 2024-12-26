package com.uday.banking_app.Service;

import com.uday.banking_app.Entity.Account;
import com.uday.banking_app.Exceptions.AccountException;
import com.uday.banking_app.RequestDto.AccountRequestDto;
import com.uday.banking_app.ResponseDto.AccountResponseDto;

public interface AccountService {

    public AccountResponseDto createAccount(AccountRequestDto accountRequestDto);

    public AccountResponseDto getAccount(int id) throws AccountException;

    public AccountResponseDto deposit(int id, double amount) throws AccountException;

    public AccountResponseDto withdraw(int id,double amount) throws Exception;

    public AccountResponseDto delete(int id) throws Exception;

}
