package com.example.graphql.model;
import com.example.graphql.CreditCardService;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class GraphQLDataFetchers {
    @Autowired
    private CreditCardService creditCardService;

    public DataFetcher<CreditCard> getCreditCardDataFetcher() {
        return new DataFetcher<CreditCard>() {
            @Override
            public CreditCard get(DataFetchingEnvironment environment) {
                String cardId = environment.getArgument("id");
                return creditCardService.getCreditCard(cardId);
            }
        };
    }

    public DataFetcher<List<Transaction>> getTransactionsDataFetcher() {
        return new DataFetcher<List<Transaction>>() {
            @Override
            public List<Transaction> get(DataFetchingEnvironment environment) {
                String cardId = environment.getArgument("cardId");
                int limit = environment.getArgument("limit");
                return creditCardService.getTransactions(cardId, limit);
            }
        };
    }
    public DataFetcher<Rewards> getRewardsDataFetcher() {
        return new DataFetcher<Rewards>() {
            @Override
            public Rewards get(DataFetchingEnvironment environment) {
                String cardId = environment.getArgument("cardId");
                return creditCardService.getRewards(cardId);
            }
        };
    }
}
