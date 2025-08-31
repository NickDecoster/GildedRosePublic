package com.gildedrose;

public class ConjuredItemAger implements AgerStrategy {
    @Override
    public void ageItem(Item item) {
        item.sellIn--;
        if (item.quality > 0) {
            item.quality--;
            if (item.quality > 0) {
                item.quality--;
            }
        }
        if(item.quality > 0 && item.sellIn < 0) {
            item.quality--;
            if (item.quality > 0) {
                item.quality--;
            }
        }
    }
}
