package com.gildedrose;

import com.gildedrose.ager.AgerFactory;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            AgerFactory.createAgerForItem(item.name).ageItem(item);
        }
    }

    //TODO: add adapter for fetching legendary items.
}
