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

    @Test
    public void newSquad_assignsIdCorrectlyMultipleSquads_2() throws Exception {
        Squad testSquad = setUpSquad();
        Squad secondTestSquad = new Squad(5, "Justice League", "Lex Luthor");
        assertEquals(2, secondTestSquad.getSquadId());

    }

    @Test
    public void newSquad_getSquadById() throws Exception{
        Squad testSquad = setUpSquad();
        assertEquals(1, Squad.findSquadById(testSquad.getSquadId()).getSquadId());
    }

    @Test
    public void newSquad_isDeletedCorrectly() throws Exception {
        Squad testSquad = setUpSquad();
        Squad secondTestSquad = new Squad(5, "Justice League", "Lex Luthor");
        testSquad.deleteSquad();
        assertEquals(1, Squad.getAllSquads().size());
        assertEquals(2, Squad.getAllSquads().get(0).getSquadId());
    }

    @Test
    public void newSquad_deletesAllSquads() throws Exception {
        Squad testSquad = setUpSquad();
        Squad secondTestSquad = new Squad(5, "Justice League", "Lex Luthor");
        Squad.deleteAllSquads();
        assertEquals(0,Squad.getAllSquads().size());
    }

    @Test
    public void newSquad_addsOneMember() throws Exception {
        Squad testSquad = setUpSquad();
        Hero testHero = new Hero("SpiderMan", 19, "webCrawler", "MaryJane");
        testHero.addSquad(testSquad);
        assertEquals(1, testSquad.getActiveSquadMembers());
    }

    @Test
    public void newSquad_removeOneMember() throws Exception {
        Squad testSquad = setUpSquad();
        Hero testHero = new Hero("SpiderMan", 19, "webCrawler", "MaryJane");

    }
}