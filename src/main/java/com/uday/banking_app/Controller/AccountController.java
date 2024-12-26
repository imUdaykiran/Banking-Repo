package com.uday.banking_app.Controller;

import com.uday.banking_app.Exceptions.AccountException;
import com.uday.banking_app.RequestDto.AccountRequestDto;
import com.uday.banking_app.ResponseDto.AccountResponseDto;
import com.uday.banking_app.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController{
    @Autowired
    AccountService accountService;
    @PostMapping("/create")
    public ResponseEntity<AccountResponseDto> createAccount(@RequestBody AccountRequestDto accountRequestDto)
    {
        AccountResponseDto accountResponseDto=accountService.createAccount(accountRequestDto);
        return new ResponseEntity<>(accountResponseDto, HttpStatus.CREATED);
    }
    @GetMapping("/getAccount/{id}")
    public ResponseEntity<AccountResponseDto> getAccount(@PathVariable("id") int id) throws AccountException {
        AccountResponseDto accountResponseDto=accountService.getAccount(id);
        return new ResponseEntity<>(accountResponseDto,HttpStatus.FOUND);
    }
    @PutMapping("/deposit/{id}/{amount}")
    public ResponseEntity<AccountResponseDto> deposit(@PathVariable("id") int id,@PathVariable("amount") double amount) throws AccountException {
        AccountResponseDto accountResponseDto=accountService.deposit(id,amount);
        return new ResponseEntity<>(accountResponseDto,HttpStatus.ACCEPTED);
    }
    @PutMapping("/withdraw/{id}/{amount}")
    public ResponseEntity<AccountResponseDto> withdraw(@PathVariable("id") int id,@PathVariable("amount") double amount) throws Exception
    {
        AccountResponseDto accountResponseDto=accountService.withdraw(id,amount);
        return new ResponseEntity<>(accountResponseDto,HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<AccountResponseDto> delete(@PathVariable("id") int id) throws Exception
    {
        AccountResponseDto accountResponseDto=accountService.delete(id);
        return new ResponseEntity<>(accountResponseDto,HttpStatus.ACCEPTED);
    }
}
