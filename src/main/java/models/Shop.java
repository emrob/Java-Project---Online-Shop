package models;

import java.util.Set;

public class Shop {

    private String name;
    private Set<Basket>baskets;
    private Set<Stock> stockItems;

    public Shop(String name, Set<Basket> baskets, Set<Stock> stockItems) {
        this.name = name;
        this.baskets = baskets;
        this.stockItems = stockItems;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Basket> getBaskets() {
        return baskets;
    }

    public void setBaskets(Set<Basket> baskets) {
        this.baskets = baskets;
    }

    public Set<Stock> getStockItems() {
        return stockItems;
    }

    public void setStockItems(Set<Stock> stockItems) {
        this.stockItems = stockItems;
    }
}
