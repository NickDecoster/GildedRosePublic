package com.gildedrose;

public interface AgerStrategy {
    void ageItem(Item item);

    default boolean maxQualityNotReached(Item item) {
        return item.quality < 50;
    }}
