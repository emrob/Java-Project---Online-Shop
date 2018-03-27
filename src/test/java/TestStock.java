import models.Brand;
import models.ProductType;
import models.Stock;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TestStock {

    private Stock stock;

    @Before
    public void before(){
        stock = new Stock(200, 10.99, Brand.Inika,ProductType.Mascara);

    }

    @Test
    public void checkStockQuantity(){
        assertEquals(200, stock.getQuantity());
    }

    @Test
    public void checkStockPrice(){
        assertEquals(10.99, stock.getPrice(), 0.01);
    }

    @Test
    public void checkStockBrand(){
        assertEquals(Brand.Inika, stock.getBrand());
    }

    @Test
    public void checkStockType(){
        assertEquals(ProductType.Mascara, stock.getProductType());
    }

}

