import java.util.ArrayList;
import java.util.Scanner;

public class Player {

    protected String name;
    protected int health;
    protected ArrayList<Item> playersItems = new ArrayList<>(8);
    protected Scanner sc = new Scanner(System.in);


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

    public void useAnItem(int index){

    }

    public void usingTheGun(String playersChoice){
        Gun g = new Gun();
        Player opponent = new Player();
        Bullet currentRound = null;
        Bullet nextRound = null;
        System.out.println("Shoot (YOU)RSELF or the (OPP)onent???");
        System.out.println("(Shooting yourself with a blank skips opponent's turn (max. 2 times))");
        for(int i = 0; i < g.size(); i++){
            currentRound = g.getRound(i);
            nextRound = g.getRound(i+1);
            switch(playersChoice){
                case "YOU":
                    System.out.println("You chose to shoot YOURSELF");
                    if(currentRound.isLiveOrBlank() == true){
                        System.out.println("The round is... LIVE");
                        health-=1;
                        g.removeRound(currentRound);
                        if(health == 0){
                            System.out.println(name + "DIED");
                        }

                    } else if (currentRound.isLiveOrBlank() == false) {
                        System.out.println("The round is... BLANK");
                        System.out.println("Shoot (YOU)RSELF or the (OPP)onent???");
                        currentRound = nextRound;
                        playersChoice = sc.next();


                    }
                case "OPP":
                    System.out.println("You chose to shoot the OPPONENT");
                    if(currentRound.isLiveOrBlank() == true){
                        System.out.println("The round is... LIVE");
                        opponent.health-=1;
                        if(health == 0){
                            System.out.println(opponent.name + "DIED");
                        }

                    } else if (currentRound.isLiveOrBlank() == false) {
                        System.out.println("The round is... BLANK");
                    }



            }
        }


    }
}
