package controllers;

import db.DBHelper;
import models.Brand;
import models.ProductType;
import models.Stock;
import spark.ModelAndView;
import spark.Spark;
import spark.template.velocity.VelocityTemplateEngine;
import sun.security.pkcs11.Secmod;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class StockController {
    public StockController() {
        this.setupEndPoints();
    }

    private void setupEndPoints() {
        Spark.get("/products/:id/edit", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Stock stock = DBHelper.find(intId, Stock.class);
            List<Brand> brands = DBHelper.getBrands();
            List<ProductType> productTypes = DBHelper.getProductTypeEnum();
            Map<String, Object> model = new HashMap<>();
            String loggedInUser = LoginController.getLoggedInUserName(req, res);
            model.put("user", loggedInUser);
            model.put("brands", brands);
            model.put("productTypes", productTypes);
            model.put("template", "templates/stock/edit.vtl");
            model.put("stock", stock);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


        Spark.get("/products", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String loggedInUser = LoginController.getLoggedInUserName(req, res);
            model.put("user", loggedInUser);
            List<Stock> stockItem = DBHelper.getAll(Stock.class);
            model.put("stockItem", stockItem);
            model.put("template", "templates/stock/index.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


        Spark.get("/products/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String loggedInUser = LoginController.getLoggedInUserName(req, res);
            model.put("user", loggedInUser);
            List<Brand> brands = DBHelper.getBrands();
            List<ProductType> productTypes = DBHelper.getProductTypeEnum();
            model.put("brands", brands);
            model.put("productTypes", productTypes);
            model.put("template", "templates/stock/create.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


        Spark.get("/products/:id", (req,res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Stock stockItem = DBHelper.find(intId, Stock.class);
            Map<String, Object> model = new HashMap<>();
            String loggedInUser = LoginController.getLoggedInUserName(req, res);
            model.put("user", loggedInUser);
            model.put("stockItem", stockItem);
            model.put("template", "templates/stock/show.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());




        Spark.post("/products", (req, res) -> {
            int quantity = Integer.parseInt(req.queryParams("quantity"));
            double price = Double.parseDouble(req.queryParams("price"));
            String image = req.queryParams("image");
            String strBrand = req.queryParams("brand");
            Brand enumBrand = Brand.valueOf(strBrand);
            String strProductType = req.queryParams("productType");
            ProductType enumProductType = ProductType.valueOf(strProductType);
            Stock stock = new Stock(quantity, price, image, enumBrand, enumProductType);
            DBHelper.save(stock);
            res.redirect("/products");
            return null;
        }, new VelocityTemplateEngine());


        Spark.post("/products/:id/delete", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            Stock stockToDelete = DBHelper.find(id, Stock.class);
            DBHelper.delete(stockToDelete);
            res.redirect("/products");
            return null;
        }, new VelocityTemplateEngine());

        post ("/stock/:id", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Stock stock = DBHelper.find(intId, Stock.class);
            int quantity = Integer.parseInt(req.queryParams("quantity"));
            double price = Double.parseDouble(req.queryParams("price"));
            String image = req.queryParams("image");
            String strBrand = req.queryParams("brand");
            Brand enumBrand = Brand.valueOf(strBrand);
            String strProductType = req.queryParams("productType");
            ProductType enumProductType = ProductType.valueOf(strProductType);

            stock.setQuantity(quantity);
            stock.setPrice(price);
            stock.setImage(image);
            stock.setBrand(enumBrand);
            stock.setProductType(enumProductType);
            DBHelper.update(stock);
            res.redirect("/products");
            return null;

        }, new VelocityTemplateEngine());

    }
}

