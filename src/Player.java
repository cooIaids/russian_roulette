import java.util.ArrayList;

public class Player {

    protected String name;
    protected int maxHealth = 3;
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

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
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

    public void useAnItem(int index){
        Gun g = new Gun();
        Item i = playersItems.get(index);
        switch (i.getType()){
            case POCKET_KNIFE:
                g.setDamage(g.getDamage()*2);
        }
    }


}
