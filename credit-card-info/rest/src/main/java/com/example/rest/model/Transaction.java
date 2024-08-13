package com.example.rest.model;

public class Transaction {
    private String transactionId;
    private String date;

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private double amount;

    public String getTransactionId() {
        return transactionId;
    }

    public String getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public Transaction(String transactionId, String date, double amount, String description) {
        this.transactionId = transactionId;
        this.date = date;
        this.amount = amount;
        this.description = description;
    }

    private String description;

    // Constructor, Getters, and Setters
}