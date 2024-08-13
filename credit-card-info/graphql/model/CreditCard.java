package com.example.graphql.model;

public class CreditCard {
    private String cardId;
    private String cardNumber;
    private String cardType;
    private double balance;

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public CreditCard(String cardId, String cardNumber, String cardType, double balance, double creditLimit) {
        this.cardId = cardId;
        this.cardNumber = cardNumber;
        this.cardType = cardType;
        this.balance = balance;
        this.creditLimit = creditLimit;
    }

    private double creditLimit;

    // Constructors, getters, and setters
}