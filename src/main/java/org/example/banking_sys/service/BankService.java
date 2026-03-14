package org.example.banking_sys.service;

import org.example.banking_sys.model.BankAccount;
import org.example.banking_sys.model.Transaction;
import org.example.banking_sys.repository.BankAccountRepository;
import org.example.banking_sys.repository.TransactionRepository;
import org.example.banking_sys.exception.InsufficientBalanceException;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service

public class BankService {

    private final BankAccountRepository accountRepo;
    private final TransactionRepository transactionRepo;

    public BankService(BankAccountRepository accountRepo,
                       TransactionRepository transactionRepo) {
        this.accountRepo = accountRepo;
        this.transactionRepo = transactionRepo;
    }

    public BankAccount createAccount(BankAccount account) {
        return accountRepo.save(account);
    }

    public BankAccount deposit(Long id, double amount) {

        BankAccount account = accountRepo.findById(id)
                .orElseThrow();

        account.setBalance(account.getBalance() + amount);
        accountRepo.save(account);

        Transaction tx = new Transaction(
                null, id, "DEPOSIT", amount, LocalDateTime.now());

        transactionRepo.save(tx);

        return account;
    }

    public BankAccount withdraw(Long id, double amount) {

        BankAccount account = accountRepo.findById(id)
                .orElseThrow();

        if(account.getBalance() < amount){
            throw new InsufficientBalanceException(
                    "Not enough balance");
        }

        account.setBalance(account.getBalance() - amount);
        accountRepo.save(account);

        Transaction tx = new Transaction(
                null, id, "WITHDRAW", amount, LocalDateTime.now());

        transactionRepo.save(tx);

        return account;
    }

    public double getBalance(Long id){
        return accountRepo.findById(id)
                .orElseThrow()
                .getBalance();
    }

    public List<Transaction> getTransactions(Long id){
        return transactionRepo.findByAccountId(id);
    }
}
