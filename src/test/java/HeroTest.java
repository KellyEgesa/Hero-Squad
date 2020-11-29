import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeroTest {

    @After
    public void tearDown() throws Exception {
    }

    public Hero setUpHero() throws Exception {
        return new Hero("SpiderMan", 19, "webCrawler", "MaryJane");
    }

    @Test
    public void heroInstantiatesHero() throws Exception {
        Hero testHero = setUpHero();
        assertTrue(testHero instanceof Hero);
    }

    @Test
    public void newHero_containsAllHero_true() throws Exception{
        Hero testHero = setUpHero();
        Hero secondTestHero = new Hero("Thor", 32, "hammer", "loki");
        assertTrue(Hero.getAllHero().contains(testHero));
        assertTrue(Hero.getAllHero().contains(secondTestHero));
    }

    @Test(expected = AssertionError.class)
    public void newHero_ifAStringToBeEnteredIsNull_exception() throws  Exception{
        Hero testHeroNullUserName = new Hero("",  25, "webCrawler", "MaryJane");
        Hero testHeroNullHeroAge = new Hero("SpiderMan", 25, "", "MaryJane");
        Hero testHeroNullHeroWeakness = new Hero("SpiderMan", 25, "", "MaryJane");
        assertFalse(Hero.getAllHero().contains(testHeroNullHeroAge));
        assertFalse(Hero.getAllHero().contains(testHeroNullUserName));
        assertFalse(Hero.getAllHero().contains(testHeroNullHeroWeakness));
    }
}