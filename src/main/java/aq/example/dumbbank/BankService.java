package aq.example.dumbbank;

import java.math.BigDecimal;

public interface BankService {

    BigDecimal getBalance(long id);

    BigDecimal updateBalance(long id, BigDecimal amount);

}
