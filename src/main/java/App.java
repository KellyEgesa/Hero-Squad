import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return modelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/addSquad", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return modelAndView(model, "squad-form.hbs");
        }, new HandlebarsTemplateEngine());

        get("/addHero", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return modelAndView(model, "hero-form.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squad", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Squad> squads = Squad.getAllSquads();
            model.put("squads", squads);
            return modelAndView(model, "squad.hbs");
        }, new HandlebarsTemplateEngine());

        get("/hero", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Hero> heros = Hero.getAllHero();
            model.put("heros", heros);
            return modelAndView(model, "hero.hbs");
        }, new HandlebarsTemplateEngine());

        post("/post/new/squad", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int maxSize = Integer.parseInt(request.queryParams("maxSize"));
            String squadName = request.queryParams("squadName");
            String squadCause = request.queryParams("squadCause");
            Squad newSquad = new Squad(maxSize, squadName, squadCause);
            request.session().attribute("newSquad", newSquad);
            model.put("squad", newSquad);
            return modelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        post("/post/new/hero", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int heroAge = Integer.parseInt(request.queryParams("heroAge"));
            String heroName = request.queryParams("heroName");
            String heroPower = request.queryParams("heroPower");
            String heroWeakness = request.queryParams("heroWeakness");
            Hero newHero = new Hero(heroName, heroAge, heroPower, heroWeakness);
            request.session().attribute("newHero", newHero);
            model.put("hero", newHero);
            return modelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/hero/squad/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int squadId = Integer.parseInt(request.params("id"));
            Hero heroToAssignSquad = Hero.getById(squadId);
            ArrayList<Squad> squads = Squad.getAllSquads();
            model.put("squads", squads);
            model.put("hero", heroToAssignSquad);
            return modelAndView(model, "assignSquad.hbs");
        }, new HandlebarsTemplateEngine());

        post("/assignSquad/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int squadId = Integer.parseInt(request.params("id"));
            Hero heroToAssignSquad = Hero.getById(squadId);
            Squad squadToAssign = Squad.findSquadById(Integer.parseInt(request.queryParams("squadId")));
            heroToAssignSquad.addSquad(squadToAssign);
            return modelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squad/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int squadId = Integer.parseInt(request.params("id"));
            ArrayList<Hero> heroInSquad = Hero.getHerosBySquadId(squadId);
            Squad squad = Squad.findSquadById(squadId);
            model.put("squad", squad);
            model.put("hero", heroInSquad);
            return modelAndView(model, "squadTable.hbs");
        }, new HandlebarsTemplateEngine());

        get("/delete/Squad/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int squadId = Integer.parseInt(request.params("id"));
            Squad squadToAssign = Squad.findSquadById(Integer.parseInt(request.params("id")));
            squadToAssign.deleteSquad();
            return modelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/delete/Squad", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            Squad.deleteAllSquads();
            return modelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/delete/Hero/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int heroId = Integer.parseInt(request.params("id"));
            Hero heroToDelete = Hero.getById(Integer.parseInt(request.params("id")));
            heroToDelete.deleteHero();
            return modelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/remove/Hero/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int heroId = Integer.parseInt(request.params("id"));
            Hero heroRemoveSquad = Hero.getById(Integer.parseInt(request.params("id")));
            heroRemoveSquad.removeSquad();
            return modelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/delete/Hero", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            Hero.removeAllHeros();
            return modelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

    }
}
