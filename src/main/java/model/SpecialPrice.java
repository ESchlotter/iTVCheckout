package model;

import exceptions.SpecialPriceException;

public class SpecialPrice {
    private String specialPrice;

    private Double itemCount;
    private Double itemPrice;

    public SpecialPrice(String specialPrice) {
        this.specialPrice = specialPrice;
        if (specialPrice != null && specialPrice.contains(" for ")) {
            String[] split = specialPrice.split(" for ");
            itemCount = Double.valueOf(split[0]);
            itemPrice = Double.valueOf(split[1]);
        } else {
            throw new SpecialPriceException("Invalid Price");
        }
    }

    public Double getItemCount() {
        return itemCount;
    }

    public void setItemCount(Double itemCount) {
        this.itemCount = itemCount;
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }
}
