package com.uday.banking_app.Service.Implementation;

import com.uday.banking_app.Entity.Account;
import com.uday.banking_app.Exceptions.AccountException;
import com.uday.banking_app.Mapper.AccountMapper;
import com.uday.banking_app.Repository.AccountRepository;
import com.uday.banking_app.RequestDto.AccountRequestDto;
import com.uday.banking_app.ResponseDto.AccountResponseDto;
import com.uday.banking_app.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.channels.AcceptPendingException;

@Service
public class AccountServiceImpl implements AccountService {
    AccountMapper accountMapper=new AccountMapper();
    @Autowired
    AccountRepository accountRepository;
    @Override
    public AccountResponseDto createAccount(AccountRequestDto accountRequestDto) {


        Account account=accountMapper.toAccount(accountRequestDto);
        accountRepository.save(account);
        return accountMapper.toAccountResponseDto(account);
    }

    @Override
    public AccountResponseDto getAccount(int id) throws AccountException {
        Account account=accountRepository.findById(id).orElseThrow(() -> new AccountException("Invalid Account ID!"));
        AccountResponseDto accountResponseDto=accountMapper.toAccountResponseDto(account);
        return accountResponseDto;
    }

    @Override
    public AccountResponseDto deposit(int id, double amount) throws AccountException {
        Account account=accountRepository.findById(id).orElseThrow(() -> new AccountException("Account Not found!"));
        account.setBalance(account.getBalance()+amount);
        accountRepository.save(account);
        return accountMapper.toAccountResponseDto(account);

    }

    @Override
    public AccountResponseDto withdraw(int id, double amount) throws Exception {
        Account account=accountRepository.findById(id).orElseThrow(() -> new ArithmeticException("Invalid Account ID!"));
        double totalBalance = account.getBalance()-amount;
        if(totalBalance<0)
        {
            throw new Exception("Invalid funds!");
        }
        account.setBalance(totalBalance);
        accountRepository.save(account);
        AccountResponseDto accountResponseDto= accountMapper.toAccountResponseDto(account);
        return accountResponseDto;
    }

    @Override
    public AccountResponseDto delete(int id) throws Exception {
        Account account=accountRepository.findById(id).orElseThrow(() -> new AccountException("Invalid Account ID!"));
        accountRepository.deleteById(id);
        AccountResponseDto accountResponseDto= accountMapper.toAccountResponseDto(account);
        return accountResponseDto;
    }

}
