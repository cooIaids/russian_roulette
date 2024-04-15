import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random r = new Random();

    /*    System.out.println("Attending a party happening in an abandoned warehouse " +
                "with complete strangers wasn't your best idea.");
        System.out.println("[Press ENTER to continue]");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();

        System.out.println("It is currently 3:42 AM " +
        "and you're in the seediest bathroom you've ever had the displeasure of being in. ");
        System.out.println("[Press ENTER to continue]");
        sc.nextLine();

        System.out.println("Seeing a mysterious bottle of pills on the counter, " +
                "you decide what's the worst that could happen, pop open the lid and guzzle down all the pills. " +
                "Surprisingly, nothing happens. Unimpressed, you leave the bathroom. " +
                "You notice a door down the hallway. Getting closer to it, you feel an ominous energy coming off of it. " +
                "Being the danger seeker that you are, you want to know what or who is on the other side, " +
                "on the other hand, this party has already filled you with insurmountable disappointment and you want to leave. " +
                "The choice is yours");*/

        // Two possible game modes - with a revolver or with a tactical shotgun

        System.out.println("Imagine interesting lore here");
        int playersHealth = 2;
        int oppHealth = 2;
        boolean currentRound = true;
        boolean nextRound = false;
        Revolver rev = new Revolver();
        rev.addRounds(false);
        rev.addRounds(false);
        rev.addRounds(true);
        rev.addRounds(false);
        rev.addRounds(false);
        rev.addRounds(false);
        System.out.println(rev.writeOutRounds());
        rev.spinCylinder();
        System.out.println(rev.writeOutRounds());
        currentRound = rev.getRound(0);
        nextRound = rev.getRound(1);
        System.out.println("Shoot YOURSELF or THE DEALER?");
        System.out.println("Shooting yourself with a blank skips The Dealer's turn (max. 2 times)");
        String playersChoice;
        playersChoice = sc.next();
        switch (playersChoice){
            case "YOU":
                if(currentRound == true){
                    playersHealth -= 1;
                    System.out.println("THE DEALER'S TURN");
                } else if (currentRound == false) {
                    playersChoice = sc.next();
                    System.out.println("THE DEALER'S TURN");

                }
                System.out.println(playersHealth);
                break;
            case "DEALER":
                if(currentRound == true){
                    oppHealth -= 1;
                    System.out.println("YOUR TURN");
                } else if (currentRound == false) {
                    System.out.println("THE DEALER'S TURN");
                }


        }


    }
}