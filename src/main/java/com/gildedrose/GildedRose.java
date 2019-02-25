package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void update(Item item) {
        switch(item.name)
        {
            case "Sulfuras, Hand of Ragnaros":
            {
                item.quality = 80;
                break;
            }
            case "Aged Brie":
            {
                item.quality += 1;
                break;
            }
            case "Backstage passes to a TAFKAL80ETC concert":
            {
                item.quality += 1;

                if (item.sellIn < 11) {
                    item.quality += 1;
                }
                if (item.sellIn < 6) {
                    item.quality += 1;
                }
                if (item.sellIn < 1) {
                    item.quality = 0;
                }
                break;
            }
            default:
            {
                int factor = item.name.toLowerCase().contains("conjured") ? 2 : 1;
                if (item.sellIn < 1) {
                    item.quality -= 2*factor;
                }
                else {
                    item.quality -= 1*factor;
                }
                break;
            }
        }

        if(item.name!="Sulfuras, Hand of Ragnaros") {
            if (item.quality > 50) item.quality = 50;
            item.sellIn = item.sellIn - 1;
        }
        if (item.quality <= 0) item.quality = 0;

    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            update(items[i]);
        }
    }
}