package com.company.object;

public class Item {

    private String description;
    private int calories;
    private Double price;
    private int noOFStocks = 0;

    public Item() {
    }

    public Item(String description, int calories, Double price) {
        this.description = description;
        this.calories = calories;
        this.price = price;
    }

    public Item(String description, int calories, Double price, int noOfStocks) {
        this.description = description;
        this.calories = calories;
        this.price = price;
        this.noOFStocks = noOfStocks;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getNoOFStocks() {
        return noOFStocks;
    }

    public void setNoOFStocks(int noOFStocks) {
        this.noOFStocks = noOFStocks;
    }
}