package com.example.graphql.model;

public class Transaction {
    private String transactionId;
    private String date;
    private double amount;
    private String description;
    private String merchantName;
    private String category;
    private String paymentMethod;
    private String location;
    private String currency;
    private boolean isRefundable;

    public Transaction(String transactionId, String date, double amount, String description, String merchantName,
                       String category, String paymentMethod, String location, String currency, boolean isRefundable) {
        this.transactionId = transactionId;
        this.date = date;
        this.amount = amount;
        this.description = description;
        this.merchantName = merchantName;
        this.category = category;
        this.paymentMethod = paymentMethod;
        this.location = location;
        this.currency = currency;
        this.isRefundable = isRefundable;
    }

    // Getters and Setters for all properties
    // ...

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

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public boolean isRefundable() {
        return isRefundable;
    }

    public void setRefundable(boolean refundable) {
        isRefundable = refundable;
    }
}
