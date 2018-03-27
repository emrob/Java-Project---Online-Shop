package models;

public class Stock {

    private int id;
    private int quantity;
    private double price;
    private Brand brand;
    private ProductType productType;

    public Stock(int quantity, double price, Brand brand, ProductType productType){
        this.quantity = quantity;
        this.price = price;
        this.brand = brand;
        this.productType = productType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }
}
