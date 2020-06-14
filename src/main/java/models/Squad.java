package models;


import java.util.ArrayList;
import java.util.List;

public class Squad {

    private int maxsize;
    private String name;
    private String cause;
    private int id;

    private static ArrayList<Squad> allSquads = new ArrayList<>();
    private List<models.Hero> heroesInSquad;

    public Squad(String name,int maxsize,String cause){
        this.name = name;
        this.maxsize = maxsize;
        this.cause = cause;
        allSquads.add(this);
        this.id = allSquads.size();
        this.heroesInSquad = new ArrayList<models.Hero>();

    }



    public int getMaxsize(){
        return maxsize;

    }
    public String getName(){
        return name;
    }

    public String getCause(){
        return cause;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;

    }

    public static Squad findSquad(int id){
        return allSquads.get(id-1);
    }

    public void addHeroToSquad(models.Hero newHero){
        heroesInSquad.add(newHero);
    }

    public List<models.Hero> getAllHeroes(){
        return heroesInSquad;
    }

    public static ArrayList<Squad> getAllSquads() {
        return allSquads;
    }


}