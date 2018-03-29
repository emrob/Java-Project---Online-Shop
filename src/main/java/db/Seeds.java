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

        Stock stock0 = new Stock(200, 37.99, "/images/sukin.png", Brand.Sukin, ProductType.Foundation);
        DBHelper.save(stock0);
        Stock stock1 = new Stock(100, 5.99, "/images/dr-organic-logo.jpg",Brand.Dr_Organic, ProductType.Eyeliner);
        DBHelper.save(stock1);
        Stock stock2 = new Stock(70, 35.99, Brand.Eden, ProductType.Perfume);
        DBHelper.save(stock2);
//        Stock stock3 = new Stock(200, 10.99, Brand.Plant_Face, ProductType.Mascara);
//        DBHelper.save(stock3);
//        Stock stock4 = new Stock(400, 9.99, Brand.Arbonne, ProductType.Lipstick);
//        DBHelper.save(stock4);
//        Stock stock5 = new Stock(320, 30.00, Brand.Pacifica, ProductType.Foundation);
//        DBHelper.save(stock5);
//        Stock stock6 = new Stock(110, 5.75, Brand.Sukin, ProductType.Concealer);
//        DBHelper.save(stock6);
//        Stock stock7 = new Stock(0, 15.75, Brand.Dr_Organic, ProductType.Perfume);
//        DBHelper.save(stock7);
//        Stock stock8 = new Stock(110, 25.75, Brand.Salt_of_the_Earth, ProductType.Eyeliner);
//        DBHelper.save(stock8);
    }
}

