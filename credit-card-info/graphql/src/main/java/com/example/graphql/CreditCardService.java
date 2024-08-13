package com.example.graphql;

import com.example.graphql.model.CreditCard;
import com.example.graphql.model.Rewards;
import com.example.graphql.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditCardService {

    public CreditCard getCreditCard(String cardId) {
        // Dummy data for credit card details
        return switch (cardId) {
            case "1" -> new CreditCard("1", "1234-5678-9876-5432", "Visa", 1200.50, 5000.00);
            case "2" -> new CreditCard("2", "8765-4321-1234-5678", "MasterCard", 3200.75, 10000.00);
            case "3" -> new CreditCard("3", "4321-8765-5678-1234", "American Express", 2200.00, 7500.00);
            default -> new CreditCard(cardId, "0000-0000-0000-0000", "Unknown", 0.00, 0.00);
        };
    }

    public List<Transaction> getTransactions(String cardId, int limit) {
        // Dummy data for transactions
        List<Transaction> transactions = switch (cardId) {
            case "1" -> List.of(
                    new Transaction("t1", "2024-01-01", -50.00, "Grocery Store"),
                    new Transaction("t2", "2024-01-02", 200.00, "Salary"),
                    new Transaction("t3", "2024-01-03", -100.00, "Electronics Store"),
                    new Transaction("t4", "2024-01-04", -30.00, "Coffee Shop"),
                    new Transaction("t5", "2024-01-05", -75.00, "Restaurant")
            );
            case "2" -> List.of(
                    new Transaction("t6", "2024-01-01", -150.00, "Furniture Store"),
                    new Transaction("t7", "2024-01-02", 250.00, "Bonus"),
                    new Transaction("t8", "2024-01-03", -200.00, "Clothing Store"),
                    new Transaction("t9", "2024-01-04", -20.00, "Movie Theater"),
                    new Transaction("t10", "2024-01-05", -100.00, "Gas Station")
            );
            case "3" -> List.of(
                    new Transaction("t11", "2024-01-01", -500.00, "Online Purchase"),
                    new Transaction("t12", "2024-01-02", 1000.00, "Freelance Work"),
                    new Transaction("t13", "2024-01-03", -250.00, "Travel Booking"),
                    new Transaction("t14", "2024-01-04", -40.00, "Grocery Store"),
                    new Transaction("t15", "2024-01-05", -300.00, "Hotel Booking")
            );
            default -> List.of();
        };

        if ( limit > 0) {
            return transactions.stream().limit(limit).toList();
        }
        return transactions;
    }

    public Rewards getRewards(String cardId) {
        // Dummy data for rewards
        return switch (cardId) {
            case "1" -> new Rewards(500, "Gold");
            case "2" -> new Rewards(1000, "Platinum");
            case "3" -> new Rewards(750, "Silver");
            default -> new Rewards(0, "No Rewards");
        };
    }
}
