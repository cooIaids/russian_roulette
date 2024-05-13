import java.util.ArrayList;

public class Player {

    protected String name;
    protected int maxHealth;
    protected int currentHealth;
    protected ArrayList<Item> playersItems = new ArrayList<>(8);



    public void addItem(Item i){
        playersItems.add(i);
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public int itemsSize(){
        return playersItems.size();
    }

    public void removeItem(int index){
        playersItems.remove(index);
    }

    public String writeOutItems(){
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < playersItems.size(); i++){
            s.append(playersItems.get(i));
        }
        return s.toString();
    }

    public Item getItem(int index){
        return playersItems.get(index);
    }


}
