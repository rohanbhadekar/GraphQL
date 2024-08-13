package com.example.graphql;

import com.example.graphql.model.CreditCard;
import com.example.graphql.model.Rewards;
import com.example.graphql.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
public class CreditCardFieldResolvers {

    @Autowired
    private CreditCardService creditCardService;

    @SchemaMapping(typeName = "CreditCard", field = "transactions")
    public List<Transaction> getTransactions(CreditCard creditCard, int limit) {
        return creditCardService.getTransactions(creditCard.getCardId(), limit);
    }

    @SchemaMapping(typeName = "CreditCard", field = "rewards")
    public Rewards getRewards(CreditCard creditCard) {
        return creditCardService.getRewards(creditCard.getCardId());
    }
}
