import org.junit.Test;

import static org.junit.Assert.*;

public class SquadTest {

    public Squad setUpSquad(){
        return new Squad(8, "Marvel", "Alien Evil");
    }
    @Test
    public void squad_InitialisesCorrectly() {
        Squad testSquad = setUpSquad();
        assertTrue(testSquad instanceof Squad);
    }
}