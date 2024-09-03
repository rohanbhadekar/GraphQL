package com.example.graphql.model;

public class Rewards {
    private int points;
    private String tier;
    private double cashBackRate;
    private String rewardsExpiryDate;
    private boolean bonusEligible;
    private String lastRedeemedDate;
    private int pointsToNextTier;

    public Rewards(int points, String tier, double cashBackRate, String rewardsExpiryDate, boolean bonusEligible,
                   String lastRedeemedDate, int pointsToNextTier) {
        this.points = points;
        this.tier = tier;
        this.cashBackRate = cashBackRate;
        this.rewardsExpiryDate = rewardsExpiryDate;
        this.bonusEligible = bonusEligible;
        this.lastRedeemedDate = lastRedeemedDate;
        this.pointsToNextTier = pointsToNextTier;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public double getCashBackRate() {
        return cashBackRate;
    }

    public void setCashBackRate(double cashBackRate) {
        this.cashBackRate = cashBackRate;
    }

    public String getRewardsExpiryDate() {
        return rewardsExpiryDate;
    }

    public void setRewardsExpiryDate(String rewardsExpiryDate) {
        this.rewardsExpiryDate = rewardsExpiryDate;
    }

    public boolean isBonusEligible() {
        return bonusEligible;
    }

    public void setBonusEligible(boolean bonusEligible) {
        this.bonusEligible = bonusEligible;
    }

    public String getLastRedeemedDate() {
        return lastRedeemedDate;
    }

    public void setLastRedeemedDate(String lastRedeemedDate) {
        this.lastRedeemedDate = lastRedeemedDate;
    }

    public int getPointsToNextTier() {
        return pointsToNextTier;
    }

    public void setPointsToNextTier(int pointsToNextTier) {
        this.pointsToNextTier = pointsToNextTier;
    }

    // Getters and Setters for all properties
    // ...
}
