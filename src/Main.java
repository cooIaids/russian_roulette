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
        Gun g = new Gun();
        g.addRounds(true);
        g.addRounds(false);
        g.addRounds(false);
        g.addRounds(false);
        g.addRounds(false);
        g.addRounds(false);
        System.out.println(g.writeOutRounds());
        g.spinCylinder();
        System.out.println(g.writeOutRounds());
        currentRound = g.getRound(0);
        nextRound = g.getRound(1);


    }
}