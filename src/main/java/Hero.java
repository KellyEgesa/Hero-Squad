import java.util.ArrayList;
import java.util.List;

public class Hero {
    private String heroName;
    private int heroAge;
    private String heroPower;
    private String heroWeakness;
    private static ArrayList<Hero> instances = new ArrayList<>();

    public Hero(String heroName, int heroAge, String heroPower, String heroWeakness) throws Exception{
        if(!heroName.isEmpty() || !heroPower.isEmpty() || !heroWeakness.isEmpty()){
            this.heroName = heroName;
            this.heroAge = heroAge;
            this.heroPower = heroPower;
            this.heroWeakness = heroWeakness;
            instances.add(this);
        }
        else {
            throw new AssertionError("An input is null");
        }

    }

    public static ArrayList getAllHero(){
        return instances;
    }
}
