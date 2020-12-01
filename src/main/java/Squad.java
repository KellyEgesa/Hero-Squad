import java.util.ArrayList;

public class Squad {
    private int maxSize;
    private String squadName;
    private String squadCause;
    private int id;
    private int activeSquadMembers;
    private static ArrayList<Squad> instances = new ArrayList<>();


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
        Hero.deleteMultipleHeroSquad(this.id);
        instances.remove(this.id - 1);
    }

    public static void deleteAllSquads() {
        for (Squad squad : instances) {
            Hero.deleteMultipleHeroSquad(squad.id);
        }
        instances.clear();
    }

    public void addSquadMember(){
        activeSquadMembers -= 1;
        instances.set(this.id - 1, this);
    }

    public int getActiveSquadMembers(){
        return maxSize - activeSquadMembers;
    }

    public void removeSquadMember(){
        activeSquadMembers += 1;
        instances.set(this.id - 1, this);
    }

    public int getActiveSquadMember(){
        return activeSquadMembers;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public String getSquadName() {
        return squadName;
    }

    public String getSquadCause() {
        return squadCause;
    }

    public int getId() {
        return id;
    }
}
