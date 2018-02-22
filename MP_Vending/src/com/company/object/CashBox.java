package com.company.object;

public class CashBox {

    private Double totalSalesAmount;
    private int PHP_200 = 0;
    private int PHP_100 = 0;
    private int PHP_50 = 0;
    private int PHP_20 = 0;
    private int PHP_10 = 0;
    private int PHP_5 = 0;
    private int PHP_1 = 0;

    public CashBox() {
    }

    public CashBox(Double totalSalesAmount, int PHP_200, int PHP_100, int PHP_50, int PHP_20, int PHP_10, int PHP_5, int PHP_1) {
        this.totalSalesAmount = totalSalesAmount;
        this.PHP_200 = PHP_200;
        this.PHP_100 = PHP_100;
        this.PHP_50 = PHP_50;
        this.PHP_20 = PHP_20;
        this.PHP_10 = PHP_10;
        this.PHP_5 = PHP_5;
        this.PHP_1 = PHP_1;
    }

    //compute totalCashAmount
    public Double computeTotalCashAmount(){

        return new Double ((PHP_200 * 200) +
                (PHP_100 * 100) +
                (PHP_50 * 50) +
                (PHP_20 * 20) +
                (PHP_10 * 10) +
                (PHP_5 * 5) +
                (PHP_1 * 5));
    }


    public Double getTotalSalesAmount() {
        return totalSalesAmount;
    }

    public void setTotalSalesAmount(Double totalSalesAmount) {
        this.totalSalesAmount = totalSalesAmount;
    }

    public int getPHP_200() {
        return PHP_200;
    }

    public void setPHP_200(int PHP_200) {
        this.PHP_200 = PHP_200;
    }

    public int getPHP_100() {
        return PHP_100;
    }

    public void setPHP_100(int PHP_100) {
        this.PHP_100 = PHP_100;
    }

    public int getPHP_50() {
        return PHP_50;
    }

    public void setPHP_50(int PHP_50) {
        this.PHP_50 = PHP_50;
    }

    public int getPHP_20() {
        return PHP_20;
    }

    public void setPHP_20(int PHP_20) {
        this.PHP_20 = PHP_20;
    }

    public int getPHP_10() {
        return PHP_10;
    }

    public void setPHP_10(int PHP_10) {
        this.PHP_10 = PHP_10;
    }

    public int getPHP_5() {
        return PHP_5;
    }

    public void setPHP_5(int PHP_5) {
        this.PHP_5 = PHP_5;
    }

    public int getPHP_1() {
        return PHP_1;
    }

    public void setPHP_1(int PHP_1) {
        this.PHP_1 = PHP_1;
    }
}
