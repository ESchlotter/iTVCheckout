package model;

public class PricedItem extends Item {
    private Price price;
    private SpecialPrice specialPrice;

    public PricedItem(String SKU, Price price, SpecialPrice specialPrice) {
        super(SKU);
        this.price = price;
        this.specialPrice = specialPrice;
    }

    public PricedItem(String SKU, Price price) {
        super(SKU);
        this.price = price;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public SpecialPrice getSpecialPrice() {
        return specialPrice;
    }

    public void setSpecialPrice(SpecialPrice specialPrice) {
        this.specialPrice = specialPrice;
    }
}
