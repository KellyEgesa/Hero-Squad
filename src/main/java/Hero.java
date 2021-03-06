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

    public void deleteHero(){
        removeSquad();
        instances.remove(this.id -1);
    }


    public void addSquad(Squad squad){
        squad.addSquadMember();
        this.squad = squad;
        instances.set(this.id - 1, this);
    }

    public void removeSquad(){
        if(squad != null){
            squad.removeSquadMember();
        }
        squad = null;
        instances.set(this.id - 1, this);
    }

    public String getHeroName() {
        return heroName;
    }

    public int getHeroAge() {
        return heroAge;
    }

    public String getHeroPower() {
        return heroPower;
    }

    public String getHeroWeakness() {
        return heroWeakness;
    }

    public Squad getSquad() {
        return squad;
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
