package com.gildedrose.ager;

public class AgerFactory {
    public static AgerStrategy createAgerForItem(String itemName) {
        if (itemName.contains("Aged")) {
            return new AgedItemAger();
        }

        if (itemName.contains("Backstage passes")) {
            return new BackstagePassAger();
        }

        if (itemName.contains("Sulfuras, Hand of Ragnaros")) {
            return new LegendaryItemAger();
        }

        if (itemName.contains("Conjured")) {
            return new ConjuredItemAger();
        }

        return new NormalItemAger();
    }
}
