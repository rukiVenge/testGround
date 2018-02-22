package com.company.object;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Transaction {

    private Long tranxId = new Long(0);
    private Date tranx_dateTime;
    private Double totalAmountDue = new Double(0);
    private Double amountReceive;
    private Double amountChange;
    private List<Item> itemList;


    public Transaction() {
        this.tranxId++;
    }

    public Transaction(Double amountReceive, List<Item> itemList) {
        this.tranxId++;
        this.tranx_dateTime = new Date();
        this.amountReceive = amountReceive;
        this.itemList = itemList;
    }

    //process payment
    public void processPayment(Double paymentAmount, List<Item> items, CashBox cashBox) throws Exception {
        //compute total amount due of product/item
        System.out.println("Processing payment...");
        for (Item item : items){
            this.totalAmountDue += item.getPrice();
        }

        setAmountReceive(paymentAmount);

        //check paymentAmount is sufficient
        if(getAmountReceive() >= getTotalAmountDue()){
            setTranx_dateTime(new Date());
            setAmountChange(getAmountReceive() - getTotalAmountDue());

            //display transaction details
            System.out.println("TranxID: " + getTranxId());
            System.out.println("Tranx Date Time: " + getTranx_dateTime());
            System.out.println("Total Amount Due: " + getTotalAmountDue());
            System.out.println("Payment: " + getAmountReceive());
            System.out.println("Change: " + getAmountChange());

        } else {
            System.out.println("Insufficient Payment amount.");
        }


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

    public Double getTotalAmountDue() {
        return totalAmountDue;
    }

    public void setTotalAmountDue(Double totalAmountDue) {
        this.totalAmountDue = totalAmountDue;
    }

    public Double getAmountReceive() {
        return amountReceive;
    }

    public void setAmountReceive(Double amountReceive) {
        this.amountReceive = amountReceive;
    }

    public Double getAmountChange() {
        return amountChange;
    }

    public void setAmountChange(Double amountChange) {
        this.amountChange = amountChange;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
}
