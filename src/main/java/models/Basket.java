package models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="baskets")
public class Basket {

    private int id;
    private Set<Stock> stockItems;
    private Customer customer;
    private Shop shop;

    public Basket() {
    }

    public Basket(Customer customer) {
        this.customer = customer;
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "basket")
    public Set<Stock> getStockItems() {
        return stockItems;
    }

    public void setStockItems(Set<Stock> stockItems) {
        this.stockItems = stockItems;
    }


    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @ManyToOne
    @JoinColumn(name = "shop_id")
    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public void addToBasket(Stock stock) {
        this.stockItems.add(stock);

    }

    public int basketSize() {
         return stockItems.size();
    }

    public String numItemsinBasket(){
        basketSize();
        if (basketSize() == 0)
        return "Your basket is currently empty";
                else
                    return "You have " + basketSize() + " items in your basket";


    }


}


