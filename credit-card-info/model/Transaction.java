package com.example.graphql.model;

public class Transaction {
    private String transactionId;
    private String date;
    private double amount;
    private String description;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Transaction(String transactionId, String date, double amount, String description) {
        this.transactionId = transactionId;
        this.date = date;
        this.amount = amount;
        this.description = description;
    }
// Constructors, getters, and setters
}