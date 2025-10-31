package aq.example.dumbbank;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "balance")
public class BalanceEntity {

    @Id
    private Long id;

    private BigDecimal balance;

    public BigDecimal getBalance() { return balance; }

    public void setBalance(BigDecimal balance) { this.balance = balance; }

}
