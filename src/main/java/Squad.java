import java.util.ArrayList;

public class Squad {
    private int maxSize;
    private String squadName;
    private String squadCause;
    private static ArrayList<Squad> instances = new ArrayList<>();

    public Squad(int maxSize, String name, String squadCause){
        this.maxSize = maxSize;
        this.squadName = name;
        this.squadCause = squadCause;
        instances.add(this);
    }

    public static ArrayList getAllSquads(){
        return instances;
    }
}
