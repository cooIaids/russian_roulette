import java.util.Collections;

public class Revolver extends Gun {


    @Override
    public void addRounds(Bullet b) {
        if(rounds.size() < 6){
            super.addRounds(b);
        }else {
            System.out.println("Can't add more rounds");
        }
    }

    /**
     * Simulates the spinning of the chamber (shuffles the list).
     */
    public void spinTheChamber(){
        Collections.shuffle(rounds);
    }




}
