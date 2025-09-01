package com.gildedrose;

public class Quality {

    private int quality;
    private final static int MAX_QUALITY = 50;
    private final static int MIN_QUALITY = 0;

    public Quality(int initialQuality) {
        this.quality = initialQuality;
    }

    public int getQuality() {
        return quality;
    }

    public void increaseQuality(int increaseBy) {
        this.quality = Math.min(quality + increaseBy, MAX_QUALITY);
    }

    public void decreaseQuality(int decreaseBy) {
        this.quality = Math.max(quality - decreaseBy, MIN_QUALITY);
    }

    public void setQualityToZero() {
        this.quality = 0;
    }
}
