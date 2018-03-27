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
           Spark.get("/products", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Stock> stockItem = DBHelper.getAll(Stock.class);
            model.put("stockItem", stockItem);
               model.put("template", "templates/stock/index.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());
    }
}
