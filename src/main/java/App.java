import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        get("/", (request, response) -> {
            Map<String, Object>model = new HashMap<>();
            ArrayList<Squad> squads =  Squad.getAllSquads();
            model.put("squads", squads);
            return modelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/addSquad", (request, response) -> {
            Map<String, Object>model = new HashMap<>();
            return modelAndView(model, "squad-form.hbs");
        }, new HandlebarsTemplateEngine());

        get("/addHero", (request, response) -> {
            Map<String, Object>model = new HashMap<>();
            return modelAndView(model, "hero-form.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squad", (request, response) -> {
            Map<String, Object>model = new HashMap<>();
            ArrayList<Squad> squads =  Squad.getAllSquads();
            model.put("squads", squads);
            return modelAndView(model, "squad.hbs");
        }, new HandlebarsTemplateEngine());

        post("/post/new/squad", (request, response) -> {
            Map<String, Object>model = new HashMap<>();
            int maxSize = Integer.parseInt(request.queryParams("maxSize"));
            String squadName = request.queryParams("squadName");
            String squadCause = request.queryParams("squadCause");
            Squad newSquad = new Squad(maxSize, squadName, squadCause);
            request.session().attribute("newSquad", newSquad);
            model.put("squad", newSquad);
            return modelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
