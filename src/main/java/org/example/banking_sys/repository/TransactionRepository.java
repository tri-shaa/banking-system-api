package org.example.banking_sys.repository;

import org.example.banking_sys.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TransactionRepository  extends JpaRepository<Transaction, Long>
{
    List<Transaction> findByAccountId(Long accountId);
}
