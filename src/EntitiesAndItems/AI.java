package EntitiesAndItems;

import Guns.*;

import java.util.Random;

public class AI extends Player {
    private final Random r = new Random();

    @Override
    public void useAnItem(int index, Gun g) {
        Item i = this.playersItems.get(index);
        switch (i.getType()){
            case POCKET_KNIFE:
                g.setDamage(g.getDamage()*2);
                break;
            case BEER:
                g.removeRound(0);
                break;
            case MAGNIFYING_GLASS:
                if(g.getRound(0).isLiveOrBlank()){
                    System.out.println(getName() + ": Very interesting...");
                }else {
                    System.out.println(getName() + ": ...");

                }
                break;
            case CIGARETTES:
                if(currentHealth != maxHealth){
                    currentHealth+=1;
                }else{
                    System.out.println(getName() + ": Seems like I'm at max health...");
                }
                break;
            case FLIP_PHONE:
                int randomRound = r.nextInt(g.size());
                boolean randomLiveOrBlank = g.getRound(randomRound).isLiveOrBlank();
                if(randomLiveOrBlank){
                    System.out.println(getName() + ": Interesting...");
                }else {
                    System.out.println(getName() + ": Hmm...");

                }
                break;
            case EXPIRED_MEDICINE:
                int randomHealth = r.nextInt(2);
                if(randomHealth == 0){
                    if(currentHealth == maxHealth){
                        System.out.println(getName() + ": Seems like I'm at max health...");
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
