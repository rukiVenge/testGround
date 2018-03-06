package com.company.object;

import java.util.List;

public class RegularVendingMachine extends VendingMachine {
	


	public RegularVendingMachine(String vendingName){
		setVendingName(vendingName);
		setCashBox(new CashBox());
		setSupply(new Supply());
	}
	
	public RegularVendingMachine(String vendingName, CashBox cashBox, Supply supply){
		setVendingName(vendingName);
		setCashBox(cashBox);
		setSupply(supply);
	}
	
	@Override
	public void createNewTransaction(int payment, List<Item> items) throws Exception {
		// TODO Auto-generated method stub
		super.createNewTransaction(payment, items);
	}

	@Override
	public void fillSupply(List<Item> items) {
		// TODO Auto-generated method stub
		super.fillSupply(items);
	}

	@Override
	public void setItemPrice(Item item) {
		// TODO Auto-generated method stub
		super.setItemPrice(item);
	}

	@Override
	public void replenishCashBox(Payment cash) {
		// TODO Auto-generated method stub
		super.replenishCashBox(cash);
	}


	@Override
	public String getVendingName() {
		// TODO Auto-generated method stub
		return super.getVendingName();
	}

	@Override
	public void setVendingName(String vendingName) {
		// TODO Auto-generated method stub
		super.setVendingName(vendingName);
	}

	@Override
	public CashBox getCashBox() {
		// TODO Auto-generated method stub
		return super.getCashBox();
	}

	@Override
	public void setCashBox(CashBox cashBox) {
		// TODO Auto-generated method stub
		super.setCashBox(cashBox);
	}

	@Override
	public Supply getSupply() {
		// TODO Auto-generated method stub
		return super.getSupply();
	}

	@Override
	public void setSupply(Supply supply) {
		// TODO Auto-generated method stub
		super.setSupply(supply);
	}

	@Override
	public Payment getPayment() {
		// TODO Auto-generated method stub
		return super.getPayment();
	}

	@Override
	public void setPayment(Payment payment) {
		// TODO Auto-generated method stub
		super.setPayment(payment);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	@Override
	public void displayItems() {
		super.displayItems();
	}

	@Override
	public void dispenseItem(Supply supply, List<Item> itemList) {
		super.dispenseItem(supply, itemList);
	}

	public RegularVendingMachine() {
		super();
	}

	@Override
	public Double getTotalSales() {
		return super.getTotalSales();
	}

	@Override
	public Double getTotalCashAmount() {
		return super.getTotalCashAmount();
	}
}
