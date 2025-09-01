package com.gildedrose.ager;

import com.gildedrose.Item;

public class AgedItemAger implements AgerStrategy {
    @Override
    public void ageItem(Item item) {
        item.sellIn.decreaseSellIn();
        if (item.sellIn.hasExpired()) {
            item.quality.increaseQuality(2);
        } else {
            item.quality.increaseQuality(1);
        }
    }
}
