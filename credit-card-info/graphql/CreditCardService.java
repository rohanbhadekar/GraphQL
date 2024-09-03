package com.example.graphql;

import com.example.graphql.model.CreditCard;
import com.example.graphql.model.Rewards;
import com.example.graphql.model.Transaction;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

@Service
public class CreditCardService {

    private final Map<String, CreditCard> creditCards;
    private final Map<String, List<Transaction>> transactions;
    private final Map<String, Rewards> rewards;

    public CreditCardService() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        // Read credit cards from JSON
        creditCards = objectMapper.readValue(
                Files.readString(Paths.get("data/creditCards.json")),
                new TypeReference<Map<String, CreditCard>>() {}
        );

        // Read transactions from JSON
        transactions = objectMapper.readValue(
                Files.readString(Paths.get("data/transactions.json")),
                new TypeReference<Map<String, List<Transaction>>>() {}
        );

        // Read rewards from JSON
        rewards = objectMapper.readValue(
                Files.readString(Paths.get("data/rewards.json")),
                new TypeReference<Map<String, Rewards>>() {}
        );
    }

    public CreditCard getCreditCard(String cardId) {
        return creditCards.getOrDefault(cardId, new CreditCard(
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
        ));
    }

    public List<Transaction> getTransactions(String cardId, int limit) {
        List<Transaction> cardTransactions = transactions.getOrDefault(cardId, List.of());

        if (limit > 0) {
            return cardTransactions.stream().limit(limit).toList();
        }
        return cardTransactions;
    }

    public Rewards getRewards(String cardId) {
        return rewards.getOrDefault(cardId, new Rewards(
                0,
                "No Rewards",
                0.0,
                "N/A",
                false,
                "N/A",
                0
        ));
    }
}
