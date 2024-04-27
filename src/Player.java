import java.util.ArrayList;

public class Player {

    private String name;
    private int health;
    private ArrayList<Item> playersItems = new ArrayList<>();


    public void addItem(Item i){
        playersItems.add(i);
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String writeOutItems(){
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < playersItems.size(); i++){
            s.append(playersItems.get(i));
        }
        return s.toString();
    }

    public void usingTheGun(String playersChoice){
        Gun g = new Gun();
        System.out.println("Shoot (YOU)RSELF or THE (DEALER)???");
        System.out.println("Shooting yourself with a blank skips The Dealer's turn");
        switch(playersChoice){
            case "YOU":
        }

    }
}
