package org.example.banking_sys.controller;

import org.example.banking_sys.model.BankAccount;
import org.example.banking_sys.model.Transaction;
import org.example.banking_sys.service.BankService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank")

public class BankController {

    private final BankService bankService;

    public BankController(BankService bankService){
        this.bankService = bankService;
    }

    @PostMapping("/create")
    public BankAccount createAccount(@RequestBody BankAccount account){
        return bankService.createAccount(account);
    }

    @PostMapping("/deposit/{id}")
    public BankAccount deposit(@PathVariable Long id,
                               @RequestParam double amount){
        return bankService.deposit(id, amount);
    }

    @PostMapping("/withdraw/{id}")
    public BankAccount withdraw(@PathVariable Long id,
                                @RequestParam double amount){
        return bankService.withdraw(id, amount);
    }

    @GetMapping("/balance/{id}")
    public double getBalance(@PathVariable Long id){
        return bankService.getBalance(id);
    }

    @GetMapping("/transactions/{id}")
    public List<Transaction> getTransactions(@PathVariable Long id){
        return bankService.getTransactions(id);
    }
}
