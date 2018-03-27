package models;

import java.util.Set;

public class Basket {
    private Set<Stock>stockItems;
//    private Customer_id;


    public Basket(Set<Stock> stockItems) {
        this.stockItems = stockItems;
    }

    public Set<Stock> getStockItems() {
        return stockItems;
    }

    public void setStockItems(Set<Stock> stockItems) {
        this.stockItems = stockItems;
    }
}
