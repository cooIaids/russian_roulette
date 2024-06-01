package EntitiesAndItems;

import Guns.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Player {

    protected String name;
    protected int maxHealth = 3;
    protected int currentHealth;
    protected ArrayList<Item> playersItems = new ArrayList<>(8);
    protected Random r = new Random();

    private Scanner sc = new Scanner(System.in);



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

    /**
     * Uses an item in the EntitiesAndItems.Player's inventory
     * @param index
     * @param g
     */
    public void useAnItem(int index, Gun g){
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
                    currentHealth+=1;
                }else{
                    System.out.println("Already at max heatlh.");
                }
                break;
            case FLIP_PHONE:
                int randomRound = r.nextInt(g.size());
                boolean randomLiveOrBlank = g.getRound(randomRound).isLiveOrBlank();
                if(randomLiveOrBlank){
                    System.out.println("..Round " + randomRound + "..." + " is live..." );
                }else {
                    System.out.println("..Round " + randomRound + "..." + " is blank..." );

                }
                break;
            case EXPIRED_MEDICINE:
                int randomHealth = r.nextInt(2);
                if(randomHealth == 0){
                    if(currentHealth == maxHealth){
                        System.out.println("Already at max heatlh.");
                    }else {
                        currentHealth+=2;
                    }
                }else {
                    currentHealth-=1;
                }
                break;


        }
    }


}
