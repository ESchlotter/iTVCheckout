package service;

import exceptions.ItemException;
import model.Price;
import model.PricePair;
import model.SpecialPrice;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PriceService {
    public static Map<String, PricePair> prices;

    public PriceService() {
        prices = new HashMap<>();
        // This would be in a DB
        prices.put("A", new PricePair (new Price(Double.valueOf(50)), new SpecialPrice("3 for 130")));
        prices.put("B", new PricePair (new Price(Double.valueOf(30)), new SpecialPrice("2 for 45")));
        prices.put("C", new PricePair (new Price(Double.valueOf(20))));
        prices.put("D", new PricePair (new Price(Double.valueOf(15))));
    }

    public SpecialPrice getSpecialPrice(String sku) {
        if (!prices.containsKey(sku)) {
            throw new ItemException("SKU doesn't exist.");
        }
        return prices.get(sku).getSpecialPrice();
    }

    public Price getPrice(String sku) {
        if (!prices.containsKey(sku)) {
            throw new ItemException("SKU doesn't exist.");
        }
        return prices.get(sku).getPrice();
    }
}
