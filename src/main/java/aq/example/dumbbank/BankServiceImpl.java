package aq.example.dumbbank;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Service
public class BankServiceImpl implements BankService {

    public static final int TTL_SECONDS = 5;
    private final BankRepository bankRepository;
    private final RedisClient redisClient;

    @Transactional
    @Override
    public BigDecimal getBalance(long id) {

        BigDecimal value;
        Object cached = redisClient.getValue(String.valueOf(id));

        if (cached == null) {
            BalanceEntity balanceEntity = bankRepository.findById(id).orElseThrow();
            value = balanceEntity.getBalance();
            redisClient.saveValue(String.valueOf(id), String.valueOf(value), TTL_SECONDS);
        }
        else {
            value = BigDecimal.valueOf(Double.parseDouble(cached.toString()));
        }

        return value;
    }

    @Transactional
    @Override
    public BigDecimal updateBalance(long id, BigDecimal amount) {
        BalanceEntity balanceEntity = bankRepository.findById(id).orElseThrow();
        BigDecimal balance = balanceEntity.getBalance();
        BigDecimal add = balance.add(amount);
        balanceEntity.setBalance(add);

        redisClient.saveValue(String.valueOf(id), String.valueOf(add), TTL_SECONDS);

        return bankRepository.save(balanceEntity).getBalance();
    }
}
