package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

@Entity
@Table(name="shop")
public class Shop {

    private int id;
    private String name;
    private Set<Basket>baskets;
    private Set<Stock> stockItems;

    public Shop() {
    }

    public Shop(String name) {
        this.name = name;
//        this.stockItems= stockItems;

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "shop")
    public Set<Basket> getBaskets() {
        return baskets;
    }

    public void setBaskets(Set<Basket> baskets) {
        this.baskets = baskets;
    }
//
//    public int getBasketSize(){
//        return baskets.size();
//    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "shop")
    public Set<Stock> getStockItems() {
        return stockItems;
    }

    public void setStockItems(Set<Stock> stockItems) {
        this.stockItems = stockItems;
    }
}
