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
        int maxPlayersHealth = 3;
        int maxOppHealth = 3;
        boolean currentRound;
        boolean nextRound;
        Revolver rev = new Revolver();
        rev.addRounds(new Bullet(true));
        rev.addRounds(new Bullet(false));
        rev.addRounds(new Bullet(false));
        rev.addRounds(new Bullet(false));
        rev.addRounds(new Bullet(false));
        rev.addRounds(new Bullet(false));

        System.out.println(rev.writeOutRounds());
        rev.spinCylinder();
        System.out.println(rev.writeOutRounds());
        currentRound = rev.getRound(0);
        nextRound = rev.getRound(1);
        System.out.println("[ROUND 1/3]");
        System.out.println("Shoot (YOU)RSELF or the (OPP)onent?");
        System.out.println("Shooting yourself with a blank skips The Dealer's turn (max. 2 times)");
        String playersChoice;
        playersChoice = sc.next();
        switch (playersChoice) {
            case "YOU":
                System.out.println("You chose to shoot YOURSELF");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if (currentRound == true) {
                    System.out.println("The round is... LIVE");
                    maxPlayersHealth -= 1;
                    System.out.println("You lost 1 life. Careful, now...");
                    if (maxPlayersHealth == 0) {
                        System.out.println("YOU DIED. RESTART???");
                        System.exit(0);
                    }

                } else if (currentRound == false) {
                    System.out.println("The round is... BLANK");
                    System.out.println("Shoot YOURSELF or THE DEALER?");
                    playersChoice = sc.next();

                }
                break;
            case "OPP":
                if (currentRound == true) {
                    maxOppHealth -= 1;
                } else if (currentRound == false) {
                }


        }

        System.out.println("[THE DEALER'S TURN]");
        String oppChoice;
        oppChoice = sc.next();
        switch (oppChoice) {
            case "YOU":
                System.out.println("The opponent chose to shoot THEMSELVES");
                if (nextRound == true) {
                    System.out.println("The round is... LIVE");
                    maxOppHealth -= 1;
                    System.out.println("You lost 1 life. Careful, now...");
                    if (maxOppHealth == 0) {
                        System.out.println("YOU DIED. RESTART???");
                        System.exit(0);
                    }

                } else if (nextRound == false) {
                    System.out.println("The round is... BLANK");
                    System.out.println("Shoot YOURSELF or THE DEALER?");
                    playersChoice = sc.next();

                }
                System.out.println(maxPlayersHealth);
                break;
            case "OPP":
                if (nextRound == true) {
                    maxOppHealth -= 1;
                } else if (nextRound == false) {
                }


        }


    }
}