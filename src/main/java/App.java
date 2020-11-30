

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        get("/", (request, response) -> {
            HashMap<String, Object>model = new HashMap<>();
            return modelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
