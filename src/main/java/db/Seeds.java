package db;

import models.*;

public class Seeds {
    public static void seedData() {

        DBHelper.deleteAll(Stock.class);


        Shop shop = new Shop("Ethics & Cosmetics");
        DBHelper.save(shop);

        Customer customer1 = new Customer("Marie");
        Basket basket1 = new Basket(customer1);
        customer1.setBasket(basket1);
        DBHelper.save(customer1);
        DBHelper.save(basket1);

        Stock stock1 = new Stock(200, 5.99, Brand.Green_People, ProductType.Eyeliner);
        DBHelper.save(stock1);
        Stock stock2 = new Stock(300, 35.99, Brand.Eden, ProductType.Perfume);
        DBHelper.save(stock2);
        Stock stock3 = new Stock(200, 10.99, Brand.Eden, ProductType.Mascara);
        DBHelper.save(stock3);

    }
}
