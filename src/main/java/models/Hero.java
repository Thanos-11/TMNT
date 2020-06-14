package models;
import java.util.ArrayList;

public class Hero {
    private String name;
    private int age;
    private String power;
    private String weakness;
    private int id;
    private static ArrayList<Hero> allHeroes = new ArrayList<>();

    public Hero(String name,String power,String weakness,int age){
        this.name = name;
        this.id = id;
        this.age = age;
        this.power = power;
        this.weakness = weakness;
        allHeroes.add(this);
    }

    public String getName(){
        return name;
    }

    public int age(){
        return age;
    }

    public String getPower(){
        return power;
    }

    public String getWeakness(){
        return weakness;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static ArrayList<Hero> getAllHeroes() {
        return allHeroes;
    }


}



