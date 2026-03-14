package org.example.banking_sys.exception;

public class InsufficientBalanceException  extends RuntimeException  {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

