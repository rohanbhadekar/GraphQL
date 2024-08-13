package com.example.rest;

import com.example.rest.model.CreditCard;
import com.example.rest.model.Rewards;
import com.example.rest.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/creditcards")
public class CreditCardController {

    @Autowired
    private CreditCardService creditCardService;

    @GetMapping("/{cardId}")
    public ResponseEntity<CreditCard> getCreditCard(@PathVariable String cardId) {
        return ResponseEntity.ok(creditCardService.getCreditCard(cardId));
    }

//http://localhost:8090/api/creditcards/transactions?limit=5
    @GetMapping("/{cardId}/transactions")
    public ResponseEntity<List<Transaction>> getTransactions(@PathVariable String cardId, @RequestParam int limit) {
        return ResponseEntity.ok(creditCardService.getTransactions(cardId, limit));
    }

    @GetMapping("/{cardId}/rewards")
    public ResponseEntity<Rewards> getRewards(@PathVariable String cardId) {
        return ResponseEntity.ok(creditCardService.getRewards(cardId));
    }
}
