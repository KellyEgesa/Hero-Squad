import java.util.ArrayList;

public class Squad {
    private int maxSize;
    private String squadName;
    private String squadCause;
    private int id;
    private static ArrayList<Squad> instances = new ArrayList<>();

    public Squad(int maxSize, String name, String squadCause) {
        this.maxSize = maxSize;
        this.squadName = name;
        this.squadCause = squadCause;
        instances.add(this);
        id = instances.size();
    }

    public static ArrayList<Squad> getAllSquads() {
        return instances;
    }

    public int getSquadId() {
        return id;
    }

    public static Squad findSquadById(int id) {
        return instances.get(id - 1);
    }

    public void deleteSquad() {
        instances.remove(this.id - 1);
    }

    public static void deleteAllSquads() {
        instances.clear();
    }

}
