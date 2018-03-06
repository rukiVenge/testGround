package com.company.object;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Transaction {

    private Long tranxId = new Long(0);
    private Date tranx_dateTime;
    private int totalAmountDue = 0;
    private int amountReceive;
    private int amountChange = 0;
    private List<Item> itemList;


    public Transaction() {
        this.tranxId++;
    }

    public Transaction(int amountReceive, List<Item> itemList) {
        this.tranxId++;
        this.tranx_dateTime = new Date();
        this.amountReceive = amountReceive;
        this.itemList = itemList;
    }

    //process payment
    public int processPayment(int paymentAmount, List<Item> items, CashBox cashBox) throws Exception {
        //compute total amount due of product/item
        System.out.println("Processing payment...");
        for (Item item : items){
            this.totalAmountDue += item.getPrice().intValue();
        }

        setAmountReceive(paymentAmount);

        //check paymentAmount is sufficient
        if(getAmountReceive() >= getTotalAmountDue()){

            setTranx_dateTime(new Date());
            setAmountChange(getAmountReceive() - getTotalAmountDue());

            //set sales amount in cashbox
            cashBox.setTotalSalesAmount(new Double(getTotalAmountDue()));

            //display transaction details
            System.out.println("TranxID: " + getTranxId());
            System.out.println("Tranx Date Time: " + getTranx_dateTime());
            System.out.println("Total Amount Due: " + getTotalAmountDue());
            System.out.println("Payment: " + getAmountReceive());
            System.out.println("Change: " + getAmountChange());

        } else {
            System.out.println("Insufficient Payment amount.");
        }

        return getAmountChange();
    }

    //deposit cash to cashBox
    public CashBox depositCash(Payment payment){

        return null;
    }

    public Long getTranxId() {
        return tranxId;
    }

    public void setTranxId(Long tranxId) {
        this.tranxId = tranxId;
    }

    public Date getTranx_dateTime() {
        return tranx_dateTime;
    }

    public void setTranx_dateTime(Date tranx_dateTime) {
        this.tranx_dateTime = tranx_dateTime;
    }

    public int getTotalAmountDue() {
        return totalAmountDue;
    }

    public void setTotalAmountDue(int totalAmountDue) {
        this.totalAmountDue = totalAmountDue;
    }

    public int getAmountReceive() {
        return amountReceive;
    }

    public void setAmountReceive(int amountReceive) {
        this.amountReceive = amountReceive;
    }

    public int getAmountChange() {
        return amountChange;
    }

    public void setAmountChange(int amountChange) {
        this.amountChange = amountChange;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
}