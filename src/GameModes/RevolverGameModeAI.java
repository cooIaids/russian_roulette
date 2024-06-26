package GameModes;

import EntitiesAndItems.*;
import Guns.*;
import Command.*;

import java.util.ArrayList;
import java.util.InputMismatchException;

public class RevolverGameModeAI extends GameMode {

    /**
     * Starts game mode where the EntitiesAndItems.Player plays against EntitiesAndItems.AI with Guns.Revolver.
     */
    public void startGame() {
        boolean isAValidNumber;
        do {
            try {
                int prizeMoney = 25000;
                ArrayList<Player> players = new ArrayList<>();
                System.out.println("> You chose to play with The Dealer. The look he gives you is soul-wrenching."
                        + "\n" +
                        "> The classic version of Russian Roulette, can't be beat.");
                System.out.println("[Press any button to continue]");
                sc.nextLine();
                Thread.sleep(500);

                Player p = new Player();
                System.out.println("Your name is: ");
                String nameChoice = sc.next();
                p.setName(nameChoice);
                p.addItem(new Item(Item.TypeOfItem.MAGNIFYING_GLASS));

                AI ai = new AI();
                ai.setName("The Dealer");
                ai.addItem(new Item(Item.TypeOfItem.MAGNIFYING_GLASS));
                players.add(p);
                players.add(ai);

                Thread.sleep(500);
                System.out.println("Let the dance of life and death begin...");
                Thread.sleep(500);
                System.out.println("Every player has (ONE) MAGNIFYING GLASS item. Use it wisely...");
                boolean isOpponentsTurn = false;
                boolean liveOrBlank = false;
                while (players.size() > 1) {
                    Revolver r = new Revolver();
                    r.addRounds(new Bullet(true));
                    r.addRounds(new Bullet(false));
                    r.addRounds(new Bullet(false));
                    r.addRounds(new Bullet(false));
                    r.addRounds(new Bullet(false));
                    r.addRounds(new Bullet(false));


                    System.out.println("-----------------------------");
                    if (!isOpponentsTurn) {
                        System.out.println("[" + p.getName() + "'s turn]");
                        System.out.println(p.getName() + " spins the chamber.");
                        r.spinTheChamber();
                        System.out.println("Use your ITEM (yes/no)?");
                        String playersChoice = sc.next();
                        if (playersChoice.equalsIgnoreCase("yes")) {
                            if (p.itemsSize() == 0) {
                                System.out.println("You already used your item");
                            } else {
                                if (r.getRound(0).isLiveOrBlank()) {
                                    System.out.println("The current round is.. LIVE");
                                } else {
                                    System.out.println("The current round is.. BLANK");
                                }
                                p.removeItem(0);
                                prizeMoney += 500;
                            }

                        }
                        System.out.println("[Who will be pulling the trigger? (you/opp)] ");
                        String triggerChoice = sc.next();
                        if (triggerChoice.equalsIgnoreCase("opp")) {
                            isOpponentsTurn = true;
                        }
                        if (triggerChoice.equalsIgnoreCase("you")) {
                            Thread.sleep(500);
                            setCommand(new PullTriggerCommand(r));
                            System.out.println(p.getName() + " pulls the trigger...");
                            if (executeCommand()) {
                                System.out.println("[" + p.getName() + " is eliminated.]");
                                System.out.println("-----------------------------");
                                players.remove(p);
                                break;
                            } else {
                                isOpponentsTurn = false;
                            }
                            System.out.println("-----------------------------");


                        }

                    } else {
                        System.out.println("[" + ai.getName() + "'s turn]");
                        System.out.println(ai.getName() + " spins the chamber");
                        r.spinTheChamber();
                        int useItem = random.nextInt(2);
                        int playerOrDealer = random.nextInt(2);
                        Thread.sleep(500);
                        if (useItem == 0) {
                            System.out.println("[" + ai.getName() + " chose to use the item]" + "\n");
                            Thread.sleep(500);
                            if (ai.itemsSize() == 0) {
                                System.out.println(ai.getName() + ": No items. What a terrible shame...");
                            } else {
                                liveOrBlank = r.getRound(0).isLiveOrBlank();
                                ai.removeItem(0);
                                Thread.sleep(500);
                                System.out.println(ai.getName() + ": Very interesting...");
                                prizeMoney += 500;
                            }


                        }
                        Thread.sleep(500);
                        if (playerOrDealer == 0) {
                            System.out.println("[" + ai.getName() + " chose to let you pull the trigger]"+ "\n");

                            isOpponentsTurn = false;

                        } else {
                            System.out.println("[" + ai.getName() + " chose to pull the trigger on himself]" + "\n");

                            setCommand(new PullTriggerCommand(r));
                            System.out.println(ai.getName() + " pulls the trigger...");
                            Thread.sleep(500);
                            if (executeCommand()) {
                                System.out.println("[" + ai.getName() + " is eliminated.]");
                                System.out.println("-----------------------------");
                                players.remove(ai);
                                break;
                            } else {
                                isOpponentsTurn = true;

                            }

                        }
                        System.out.println("-----------------------------");

                    }

                    prizeMoney += 1000;
                }
                System.out.println();
                System.out.println("CONGRATULATIONS. The winner is " + players.get(0).getName() + "." + "\n"
                        + "They leave with $ " + prizeMoney);


                isAValidNumber = true;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (InputMismatchException | IndexOutOfBoundsException e) {
                System.out.println("Incorrect input!");
                isAValidNumber = false;
                sc.next();

            }
        } while (!isAValidNumber);

    }


}

