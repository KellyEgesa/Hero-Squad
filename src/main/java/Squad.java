import java.util.ArrayList;

public class Squad {
    private int maxSize;
    private String squadName;
    private String squadCause;
    private int id;
    private int activeSquadMembers;
    private static ArrayList<Squad> instances = new ArrayList<>();
    private static ArrayList<Hero> hero = new ArrayList<>();

    public Squad(int maxSize, String name, String squadCause) {
        this.maxSize = maxSize;
        this.squadName = name;
        this.squadCause = squadCause;
        this.activeSquadMembers = maxSize;
        instances.add(this);
        id = instances.size();
    }

    public static ArrayList<Squad> getAllSquads() {
        return instances;
    }

    public static Squad findSquadById(int id) {
        return instances.get(id - 1);
    }

    public int getSquadId() {
        return id;
    }

    public void deleteSquad() {
        instances.remove(this.id - 1);
    }

    public static void deleteAllSquads() {
        instances.clear();
    }

    public void addSquadMember(Hero hero){
        this.hero.add(hero);
        activeSquadMembers -= 1;
    }

    public ArrayList getActiveSquadMembers(){
        return hero;
    }

    public void removeSquadMember(){
        activeSquadMembers += 1;
    }


}
