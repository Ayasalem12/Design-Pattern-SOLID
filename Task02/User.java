package com;

public class User {
    private final String name;
    private final boolean isPremium;

    public User(String name, boolean isPremium) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
        this.isPremium = isPremium;
    }

    public String getName() {
        return name;
    }

    public boolean isPremium() {
        return isPremium;
    }
}