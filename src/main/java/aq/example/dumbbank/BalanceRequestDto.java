package aq.example.dumbbank;

import java.math.BigDecimal;

public record BalanceRequestDto(
        long id, BigDecimal amount
) {
}
