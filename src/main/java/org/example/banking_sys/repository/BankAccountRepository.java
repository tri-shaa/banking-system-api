package org.example.banking_sys.repository;

import org.example.banking_sys.model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long>{

}
