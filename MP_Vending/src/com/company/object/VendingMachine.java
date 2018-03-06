package com.company.object;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {

    private String vendingName;
    private CashBox cashBox;
    private Supply supply;
    private Payment payment;



    public VendingMachine() {
        super();
        this.cashBox = new CashBox();
        this.supply = new Supply();
    }


    public VendingMachine(String vendingName, CashBox cashBox, Supply supply) {
        super();
        this.vendingName = vendingName;
        this.cashBox = cashBox;
        this.supply = supply;
    }


    //start a vending transaction
    public void createNewTransaction(int amount, List<Item> items) throws Exception{
        Transaction tranx =  new Transaction();
        CashBox cb = getCashBox();

        //dispense item from the vending machine
        dispenseItem(supply, items);


        //processPayment
        int change = tranx.processPayment(amount,
                items, this.cashBox);

        if(change != 0){
            System.out.println("Dispensing change(" + change + ")...");

            //remove certain denomination from the cash box
            //change >= 200
            if(change >= 200 && (change / 200)>1){
                cb.setPHP_200(cb.getPHP_200() - (change/200));
                System.out.println("Dispensing " + (change/200) * 200 + " pesos..." );
                change = change % 200;
            }

            //change >= 100 but less than 200
            if(change >= 100 && (change / 100)>1){
                cb.setPHP_100(cb.getPHP_100() - (change/100));
                System.out.println("Dispensing " + (change/100) * 100 + " pesos..." );
                change = change % 100;
            }

            //change >= 50 but less than 100
            if(change >= 50 && (change / 50)>1){
                cb.setPHP_50(cb.getPHP_50() - (change/50));
                System.out.println("Dispensing " + (change/50) * 50 + " pesos..." );
                change = change % 50;
            }

            //change >= 20 but less than 50
            if(change >= 20 && (change / 20)>1){
                cb.setPHP_20(cb.getPHP_20() - (change/20));
                System.out.println("Dispensing " + (change/20) * 20 + " pesos..." );
                change = change % 20;
            }

            //change >= 10 but less than 20
            if(change >= 10 && (change / 10)>1){
                cb.setPHP_10(cb.getPHP_10() - (change/10));
                System.out.println("Dispensing " + (change/10) * 10 + " pesos..." );
                change = change % 10;
            }

            //change >= 5 but less than 10
            if(change >= 5 && (change / 5)>1){
                cb.setPHP_5(cb.getPHP_5() - (change/5));
                System.out.println("Dispensing " + (change/5) * 5 + " pesos..." );
                change = change % 5;
            }

            //change >= 1 but less than 5
            if(change >= 1 && change>1){
                cb.setPHP_1(cb.getPHP_1() - change);
                System.out.println("Dispensing " + change + " peso(s)..." );
            }

        }
    }

    //restock items
    public void fillSupply(List<Item> items){

        List<Item> itemListToUpdate = supply.getItemList();
        System.out.println("Replenish vending machine's supply...");
        for(Item item : items){

            int indx = 0;
            int counter = 0;

            //search supply for the corresponding item
            for(Item itemFromSupply : itemListToUpdate){
                if(item.getDescription() == itemFromSupply.getDescription()){
                    indx = counter;
                    counter = 0;
                    break;
                }
                counter++;
            }

            Item updatedItem = itemListToUpdate.get(indx);
            updatedItem.setNoOFStocks(updatedItem.getNoOFStocks() + item.getNoOFStocks());
        }

        System.out.println("Replenish supply was completed...");

    }

    //set item price
    public void setItemPrice(Item item){
        Item updatedItem = null;
        List<Item> itemsToUpdate = supply.getItemList();
        int indx = 0;
        int counter = 0;

        //get item from the supply
        for(Item itemFromSupply : itemsToUpdate){
            if(itemFromSupply.getDescription() == item.getDescription()){
                indx = counter;
                updatedItem = itemFromSupply;
                counter = 0;
            }

            counter++;
        }

        //update item price
        System.out.println("Updating " + updatedItem.getDescription() + " price to " +
            item.getPrice() + "...");
        updatedItem.setPrice(item.getPrice());
        itemsToUpdate.remove(indx);
        supply.setItemList(itemsToUpdate);
        System.out.println("Price updated was successfull..");

    }

    //display items in vending machine
    public void displayItems(){
        int counter = 0;
        System.out.println("#\t\tName\t\tCalories\t\tPrice\t\tAvailability");
        for(Item item : supply.getItemList()){
            System.out.println(counter + "\t\t" + item.getDescription() + "\t\t" +
                item.getCalories() + "\t\t" + item.getPrice() + "\t\t" +
                    (item.getNoOFStocks()==0?"Not Available":"Available"));
            counter++;
        }
    }

    //get totalSales
    public Double getTotalSales(){
        return cashBox.getTotalSalesAmount();
    }

    //get current cashBox cash
    public Double getTotalCashAmount(){
        return cashBox.computeTotalCashAmount();
    }


    //dispense item from supply
    public void dispenseItem(Supply supply, List<Item> itemList){
        List<Item> itemsFromSupply = supply.getItemList();

        //deduct items selected to the supply
        for(Item item : itemList){
            int indx = 0;
            int counter = 0;

            //search corresponding item from the supply list
            for(Item itemFromList : itemsFromSupply){

                if(item.getDescription() == item.getDescription()){
                    indx = counter;
                    counter = 0;
                    break;
                }
                counter++;

            }

            Item updatedItem = itemsFromSupply.get(indx);
            updatedItem.setNoOFStocks(updatedItem.getNoOFStocks() - 1);

            //dispense item
            System.out.println("Dispensing " + updatedItem.getDescription() + " ...");

            //remove old item and set update item back to the supply
            itemsFromSupply.remove(indx);
            itemsFromSupply.add(updatedItem);
            supply.setItemList(itemsFromSupply);

        }

    }

    //replenish CashBox
    public void replenishCashBox(Payment cash){
        cashBox.setPHP_200(cashBox.getPHP_200() + (cash.getC200()==0?0:cash.getC200()));
        cashBox.setPHP_100(cashBox.getPHP_100() + (cash.getC100()==0?0:cash.getC100()));
        cashBox.setPHP_50(cashBox.getPHP_50() + (cash.getC50()==0?0:cash.getC50()));
        cashBox.setPHP_20(cashBox.getPHP_20() + (cash.getC20()==0?0:cash.getC20()));
        cashBox.setPHP_10(cashBox.getPHP_10() + (cash.getC10()==0?0:cash.getC10()));
        cashBox.setPHP_5(cashBox.getPHP_5() + (cash.getC5()==0?0:cash.getC5()));
        cashBox.setPHP_1(cashBox.getPHP_1() + (cash.getC1()==0?0:cash.getC1()));
    }


    public String getVendingName() {
        return vendingName;
    }


    public void setVendingName(String vendingName) {
        this.vendingName = vendingName;
    }


    public CashBox getCashBox() {
        return cashBox;
    }


    public void setCashBox(CashBox cashBox) {
        this.cashBox = cashBox;
    }


    public Supply getSupply() {
        return supply;
    }


    public void setSupply(Supply supply) {
        this.supply = supply;
    }


    public Payment getPayment() {
        return payment;
    }


    public void setPayment(Payment payment) {
        this.payment = payment;
    }



    public String toString() {
        return "VendingMachine [vendingName=" + vendingName + ", cashBox=" + cashBox + ", supply=" + supply
                + ", payment=" + payment + ", toString()=" + super.toString() + "]";
    }



}