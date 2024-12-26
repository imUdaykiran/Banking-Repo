package com.uday.banking_app.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
//@RequiredArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int accountNo;
    private String name;
    private double balance;




    public Account(String name, double balance) {
        this.name=name;
        this.balance=balance;
    }
}
