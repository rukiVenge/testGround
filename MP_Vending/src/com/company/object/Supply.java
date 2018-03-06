package com.company.object;

import java.util.ArrayList;
import java.util.List;

public class Supply {
    //this will hold the current count of the items
    //this will also holds the location in the vending machine

    private List<Item> itemList = new ArrayList<Item>();

    public Supply() {
        super();
    }

    public Supply(List<Item> itemList) {
        super();
        this.itemList = itemList;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }



}