import java.util.ArrayList;
import java.util.List;

public class Hero {
    private String heroName;
    private int heroAge;
    private String heroPower;
    private String heroWeakness;
    private int id;
    private Squad squad;
    private static ArrayList<Hero> instances = new ArrayList<>();

    public Hero(String heroName, int heroAge, String heroPower, String heroWeakness) throws Exception{
        if(!heroName.isEmpty() || !heroPower.isEmpty() || !heroWeakness.isEmpty()){
            this.heroName = heroName;
            this.heroAge = heroAge;
            this.heroPower = heroPower;
            this.heroWeakness = heroWeakness;
            instances.add(this);
            id = instances.size();
        }
        else {
            throw new AssertionError("An input is null");
        }

    }

    public static ArrayList getAllHero(){
        return instances;
    }

    public int getId(){
        return id;
    }

    public static Hero getById(int id){
        return instances.get(id-1);
    }

    public Squad getHeroSquad() {
        return squad;
    }

    public void addSquad(Squad squad){
        squad.addSquadMember();
        this.squad = squad;
    }

    public void removeSquad(){
        squad.removeSquadMember();
        squad = null;
    }

    public static void removeAllHeros(){
        instances.clear();
    }

    public static ArrayList getHerosBySquadId(int id){
        Squad testSquad = Squad.findSquadById(id);
        ArrayList heroWithSquad = new ArrayList();
        instances.forEach(hero -> {
           if(hero.squad == testSquad){
               heroWithSquad.add(hero);
           }
        });
        return heroWithSquad;
    }

    public static void deleteMultipleHeroSquad(int id){
        Squad testSquad = Squad.findSquadById(id);
        ArrayList heroWithSquad = new ArrayList();
        instances.forEach(hero -> {
            if(hero.squad == testSquad){
                hero.squad = null;
            }
        });
    }
}
