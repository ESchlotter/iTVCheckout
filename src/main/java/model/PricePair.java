package model;

public class PricePair {
    private Price price;
    private SpecialPrice specialPrice;

    public PricePair(Price price, SpecialPrice specialPrice) {
        this.price = price;
        this.specialPrice = specialPrice;
    }

    public PricePair(Price price) {
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
