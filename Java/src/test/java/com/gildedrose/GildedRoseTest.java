package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void testSellInAndQualityLowerDaily() {
        Item[] items = new Item[]{new Item("HLN article", 3, 5)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("HLN article", app.items[0].name);
        assertEquals(2, app.items[0].sellIn);
        assertEquals(4, app.items[0].quality);
    }

    @Test
    void testItemQualityLowersTwiceAsFastWithNegativeSellIn() {
        Item[] items = new Item[]{new Item("JOE Podcast", -3, 7)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("JOE Podcast", app.items[0].name);
        assertEquals(-4, app.items[0].sellIn);
        assertEquals(5, app.items[0].quality);
    }

    @Test
    void testItemQualityNeverNegative() {
        Item[] items = new Item[]{new Item("Q-Top 40", 3, 0), new Item("NU.nl weather forecast", -2, 1)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Q-Top 40", app.items[0].name);
        assertEquals(2, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);

        assertEquals("NU.nl weather forecast", app.items[1].name);
        assertEquals(-3, app.items[1].sellIn);
        assertEquals(0, app.items[1].quality);
    }

    @Test
    void testAgedItemQualityIncreasesDaily() {
        Item[] items = new Item[]{new Item("Aged Brie", 2, 3)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(1, app.items[0].sellIn);
        assertEquals(4, app.items[0].quality);
    }

    @Test
    void testAgedItemQualityIncreasesTwiceAsFastOnceExpired() {
        Item[] items = new Item[]{new Item("Aged Brie", 0, 3)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(5, app.items[0].quality);
    }

    @Test
    void testQualityOfAgedItemNeverAbove50() {
        Item[] items = new Item[]{new Item("Aged Brie", 2, 50), new Item("Aged Rochefort", -3, 49)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals(1, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);

        assertEquals("Aged Rochefort", app.items[1].name);
        assertEquals(-4, app.items[1].sellIn);
        assertEquals(50, app.items[1].quality);
    }

    @Test
    void testQualityAndSellInOfSulfurasNeverChange() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 20, 80), new Item("Sulfuras, Hand of Ragnaros", -5, 80)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
        assertEquals(20, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);

        assertEquals("Sulfuras, Hand of Ragnaros", app.items[1].name);
        assertEquals(-5, app.items[1].sellIn);
        assertEquals(80, app.items[1].quality);
    }

    @Test
    void testBackstagePassQualityIncreasesDaily() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 11, 8)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(10, app.items[0].sellIn);
        assertEquals(9, app.items[0].quality);
    }

    @Test
    void testBackstagePassQualityIncreasesBy2WithSellInLowerThan10() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 10, 8), new Item("Backstage passes to a Sabaton concert", 6, 5)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(10, app.items[0].quality);

        assertEquals("Backstage passes to a Sabaton concert", app.items[1].name);
        assertEquals(5, app.items[1].sellIn);
        assertEquals(7, app.items[1].quality);
    }

    @Test
    void testBackstagePassQualityIncreasesBy3WithSellInLowerThan5() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 5, 8), new Item("Backstage passes to a Poets of the fall concert", 1, 5)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(4, app.items[0].sellIn);
        assertEquals(11, app.items[0].quality);

        assertEquals("Backstage passes to a Poets of the fall concert", app.items[1].name);
        assertEquals(0, app.items[1].sellIn);
        assertEquals(8, app.items[1].quality);
    }

    @Test
    void testBackstagePassQualityDropsToZeroAfterConcert() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 0, 8)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void testBackstagePassQualityNeverAbove50() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 11, 50), new Item("Backstage passes to Tomorrowland", 7, 49), new Item("Backstage passes to the Q-music DJ contest", 2, 48)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals(10, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);

        assertEquals("Backstage passes to Tomorrowland", app.items[1].name);
        assertEquals(6, app.items[1].sellIn);
        assertEquals(50, app.items[1].quality);

        assertEquals("Backstage passes to the Q-music DJ contest", app.items[2].name);
        assertEquals(1, app.items[2].sellIn);
        assertEquals(50, app.items[2].quality);
    }

    @Test
    void TestConjuredItemQualityDecreasesBy2Daily() {
        Item[] items = new Item[]{new Item("Conjured Humo article", 5, 3)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals("Conjured Humo article", app.items[0].name);
        assertEquals(4, app.items[0].sellIn);
        assertEquals(1, app.items[0].quality);
    }

    @Test
    void TestConjuredItemQualityDecreasesTwiceAsFastOnceExpired() {
        Item[] items = new Item[]{new Item("Conjured muffin", -3, 7)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals("Conjured muffin", app.items[0].name);
        assertEquals(-4, app.items[0].sellIn);
        assertEquals(3, app.items[0].quality);
    }

    @Test
    void TestConjuredItemQualityNeverNegative() {
        Item[] items = new Item[]{new Item("Conjured mana cake", 3, 1), new Item("Conjured silver spoon", -1, 3)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals("Conjured mana cake", app.items[0].name);
        assertEquals(2, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);

        assertEquals("Conjured silver spoon", app.items[1].name);
        assertEquals(-2, app.items[1].sellIn);
        assertEquals(0, app.items[1].quality);
    }
}
