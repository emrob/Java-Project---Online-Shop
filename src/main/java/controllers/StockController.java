package controllers;

import db.DBHelper;
import models.Stock;
import spark.ModelAndView;
import spark.Spark;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;

public class StockController {
    public StockController() {
        this.setupEndPoints();
    }

    private void setupEndPoints() {
        Spark.get("/stock/:id/edit", (req, res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Stock stock = DBHelper.find(intId, Stock.class);
            Map<String, Object> model = new HashMap<>();
            model.put("template", "templates/stock/edit.vtl");
            model.put("stock", stock);
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());


        Spark.get("/products", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Stock> stockItem = DBHelper.getAll(Stock.class);
            model.put("stockItem", stockItem);
               model.put("template", "templates/stock/index.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        Spark.get("/stock/:id", (req,res) -> {
            String strId = req.params(":id");
            Integer intId = Integer.parseInt(strId);
            Stock stockItem = DBHelper.find(intId, Stock.class);
            Map<String, Object> model = new HashMap<>();
            model.put("stockItem", stockItem);
            model.put("template", "templates/stock/show.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());
    }
}
