import models.*;
import org.junit.Before;


import static org.junit.Assert.assertEquals;


public class Test {

    private Stock stock;
    private Basket basket;
    private Customer customer;

    @Before
    public void before(){
        stock = new Stock(200, 10.99, Brand.Inika,ProductType.Mascara);
        customer = new Customer("Marie");
        basket = new Basket(customer);

    }

    @org.junit.Test
    public void checkStockQuantity(){
        assertEquals(200, stock.getQuantity());
    }

    @org.junit.Test
    public void checkStockPrice(){
        assertEquals(10.99, stock.getPrice(), 0.01);
    }

    @org.junit.Test
    public void checkStockBrand(){
        assertEquals(Brand.Inika, stock.getBrand());
    }

    @org.junit.Test
    public void checkStockType(){
        assertEquals(ProductType.Mascara, stock.getProductType());
    }


}

