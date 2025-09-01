package com.gildedrose.ager;

import com.gildedrose.Item;

public class BackstagePassAger implements AgerStrategy {
    @Override
    public void ageItem(Item item) {
        item.sellIn.decreaseSellIn();
        if (item.sellIn.hasExpired()) {
            item.quality.setQualityToZero();
        }
        else if (item.sellIn.getSellIn() < 5) {
            item.quality.increaseQuality(3);
        }
        else if (item.sellIn.getSellIn() < 10) {
            item.quality.increaseQuality(2);
        }
        else {
            item.quality.increaseQuality(1);
        }
    }
}
