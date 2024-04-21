import java.util.ArrayList;

public class Player {

    private String name;
    private int health;
    private ArrayList<Item> playersItems = new ArrayList<>();


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
