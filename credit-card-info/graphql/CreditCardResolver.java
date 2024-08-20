package com.example.graphql;

import com.example.graphql.model.CreditCard;
import com.example.graphql.model.Rewards;
import com.example.graphql.model.Transaction;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class CreditCardResolver {

    @Autowired
    private CreditCardService creditCardService;

    @QueryMapping
    public CreditCard creditCard(@Argument String id) {
        return creditCardService.getCreditCard(id);
    }



}
