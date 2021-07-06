package service;

import exceptions.ItemException;
import lombok.RequiredArgsConstructor;
import model.Item;
import model.Price;
import model.SpecialPrice;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CheckoutService {

    private final PriceService priceService;

    public Price getTotal(List<Item> items){
        Price price = calculateTotal(items);
        return price;
    }

    private Price calculateTotal(List<Item> items) {
        if (items.isEmpty()) {
            throw new ItemException("No item given");
        }
        Map<String, Double> stringDoubleMap = processItemPrices(items);
        Double total = Double.valueOf(0);
        Iterator it = stringDoubleMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry)it.next();
            total += (Double) entry.getValue();
            it.remove();
        }
        return new Price(total);
    }

    private Map<String, Double>  processItemPrices(List<Item> items) {
        Map<String, Double> itemCount = new HashMap<>();
        Map<String, Double> itemPrice = new HashMap<>();
        for (Item item : items) {
            String sku = item.getSKU();
            Double count = Double.valueOf(1);
            if (itemCount.containsKey(sku)) {
                count = itemCount.get(sku) + Double.valueOf(1);
                itemCount.put(sku, count);
            } else {
                itemCount.put(sku, count);
            }
            SpecialPrice specialPrice = priceService.getSpecialPrice(sku);
            if (specialPrice != null && specialPrice.getItemCount().equals(count)) {
                itemPrice.put(sku, specialPrice.getItemPrice());
            } else {
                Double price = Double.valueOf(0);
                if (itemPrice.containsKey(sku)) {
                    price = itemPrice.get(sku);
                }
                price += priceService.getPrice(sku).getPrice();
                itemPrice.put(sku, price);
            }
        }
        return itemPrice;
    }
}
