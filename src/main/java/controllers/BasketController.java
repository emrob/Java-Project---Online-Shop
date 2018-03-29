package controllers;

import db.DBHelper;
import models.Basket;
import spark.ModelAndView;
import spark.Spark;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;

public class BasketController {
    public BasketController() {
        this.setupEndpoints();
    }

    private void setupEndpoints() {

        get("/basket", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            String loggedInUser = LoginController.getLoggedInUserName(req, res);
            model.put("user", loggedInUser);
            List<Basket> basketContent = DBHelper.getAll(Basket.class);
            model.put("template", "templates/basket/index.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());
    }
}