package com.example.graphql.model;
public class Rewards {
    private int points;
    private String tier;

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

    public Rewards(int points, String tier) {
        this.points = points;
        this.tier = tier;
    }
// Constructors, getters, and setters
}