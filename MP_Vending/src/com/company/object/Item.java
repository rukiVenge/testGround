package com.company.object;

public class Item {

    private Long itemId = new Long(0);
    private String description;
    private int calories;
    private Double price;

    public Item() {
        this.itemId++;
    }

    public Item(String description, int calories, Double price) {
        this.itemId++;
        this.description = description;
        this.calories = calories;
        this.price = price;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
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
}
