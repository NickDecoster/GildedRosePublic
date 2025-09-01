package com.gildedrose.ager;

import com.gildedrose.Item;

public class ConjuredItemAger implements AgerStrategy {
    @Override
    public void ageItem(Item item) {
        item.sellIn.decreaseSellIn();
        if (item.sellIn.hasExpired()) {
            item.quality.decreaseQuality(4);
        } else {
            item.quality.decreaseQuality(2);
        }
    }
}
