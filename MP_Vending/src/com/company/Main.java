package com.company;

import com.company.object.Item;
import com.company.object.Transaction;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {


        List<Item> itemList = new ArrayList<Item>();
        itemList.add(new Item("Apple",100,new Double(50)));
        itemList.add(new Item("Orange",100,new Double(10)));

        Transaction tr = new Transaction();
        tr.processPayment(new Double(100),itemList);
    }
}
