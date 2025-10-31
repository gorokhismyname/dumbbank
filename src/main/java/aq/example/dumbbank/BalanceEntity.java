package aq.example.dumbbank;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "balance")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BalanceEntity {
    @Id
    private Long id;
    private BigDecimal balance;
}
