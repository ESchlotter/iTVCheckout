package controller;

import lombok.RequiredArgsConstructor;
import model.Item;
import model.Price;
import model.PricedItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.CheckoutService;
import service.PriceService;

import java.util.List;

@RestController
@RequestMapping("/checkout")
@RequiredArgsConstructor
public class CheckoutController {

    private final CheckoutService checkoutService;
    private final PriceService priceService;

    @PostMapping(path = "/newprice")
    public void setNewPricedItems(@RequestBody List<PricedItem> newPricedItems) {
        priceService.setPrices(newPricedItems);
    }

    @GetMapping
    public ResponseEntity<Price> getTotal(@RequestParam List<Item> items) {
        Price price = checkoutService.getTotal(items);

        return ResponseEntity.ok(price);
    }
}
