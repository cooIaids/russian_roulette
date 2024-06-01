package GameModes;

import EntitiesAndItems.*;
import Guns.*;
import Command.*;

import java.util.ArrayList;
import java.util.InputMismatchException;

public class ShotgunGameModeAI extends GameMode {

    /**
     * Starts game mode where the EntitiesAndItems.Player plays against EntitiesAndItems.AI with Guns.Shotgun.
     */
    public void startGame(){
        boolean isAValidNumber;
        do{
            try {
                int prizeMoney = 25000;
                ArrayList<Player> players = new ArrayList<>();
                ArrayList<Item> items = new ArrayList<>();
                items.add(new Item(Item.TypeOfItem.POCKET_KNIFE));
                items.add(new Item(Item.TypeOfItem.CIGARETTES));
                items.add(new Item(Item.TypeOfItem.MAGNIFYING_GLASS));
                items.add(new Item(Item.TypeOfItem.BEER));
                items.add(new Item(Item.TypeOfItem.EXPIRED_MEDICINE));
                items.add(new Item(Item.TypeOfItem.FLIP_PHONE));

                System.out.println(">You chose to play with The Dealer. The look he gives you is soul-wrenching. " + "\n" +
                        ">Buckshot roulette, a new, innovative version of Russian roulette.");
                System.out.println("[Press any button to continue]");
                sc.nextLine();
                Thread.sleep(500);
                System.out.println("Do you wish to remove any items from the game? (yes/no)");
                String playersChoiceToRemove = sc.next();
                Thread.sleep(500);
                if (playersChoiceToRemove.equalsIgnoreCase("yes")){
                    System.out.println("Which item do you want to remove?");
                    System.out.println("""
                            List of available items:\s
                            'knife' - POCKET_KNIFE
                            'cig' - CIGARETTES
                            'glass' - MAGNIFYING_GLASS
                            'beer' - BEER
                            'medicine' - EXPIRED_MEDICINE
                            'phone' - FLIP_PHONE
                            """);
                    String itemToRemove = sc.next();
                    switch (itemToRemove){
                        case "knife": items.remove(new Item(Item.TypeOfItem.POCKET_KNIFE));
                        case "cig": items.remove(new Item(Item.TypeOfItem.CIGARETTES));
                        case "glass": items.remove(new Item(Item.TypeOfItem.MAGNIFYING_GLASS));
                        case "beer": items.remove(new Item(Item.TypeOfItem.BEER));
                        case "medicine": items.remove(new Item(Item.TypeOfItem.EXPIRED_MEDICINE));
                        case "phone": items.remove(new Item(Item.TypeOfItem.FLIP_PHONE));
                    }
                }
                Thread.sleep(500);
                int randomItem;


                Player p = new Player();
                System.out.println("Your name is: ");
                String nameChoice = sc.next();
                p.setName(nameChoice);
                p.setCurrentHealth(p.getMaxHealth());
                randomItem = random.nextInt(items.size());
                p.addItem(items.get(randomItem));

                AI ai = new AI();
                ai.setName("The Dealer");
                ai.setCurrentHealth(ai.getMaxHealth());
                randomItem = random.nextInt(items.size());
                ai.addItem(items.get(randomItem));

                players.add(p);
                players.add(ai);


                Thread.sleep(500);
                System.out.println("Let the dance of life and death begin...");
                Thread.sleep(500);
                System.out.println("Every player gets one item. Use it wisely...");
                Thread.sleep(1000);
                boolean isOpponentsTurn = false;
                while (players.size() > 1) {
                    int indexOfItem = 0;
                    boolean usedTheKnife = false;
                    Shotgun sg = new Shotgun();
                    int randomLiveOrBlank;
                    if(sg.size() == 0){
                        for(int i = 0; i < 9;i++){
                            randomLiveOrBlank = random.nextInt(2);
                            if(randomLiveOrBlank == 0){
                                sg.addRounds(new Bullet(true));
                            }else {
                                sg.addRounds(new Bullet(false));
                            }
                        }
                    }

                    System.out.println();
                    System.out.println("-----------------------------");
                    if(!isOpponentsTurn){
                        System.out.println("[" + p.getName() + "'s turn]");
                        Thread.sleep(500);
                        System.out.println(p.getName() + "'s items: " + p.writeOutItems());
                        System.out.println("Use an ITEM (yes/no)?");
                        String playersChoice = sc.next();
                        if (playersChoice.equalsIgnoreCase("yes")) {
                            if (p.itemsSize() == 0) {
                                System.out.println("You don't have any items...");
                            } else {
                                System.out.println("Choose which item you want to use: ");
                                indexOfItem = sc.nextInt();
                                p.useAnItem(indexOfItem,sg);
                                if(ai.getItem(indexOfItem).getType().equals(Item.TypeOfItem.POCKET_KNIFE)){
                                    usedTheKnife = true;
                                }
                                prizeMoney += 500;
                            }

                        }
                        System.out.println();
                        System.out.println("[Who will be pulling the trigger? (you/opp)] ");
                        String triggerChoice = sc.next();
                        if (triggerChoice.equalsIgnoreCase("opp")) {
                            isOpponentsTurn = true;
                        }
                        if (triggerChoice.equalsIgnoreCase("you")) {
                            setCommand(new PullTriggerCommand(sg));
                            System.out.println(p.getName() + " pulls the trigger...");
                            if (executeCommand()) {
                                sg.removeRound(0);
                                System.out.println(p.getName() + " lost " + sg.getDamage() + " life/lives.");
                                p.setCurrentHealth(p.getCurrentHealth() - sg.getDamage());
                                if(p.getCurrentHealth() == 0){
                                    players.remove(p);
                                    break;
                                }
                            } else {
                                sg.removeRound(0);
                                isOpponentsTurn = false;

                            }
                            System.out.println("-----------------------------");

                        }
                    }else{
                        System.out.println("[" + ai.getName() + "'s turn]");
                        Thread.sleep(500);
                        System.out.println(ai.getName() + "'s items: " + ai.writeOutItems());
                        int useItem = random.nextInt(2);
                        int playerOrDealer = random.nextInt(2);

                        if (useItem == 0) {
                            System.out.println("[" + ai.getName()  + " chose to use an item]" + "\n");
                            if (ai.itemsSize() == 0) {
                                System.out.println(ai.getName() + ": No items. What a terrible shame...");
                            } else {
                                int randomIndexOfItem = random.nextInt(ai.itemsSize());
                                ai.useAnItem(randomIndexOfItem, sg);
                                System.out.println("[" + ai.getName() + " used the" + items.get(randomIndexOfItem).toString()  + "]");
                                if(ai.getItem(indexOfItem).getType().equals(Item.TypeOfItem.POCKET_KNIFE)){
                                    usedTheKnife = true;
                                }
                                prizeMoney += 500;
                            }


                        }else{
                            System.out.println("[" + ai.getName()  + " chose to not use an item]" + "\n");
                        }
                        if (playerOrDealer == 0) {
                            System.out.println("["+ ai.getName() + " chose to let you pull the trigger]" + "\n");
                            isOpponentsTurn = false;

                        }else {
                            Thread.sleep(300);
                            System.out.println("["+ ai.getName() + " chose to pull the trigger on himself]" + "\n");
                            setCommand(new PullTriggerCommand(sg));
                            System.out.println(ai.getName() + " pulls the trigger...");
                            if (executeCommand()) {
                                sg.removeRound(0);
                                System.out.println("[" + ai.getName() + " is eliminated.]");
                                System.out.println("-----------------------------");
                                players.remove(ai);
                                break;
                            } else {
                                sg.removeRound(0);
                                isOpponentsTurn = true;

                            }

                        }
                        if(usedTheKnife){
                            sg.setDamage(1);
                        }
                        System.out.println("-----------------------------");

                    }

                    prizeMoney += 1000;

                }

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
        }while (!isAValidNumber);

    }
}
