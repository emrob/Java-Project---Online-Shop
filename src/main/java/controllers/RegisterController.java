package controllers;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class RegisterController {
    public RegisterController() {
        this.setupEndpoints();
    }

    private void setupEndpoints() {

        get("/register", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "templates/Register.vtl");
        }, new VelocityTemplateEngine());

        post("/register", (req, res) -> {
            String username = req.queryParams("username");
            req.session().attribute("username", username);
            res.redirect("/thanks");
            return null;
        }, new VelocityTemplateEngine());

        get("/thanks", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "templates/Thanks.vtl");
        }, new VelocityTemplateEngine());

        get("/register", (req, res) -> {
            req.session().removeAttribute("username");
            res.redirect("/Home");
            return null;
        }, new VelocityTemplateEngine());
    }

}
