import db.DBHelper;
import models.*;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        DBHelper.deleteAll(Stock.class);
        DBHelper.deleteAll(Customer.class);
        DBHelper.deleteAll(Basket.class);

        Shop shop = new Shop("Ethics & Cosmetics");
        DBHelper.save(shop);

        Customer customer1 = new Customer("Marie");
        Basket basket1 = new Basket(customer1);
        customer1.setBasket(basket1);
        DBHelper.save(customer1);
        DBHelper.save(basket1);

        Stock stock1 = new Stock(200, 5.99, "/images/fairtrade.png", Brand.Green_People, ProductType.Eyeliner);
        DBHelper.save(stock1);
//        Stock stock2 = new Stock(300, 35.99, Brand.Eden, ProductType.Perfume);
//        DBHelper.save(stock2);
//        Stock stock3 = new Stock(200, 10.99, Brand.Eden, ProductType.Mascara);
//        DBHelper.save(stock3);
//
//        stock2.setPrice(37.99);
//        DBHelper.update(stock2);
//
//        DBHelper.delete(stock3);





        List<Stock> allStock = DBHelper.getAll(Stock.class);

        System.out.println();





    }
}
