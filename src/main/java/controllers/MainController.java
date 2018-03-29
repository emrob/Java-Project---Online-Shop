package controllers;

import db.Seeds;
import spark.ModelAndView;
import spark.Spark;
import spark.SparkBase;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.Map;

public class MainController {
    public MainController() {
    }

    public static void main(String[] args) {
        Seeds.seedData();
        SparkBase.staticFileLocation("/public");
        new StockController();
        new LoginController();
        Spark.get("/Home", (req, res) -> {
            Map<String, Object> model = new HashMap();
            model.put("template", "templates/main.vtl");
            return new ModelAndView(model, "templates/Homelayout.vtl");
        }, new VelocityTemplateEngine());

        Spark.get("/About", (req, res) -> {
            Map<String, Object> model = new HashMap();
            model.put("template", "templates/About.vtl");
            return new ModelAndView(model, "templates/AboutLayout.vtl");
        }, new VelocityTemplateEngine());
    }
}
