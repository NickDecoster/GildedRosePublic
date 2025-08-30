package com.gildedrose;

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

    //TODO: look into Value object pattern.
    //TODO: add adapter for fetching legendary items.
}
