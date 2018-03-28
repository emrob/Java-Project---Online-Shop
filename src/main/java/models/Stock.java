package models;

import javax.persistence.*;

@Entity
@Table(name= "stock")
public class Stock {

    private int id;
    private int quantity;
    private double price;
    private Brand brand;
    private ProductType productType;
    private Basket basket;
    private Shop shop;

    public Stock() {
    }

    public Stock(int quantity, double price, Brand brand, ProductType productType){
        this.quantity = quantity;
        this.price = price;
        this.brand = brand;
        this.productType = productType;
    }



    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="quantity")
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Column(name="price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Column(name="brand")
    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    @Column(name="product_type")
    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    @ManyToOne
    @JoinColumn(name="basket_id")
    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    @ManyToOne
    @JoinColumn(name="shop_id")
    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }
}
