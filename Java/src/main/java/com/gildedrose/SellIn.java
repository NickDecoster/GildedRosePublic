package com.gildedrose;

public class SellIn {
    private int sellIn;
    private final static int EXPIRED_SELL_IN_VALUE = 0;

    public SellIn(int initialSellIn) {
        this.sellIn = initialSellIn;
    }

    public void decreaseSellIn() {
        this.sellIn--;
    }

    public int getSellIn() {
        return sellIn;
    }

    public boolean hasExpired() {
        return sellIn < EXPIRED_SELL_IN_VALUE;
    }
}
