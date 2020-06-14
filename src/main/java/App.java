import models.Hero;
import models.Squad;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class App {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
    public static void main(String[] args){
        port(getHerokuAssignedPort());
        staticFileLocation("/public");

        get("/",(request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            ArrayList<Squad> allSquads = Squad.getAllSquads();
            ArrayList<Hero> allHeroes = Hero.getAllHeroes();
            model.put("allSquads",allSquads);
            model.put("allHeroes",allHeroes);
            return new ModelAndView(model,"index.hbs");
        }, new HandlebarsTemplateEngine());

        post("/postNewSquad",(request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            int maxSize = Integer.parseInt(request.queryParams("maxsize"));
            String name = request.queryParams("name");
            String cause = request.queryParams("cause");
            Squad newSquad = new Squad(name,maxSize,cause);
            model.put("maxsize",maxSize);
            model.put("name",name);
            model.put("cause",cause);
            return new ModelAndView(model,"success_squad.hbs");
        }, new HandlebarsTemplateEngine());

        get("/showSquadForHeroes/:id",(request, response) -> {
            Map<String,Object> model = new HashMap<>();
            Squad oneSquad = Squad.findSquad(Integer.parseInt(request.params(":id")));
            List<Hero> squadHeroes = oneSquad.getAllHeroes();
            model.put("oneSquad",oneSquad);
            model.put("oneHero",squadHeroes);
            return new ModelAndView(model,"heroes.hbs");
        },new HandlebarsTemplateEngine());

        post("/postNewHero",(request, response) -> {
            Map<String,Object> model = new HashMap<String, Object>();
            String name = request.queryParams("name");
            int age = Integer.parseInt(request.queryParams("age"));
            String power = request.queryParams("power");
            String weakness = request.queryParams("weakness");
            String Id = request.queryParams("squadTeam");
            Squad newSquadTeam = Squad.findSquad(Integer.parseInt(Id));
            Hero newHero = new Hero(name,power,weakness,age);
            newSquadTeam.addHeroToSquad(newHero);
            return new ModelAndView(model,"added_heroes.hbs");

        },new HandlebarsTemplateEngine());



    }

}
