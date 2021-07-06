package service;
import exceptions.ItemException;
import model.Item;
import model.Price;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class CheckoutServiceTest {
    private CheckoutService checkoutService;

    @Before
    public void init() {
        PriceService priceService = new PriceService();
        checkoutService = new CheckoutService(priceService);
    }

    @Test
    public void checkoutCorrectItem() {
        List<Item> itemList = new ArrayList<>();
        Item item = new Item("A");
        itemList.add(item);
        Price total = checkoutService.getTotal(itemList);
        assertEquals(Double.valueOf(50), total.getPrice());
    }

    @Test
    public void checkoutCorrectTwoItem() {
        List<Item> itemList = new ArrayList<>();
        Item item = new Item("C");
        Item item2 = new Item("D");
        itemList.add(item);
        itemList.add(item2);
        Price total = checkoutService.getTotal(itemList);
        assertEquals(Double.valueOf(35), total.getPrice());
    }

    @Test
    public void checkoutCorrectSpecialPrice() {
        List<Item> itemList = new ArrayList<>();
        Item item = new Item("B");
        Item item2 = new Item("B");
        itemList.add(item);
        itemList.add(item2);
        Price total = checkoutService.getTotal(itemList);
        assertEquals(Double.valueOf(45), total.getPrice());
    }

    @Test
    public void checkoutCorrectMultipleItems() {
        List<Item> itemList = new ArrayList<>();
        Item item = new Item("A");
        Item item2 = new Item("D");
        Item item3 = new Item("A");
        Item item4 = new Item("B");
        Item item5 = new Item("A");

        itemList.add(item);
        itemList.add(item2);
        itemList.add(item3);
        itemList.add(item4);
        itemList.add(item5);
        Price total = checkoutService.getTotal(itemList);
        assertEquals(Double.valueOf(175), total.getPrice());
    }

    @Test
    public void checkoutNull() {
        assertThrows(NullPointerException.class,
                () -> checkoutService.getTotal(null)
        );
    }

    @Test
    public void checkoutInvalidItem() {
        assertThrows(ItemException.class, () ->{
            List<Item> itemList = new ArrayList<>();
            Item item = new Item("F");
            itemList.add(item);
            checkoutService.getTotal(itemList);
        });
    }

    @Test
    public void checkoutEmptyList() {
        assertThrows(ItemException.class, () ->{
            List<Item> itemList = new ArrayList<>();
            checkoutService.getTotal(itemList);
        });
    }

}