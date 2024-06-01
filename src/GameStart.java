import GameModes.RevolverGameModeAI;
import GameModes.RevolverGameModePlayer;
import GameModes.ShotgunGameModeAI;
import GameModes.ShotgunGameModePlayer;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameStart {

    private final Scanner sc = new Scanner(System.in);

    /**
     * Starts the entire game (including the game story). Allows the user to choose between 4 different game modes.
     */
    public void playersChoiceForGameMode() {
        boolean isAValidNumber;
        do {
            try {
                boolean revolverOrShotgun = false;
                boolean playersOrAI = false;
                int firstPlayerChoice;

                System.out.println("> Attending a party happening in an abandoned warehouse " +
                        "with complete strangers wasn't your best idea.");
                System.out.println("[Press any button to continue]");
                sc.nextLine();
                System.out.println("> It is currently 3:42 AM. ");
                System.out.println("[Press any button to continue]");
                sc.nextLine();
                System.out.println("> You're in the seediest bathroom you've ever had the displeasure of being in.");
                System.out.println("[Press any button to continue]");
                sc.nextLine();
                System.out.println("> Seeing a mysterious bottle of pills on the counter, " +
                        "you decide what's the worst that could happen, pop open the lid and guzzle down all the pills. ");
                System.out.println("[Press any button to continue]");
                sc.nextLine();
                System.out.println("> Surprisingly, nothing happens. Unimpressed, you leave the bathroom. ");
                System.out.println("[Press any button to continue]");
                sc.nextLine();
                System.out.println("> You notice a door down the hallway. ");
                System.out.println("[Press any button to continue]");
                sc.nextLine();
                System.out.println("> Getting closer to it, you feel an ominous energy coming off of it. ");
                System.out.println("[Press any button to continue]");
                sc.nextLine();
                System.out.println("> Being the danger seeker that you are, you want to know what or who is on the other side.");
                System.out.println("[Press any button to continue]");
                sc.nextLine();
                System.out.println("> You open the door.");
                System.out.println("[Press any button to continue]");
                sc.nextLine();
                System.out.println("> There's a table in the middle of the room. ");
                System.out.println("[Press any button to continue]");
                sc.nextLine();
                System.out.println("> On the other side of the table sits... something. It doesn't look human.");
                System.out.println("[Press any button to continue]");
                sc.nextLine();
                System.out.println("> The thing, it calls itself The Dealer, as you find out, offers to play Russian roulette.");
                System.out.println("[Press any button to continue]");
                sc.nextLine();
                System.out.println("> [The Dealer]: 'The starting prize is $25000... increasing with each successful round or used item.' ");
                System.out.println("[Press any button to continue]");
                sc.nextLine();
                System.out.println("> [The Dealer]: 'Wanna play with me?... " +
                        "or you could risk your life with other flesh-suits.. if your heart desires..' ");
                System.out.println("1. Play with dealer" + "\n" + "2. Play with other players");
                firstPlayerChoice = sc.nextInt();

                while (firstPlayerChoice <= 0 || firstPlayerChoice >= 3) {
                    System.out.println("Incorrect choice.");
                    System.out.println("1. Play with dealer" + "\n" + "2. Play with other players");
                    firstPlayerChoice = sc.nextInt();
                }

                System.out.println("> [The Dealer]: Interesting... the next important choice... revolver or shotgun?");
                System.out.println("1. Play with revolver" + "\n" + "2. Play with shotgun");
                int secondPlayerChoice = sc.nextInt();
                while (secondPlayerChoice <= 0 || secondPlayerChoice >= 3) {
                    System.out.println("Incorrect choice.");
                    System.out.println("1. Play with revolver" + "\n" + "2. Play with shotgun");
                    secondPlayerChoice = sc.nextInt();
                }
                if (firstPlayerChoice == 1) {
                    playersOrAI = false;
                }
                if (firstPlayerChoice == 2) {
                    playersOrAI = true;
                }

                if (secondPlayerChoice == 1) {
                    revolverOrShotgun = true;
                }
                if (secondPlayerChoice == 2) {
                    revolverOrShotgun = false;
                }

                if (!playersOrAI && revolverOrShotgun) {
                    RevolverGameModeAI revolverGameModeAI = new RevolverGameModeAI();
                    revolverGameModeAI.startGame();
                } else if (playersOrAI && revolverOrShotgun) {
                    RevolverGameModePlayer revolverGameModePlayer = new RevolverGameModePlayer();
                    revolverGameModePlayer.startGame();
                } else if (playersOrAI && !revolverOrShotgun) {
                    ShotgunGameModePlayer shotgunGameModePlayer = new ShotgunGameModePlayer();
                    shotgunGameModePlayer.startGame();

                } else {
                    ShotgunGameModeAI shotgunGameModeAI = new ShotgunGameModeAI();
                    shotgunGameModeAI.startGame();
                }
                isAValidNumber = true;

            } catch (InputMismatchException e) {
                isAValidNumber = false;
                System.out.println("Incorrect input!");
                sc.next();
            }
        } while (!isAValidNumber);


    }
}
