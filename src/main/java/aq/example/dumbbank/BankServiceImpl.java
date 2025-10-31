package aq.example.dumbbank;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class BankServiceImpl implements BankService {

    private final BankRepository bankRepository;

    public BankServiceImpl(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    @Override
    public BigDecimal getBalance(long id) {
        BalanceEntity balanceEntity = bankRepository.findById(id).orElseThrow();
        return balanceEntity.getBalance();
    }

    @Override
    public BigDecimal updateBalance(long id, BigDecimal amount) {
        BalanceEntity balanceEntity = bankRepository.findById(id).orElseThrow();
        BigDecimal balance = balanceEntity.getBalance();
        BigDecimal add = balance.add(amount);
        balanceEntity.setBalance(add);
        return bankRepository.save(balanceEntity).getBalance();
    }
}
