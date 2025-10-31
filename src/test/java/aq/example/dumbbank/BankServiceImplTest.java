package aq.example.dumbbank;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class BankServiceImplTest {

    @Mock
    BankRepository bankRepository;

    @Mock
    RedisClient redisClient;

    @InjectMocks
    BankServiceImpl bankService;

    @Test
    public void getBalance_shouldReturn_valid_Balance() {
        BigDecimal balance1 = BigDecimal.valueOf(100);
        long id = 2L;
        Mockito.when(bankRepository.findById(id)).thenReturn(Optional.of(new BalanceEntity(id, balance1)));
        BigDecimal balance = bankService.getBalance(id);
        assertEquals(balance1, balance);

    }


}