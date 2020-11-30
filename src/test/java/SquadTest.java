import org.junit.Test;

import static org.junit.Assert.*;

public class SquadTest {

    public Squad setUpSquad() throws Exception{
        return new Squad(8, "Marvel", "Alien Evil");
    }

    @Test
    public void squad_InitialisesCorrectly() throws Exception{
        Squad testSquad = setUpSquad();
        assertTrue(testSquad instanceof Squad);
    }

    @Test
    public void newSquad_hasAllTheSquads() throws Exception{
        Squad testSquad = setUpSquad();
        Squad secondTestSquad = new Squad(5, "Justice League", "Lex Luthor");
        assertTrue(Squad.getAllSquads().contains(testSquad));
        assertTrue(Squad.getAllSquads().contains(secondTestSquad));
    }

    @Test
    public void newSquad_assignsIdCorrectly_1() throws Exception {
        Squad testSquad = setUpSquad();
        assertEquals(1, testSquad.getSquadId());
    }
}