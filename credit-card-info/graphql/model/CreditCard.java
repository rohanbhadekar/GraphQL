package com.example.graphql.model;

public class CreditCard {
    private String cardId;
    private String cardNumber;
    private String cardType;
    private double balance;
    private double creditLimit;
    private String cardHolderName;
    private String expirationDate;
    private String billingAddress;
    private String issueDate;
    private double interestRate;
    private String status;

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

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public CreditCard(String cardId, String cardNumber, String cardType, double balance, double creditLimit,
                      String cardHolderName, String expirationDate, String billingAddress, String issueDate,
                      double interestRate, String status) {
        this.cardId = cardId;
        this.cardNumber = cardNumber;
        this.cardType = cardType;
        this.balance = balance;
        this.creditLimit = creditLimit;
        this.cardHolderName = cardHolderName;
        this.expirationDate = expirationDate;
        this.billingAddress = billingAddress;
        this.issueDate = issueDate;
        this.interestRate = interestRate;
        this.status = status;
    }

    // Getters and Setters for all properties
    // ...
}
