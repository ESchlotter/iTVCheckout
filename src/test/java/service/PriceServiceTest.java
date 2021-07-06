package service;

import exceptions.ItemException;
import model.Price;
import model.SpecialPrice;
import org.junit.Before;
import org.junit.Test;

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

}