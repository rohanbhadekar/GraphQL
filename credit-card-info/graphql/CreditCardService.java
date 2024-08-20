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
            case "1" -> new CreditCard(
                    "1",
                    "1234-5678-9876-5432",
                    "Visa",
                    1200.50,
                    5000.00,
                    "John Doe",
                    "12/26",
                    "123 Main St, Cityville",
                    "01/21",
                    15.99,
                    "Active"
            );
            case "2" -> new CreditCard(
                    "2",
                    "8765-4321-1234-5678",
                    "MasterCard",
                    3200.75,
                    10000.00,
                    "Jane Smith",
                    "11/25",
                    "456 Elm St, Townsville",
                    "02/20",
                    13.99,
                    "Active"
            );
            case "3" -> new CreditCard(
                    "3",
                    "4321-8765-5678-1234",
                    "American Express",
                    2200.00,
                    7500.00,
                    "Alice Johnson",
                    "10/24",
                    "789 Oak St, Villageville",
                    "03/19",
                    18.99,
                    "Inactive"
            );
            default -> new CreditCard(
                    cardId,
                    "0000-0000-0000-0000",
                    "Unknown",
                    0.00,
                    0.00,
                    "Unknown",
                    "N/A",
                    "N/A",
                    "N/A",
                    0.00,
                    "Inactive"
            );
        };
    }

    public List<Transaction> getTransactions(String cardId, int limit) {
        // Dummy data for transactions
        List<Transaction> transactions = switch (cardId) {
            case "1" -> List.of(
                    new Transaction("t1", "2024-01-01", -50.00, "Grocery Store", "SuperMart", "Groceries", "Credit Card", "Cityville", "USD", true),
                    new Transaction("t2", "2024-01-02", 200.00, "Salary", "ABC Corp", "Income", "Bank Transfer", "Cityville", "USD", false),
                    new Transaction("t3", "2024-01-03", -100.00, "Electronics Store", "TechShop", "Electronics", "Credit Card", "Cityville", "USD", true),
                    new Transaction("t4", "2024-01-04", -30.00, "Coffee Shop", "Café Bliss", "Food & Drink", "Credit Card", "Cityville", "USD", true),
                    new Transaction("t5", "2024-01-05", -75.00, "Restaurant", "DineOut", "Food & Drink", "Credit Card", "Cityville", "USD", true)
            );
            case "2" -> List.of(
                    new Transaction("t6", "2024-01-01", -150.00, "Furniture Store", "HomeGoods", "Furniture", "Credit Card", "Townsville", "USD", true),
                    new Transaction("t7", "2024-01-02", 250.00, "Bonus", "XYZ Corp", "Income", "Bank Transfer", "Townsville", "USD", false),
                    new Transaction("t8", "2024-01-03", -200.00, "Clothing Store", "FashionHub", "Clothing", "Credit Card", "Townsville", "USD", true),
                    new Transaction("t9", "2024-01-04", -20.00, "Movie Theater", "Cineplex", "Entertainment", "Credit Card", "Townsville", "USD", true),
                    new Transaction("t10", "2024-01-05", -100.00, "Gas Station", "FuelStop", "Fuel", "Credit Card", "Townsville", "USD", true)
            );
            case "3" -> List.of(
                    new Transaction("t11", "2024-01-01", -500.00, "Online Purchase", "E-Shop", "Electronics", "Credit Card", "Online", "USD", true),
                    new Transaction("t12", "2024-01-02", 1000.00, "Freelance Work", "Freelancer", "Income", "Bank Transfer", "Villageville", "USD", false),
                    new Transaction("t13", "2024-01-03", -250.00, "Travel Booking", "TravelCo", "Travel", "Credit Card", "Villageville", "USD", true),
                    new Transaction("t14", "2024-01-04", -40.00, "Grocery Store", "LocalMarket", "Groceries", "Credit Card", "Villageville", "USD", true),
                    new Transaction("t15", "2024-01-05", -300.00, "Hotel Booking", "StayInn", "Travel", "Credit Card", "Villageville", "USD", true)
            );
            default -> List.of();
        };

        if (limit > 0) {
            return transactions.stream().limit(limit).toList();
        }
        return transactions;
    }

    public Rewards getRewards(String cardId) {
        // Dummy data for rewards
        return switch (cardId) {
            case "1" -> new Rewards(
                    500,
                    "Gold",
                    1.5,
                    "2025-12-31",
                    true,
                    "2024-06-15",
                    1000
            );
            case "2" -> new Rewards(
                    1000,
                    "Platinum",
                    2.0,
                    "2025-12-31",
                    true,
                    "2024-06-01",
                    2000
            );
            case "3" -> new Rewards(
                    750,
                    "Silver",
                    1.0,
                    "2025-12-31",
                    false,
                    "2024-06-10",
                    1500
            );
            default -> new Rewards(
                    0,
                    "No Rewards",
                    0.0,
                    "N/A",
                    false,
                    "N/A",
                    0
            );
        };
    }
}
