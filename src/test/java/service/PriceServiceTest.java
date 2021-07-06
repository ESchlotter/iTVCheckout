package service;

import exceptions.ItemException;
import model.Price;
import model.PricedItem;
import model.SpecialPrice;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class PriceServiceTest {
    private PriceService priceService;

    @Before
    public void init() {
        priceService = new PriceService();
    }

    @Test
    public void priceServiceSpecialPrice() {
        SpecialPrice specialPrice = priceService.getSpecialPrice("A");

        assertEquals(Double.valueOf(3), specialPrice.getItemCount());
        assertEquals(Double.valueOf(130), specialPrice.getItemPrice());
    }

    @Test
    public void priceServicePrice() {
        Price price = priceService.getPrice("B");

        assertEquals(Double.valueOf(30), price.getPrice());
    }

    @Test
    public void priceServiceInvalid() {
        assertThrows(ItemException.class, () -> priceService.getPrice("F"));
    }

    @Test
    public void priceServiceSpecialPriceNull() {
        assertThrows(ItemException.class, () -> priceService.getPrice(null));
    }

    @Test
    public void setNewPrices() {
        List<PricedItem> pricedItemList = new ArrayList<>();
        pricedItemList.add(new PricedItem("A", new Price(Double.valueOf(2))));
        priceService.setPrices(pricedItemList);

        Price result = priceService.getPrice("A");
        assertEquals(Double.valueOf(2), result.getPrice());
    }

    @Test
    public void setNewPricesNull() {
        assertThrows(NullPointerException.class, () -> priceService.setPrices(null));
    }
}