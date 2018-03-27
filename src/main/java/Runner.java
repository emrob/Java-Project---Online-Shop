import db.DBHelper;
import models.Brand;
import models.ProductType;
import models.Stock;

public class Runner {

    public static void main(String[] args) {
        Stock stock1 = new Stock(200, 5.99, Brand.Green_People, ProductType.Eyeliner);
        DBHelper.save(stock1);
        Stock stock2 = new Stock(300, 35.99, Brand.Eden, ProductType.Perfume);
        DBHelper.save(stock2);

    }
}
