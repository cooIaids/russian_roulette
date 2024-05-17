import java.util.ArrayList;
import java.util.Random;

public class Player {

    protected String name;
    protected int maxHealth = 3;
    protected int currentHealth;
    protected ArrayList<Item> playersItems = new ArrayList<>(8);
    protected Random r = new Random();



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
                break;
            case BEER:
                g.removeRound(0);
                break;
            case MAGNIFYING_GLASS:
                g.getRound(0).isLiveOrBlank();
                break;
            case CIGARETTES:
                if(currentHealth != maxHealth){
                    currentHealth+=currentHealth;
                }
                break;
            case FLIP_PHONE:
                int randomRound = r.nextInt(g.size());

        }
    }


}
