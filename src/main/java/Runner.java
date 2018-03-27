import db.DBHelper;
import models.*;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Stock stock1 = new Stock(200, 5.99, Brand.Green_People, ProductType.Eyeliner);
        DBHelper.save(stock1);
        Stock stock2 = new Stock(300, 35.99, Brand.Eden, ProductType.Perfume);
        DBHelper.save(stock2);
        Stock stock3 = new Stock(200, 10.99, Brand.Eden, ProductType.Mascara);
        DBHelper.save(stock3);

        stock2.setPrice(37.99);
        DBHelper.update(stock2);

        DBHelper.delete(stock3);


        Customer customer1 = new Customer("Marie");
        DBHelper.save((customer1));
        Basket basket1 = new Basket(customer1);
        DBHelper.save(basket1);

        Shop shop = new Shop("Ethics & Cosmetics");
        DBHelper.save(shop);

        List<Stock> allStock = DBHelper.getAll(Stock.class);



    }
}
