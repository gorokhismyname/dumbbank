package aq.example.dumbbank;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<BalanceEntity, Long> {
}
