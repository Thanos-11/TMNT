package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SquadTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void NewSquadObjectGetsCorrectlyCreated_true() throws Exception{
        Squad squad = setUpNewSquad();
        assertEquals(true,squad instanceof Squad);
    }

    @Test
    public void squad_squadInstantiatesWithName_true() throws Exception{
        Squad squad = setUpNewSquad();
        assertEquals("avengers",squad.getName());
    }

    @Test
    public void Squad_InstantiatewithId_1() throws Exception{
        Squad squad = setUpNewSquad();
        assertEquals(3,squad.getId());
    }


    public Squad setUpNewSquad(){
        return new Squad("avengers",8,"freedom");
    }
}