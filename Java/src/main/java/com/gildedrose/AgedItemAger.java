package com.gildedrose;

public class AgedItemAger implements AgerStrategy{
    @Override
    public void ageItem(Item item) {
        item.sellIn--;
        if (item.quality < 50) {
            item.quality++;
        }
        if(item.quality < 50 && item.sellIn < 0) {
            item.quality++;
        }
    }
}
