package com.example.graphql;

import com.example.graphql.model.CreditCard;
import com.example.graphql.model.Rewards;
import com.example.graphql.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditCardService {

    public CreditCard getCreditCard(String cardId) {
        // Fetch credit card details from the database
        return new CreditCard(cardId, "1234-5678-9876-5432", "Visa", 1200.50, 5000.00);
    }

    public List<Transaction> getTransactions(String cardId, int limit) {
        // Fetch transactions from the database
        return List.of(
                new Transaction("t1", "2024-01-01", -50.00, "Grocery Store"),
                new Transaction("t2", "2024-01-02", 200.00, "Salary")
        );
    }

    public Rewards getRewards(String cardId) {
        // Fetch rewards from the database
        return new Rewards(500, "Gold");
    }
}
