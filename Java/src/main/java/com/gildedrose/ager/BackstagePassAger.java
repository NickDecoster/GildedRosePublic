package com.gildedrose.ager;

import com.gildedrose.Item;

public class BackstagePassAger implements AgerStrategy {
    @Override
    public void ageItem(Item item) {
        item.sellIn--;
        if (item.sellIn < 0) {
            item.quality = 0;
            return;
        }

        if (item.quality < 50) {
            item.quality++;
        }
        if (item.quality < 50 && item.sellIn < 10) {
            item.quality++;
        }
        if (item.quality < 50 && item.sellIn < 5) {
            item.quality++;
        }
    }
}
