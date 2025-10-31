package aq.example.dumbbank;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

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


    public BalanceEntity(Long id, BigDecimal balance) {
        this.id = id;
        this.balance = balance;
    }

    public BalanceEntity() {
    }
}
