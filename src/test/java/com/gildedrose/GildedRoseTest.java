package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void ToString(){
        Item[] brie = new Item[]{new Item("Aged Brie", 2, 0)};
        GildedRose gr = new GildedRose(brie);

        assertEquals("Aged Brie, 2, 0", brie[0].toString());
    }

    @Test
    public void QualityGoesDownTwiceAsFastWhenSellInIsZero(){
        Item[] item = new Item[]{new Item("Stupid Item", 0, 2)};
        GildedRose gr = new GildedRose(item);
        gr.updateQuality();
        assertEquals(0, item[0].quality);
    }

    @Test
    public void QualityGoesDown(){
        Item[] item = new Item[]{new Item("Stupid Item", 10, 2)};
        GildedRose gr = new GildedRose(item);
        gr.updateQuality();
        assertEquals(1, item[0].quality);
    }

    @Test
    public void BrieGoesUp(){
        Item[] brie = new Item[]{new Item("Aged Brie", 2, 0)};
        GildedRose gr = new GildedRose(brie);
        gr.updateQuality();
        assertEquals(1, brie[0].quality);
    }

    @Test
    public void SulfurasStaystheSame(){
        Item[] Sulfuras = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 2, 80)};
        GildedRose gr = new GildedRose(Sulfuras);
        assertEquals(80, Sulfuras[0].quality);
        for(int i=0 ; i<= 80 ; i++) {
            gr.updateQuality();
        }
        assertEquals(80, Sulfuras[0].quality);
    }

    @Test
    public void SulfurasSellInStaysTheSame(){
        Item[] Sulfuras = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 2, 80)};
        GildedRose gr = new GildedRose(Sulfuras);
        for(int i=0 ; i<= 80 ; i++) {
            gr.updateQuality();
        }
        assertEquals(2, Sulfuras[0].sellIn);
    }

    @Test
    public void SulfurasIs80(){
        Item[] Sulfuras = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 2, 0)};
        GildedRose gr = new GildedRose(Sulfuras);
        gr.updateQuality();
        assertEquals(80, Sulfuras[0].quality);
    }

    @Test
    public void QualityNeverExceeds50(){ //todo need to test all types
        Item[] brie = new Item[]{new Item("Aged Brie", 2, 0)};
        GildedRose gr = new GildedRose(brie);
        for(int i=0 ; i<= 80 ; i++) {
            gr.updateQuality();
        }
        assertEquals(50, brie[0].quality);
    }

    @Test
    public void BackstagePassesIncreaseBy1(){
        Item[] backstagePass = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 11, 0)};
        GildedRose gr = new GildedRose(backstagePass);
        gr.updateQuality();
        assertEquals(1, backstagePass[0].quality);
    }
    @Test
    public void BackstagePassesIncreaseBy2(){
        Item[] backstagePass = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 8, 0)};
        GildedRose gr = new GildedRose(backstagePass);
        gr.updateQuality();
        assertEquals(2, backstagePass[0].quality);
    }
    @Test
    public void BackstagePassesIncreaseBy3(){
        Item[] backstagePass = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 4, 0)};
        GildedRose gr = new GildedRose(backstagePass);
        gr.updateQuality();
        assertEquals(3, backstagePass[0].quality);
    }
    @Test
    public void BackstagePassesDropsToZeroIfDateIsPassed(){
        Item[] backstagePass = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 1, 10)};
        GildedRose gr = new GildedRose(backstagePass);
        gr.updateQuality();
        gr.updateQuality();
        assertEquals(0, backstagePass[0].quality);
    }

    @Test
    public void ConjuredItems(){
        Item[] backstagePass = new Item[]{new Item("Conjured Shoes", 5, 2)};
        GildedRose gr = new GildedRose(backstagePass);
        gr.updateQuality();
        assertEquals(0, backstagePass[0].quality);
    }

    @Test
    public void Update(){
        Item[] backstagePass = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 1, 10)};
        GildedRose gr = new GildedRose(backstagePass);
        gr.update(backstagePass[0]);
        gr.update(backstagePass[0]);
        assertEquals(0, backstagePass[0].quality);
    }

}
