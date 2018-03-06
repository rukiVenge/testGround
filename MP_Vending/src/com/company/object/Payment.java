package com.company.object;

public class Payment {

    private int c200;
    private int c100;
    private int c50;
    private int c20;
    private int c10;
    private int c5;
    private int c1;

    public Payment() {
    }

    public Payment(int c200, int c100, int c50, int c20, int c10, int c5, int c1) {
        this.c200 = c200;
        this.c100 = c100;
        this.c50 = c50;
        this.c20 = c20;
        this.c10 = c10;
        this.c5 = c5;
        this.c1 = c1;
    }

    public int getTotalPayment(){
        return ((c200 * 200) +
                (c100 * 100) +
                (c50 * 50) +
                (c20 * 20) +
                (c10 * 10) +
                (c5 * 5) +
                (c1 * 5));
    }

    public int getC200() {
        return c200;
    }

    public void setC200(int c200) {
        this.c200 = c200;
    }

    public int getC100() {
        return c100;
    }

    public void setC100(int c100) {
        this.c100 = c100;
    }

    public int getC50() {
        return c50;
    }

    public void setC50(int c50) {
        this.c50 = c50;
    }

    public int getC20() {
        return c20;
    }

    public void setC20(int c20) {
        this.c20 = c20;
    }

    public int getC10() {
        return c10;
    }

    public void setC10(int c10) {
        this.c10 = c10;
    }

    public int getC5() {
        return c5;
    }

    public void setC5(int c5) {
        this.c5 = c5;
    }

    public int getC1() {
        return c1;
    }

    public void setC1(int c1) {
        this.c1 = c1;
    }
}