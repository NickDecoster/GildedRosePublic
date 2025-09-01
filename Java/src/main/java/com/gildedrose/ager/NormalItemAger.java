package com.gildedrose.ager;

import com.gildedrose.Item;

public class NormalItemAger implements AgerStrategy {
    @Override
    public void ageItem(Item item) {
        item.sellIn.decreaseSellIn();
        if (item.sellIn.hasExpired()) {
            item.quality.decreaseQuality(2);
        } else {
            item.quality.decreaseQuality(1);
        }
    }
}
