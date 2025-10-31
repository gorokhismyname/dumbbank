package aq.example.dumbbank;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("dumbbank/api/v1")
public class BankController {

    private final BankService bankService;

    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<BigDecimal> getBalance(@PathVariable Long id) {
        BigDecimal balance = bankService.getBalance(id);
        return ResponseEntity.ok(balance);
    }

    @PatchMapping
    public ResponseEntity<BigDecimal> updateBalance(@RequestBody BalanceRequestDto requestDto) {
        BigDecimal bigDecimal = bankService.updateBalance(requestDto.id(), requestDto.amount());
        return ResponseEntity.ok(bigDecimal);
    }

}
