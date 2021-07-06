package model;

public class Item {
    private String SKU;

    public Item(String SKU) {
        this.SKU = SKU;
    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }
}
