package com.droidd.model;

public enum ShippingRates {
    RO(1),
    UK(2),
    US(3);

    private int rate;

    ShippingRates(int rate) {
        this.rate = rate;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
