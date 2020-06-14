package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeroTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void NewHeroObjectGetsCorrectlyCreated_true() throws Exception{
        Hero hero = setUpNewHero();
        assertEquals(true,hero instanceof Hero);
    }

    @Test
    public void hero_heroInstantiatesWithName_true() throws Exception{
        Hero hero = setUpNewHero();
        assertEquals("name",hero.getName());
    }

    @Test
    public void Squad_InstantiatewithId_1() throws Exception{
        Hero hero = setUpNewHero();
        assertEquals(0,hero.getId());
    }


    public Hero setUpNewHero(){
        return new Hero( "name","power","weakness",5);
    }
}