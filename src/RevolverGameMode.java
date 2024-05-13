import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RevolverGameMode extends GameMode {

    private final Scanner sc = new Scanner(System.in);
    private final Random random = new Random();


    public void revolverWithPlayers() {
        try {
            int prizeMoney = 0;
            ArrayList<Player> players = new ArrayList<>();
            System.out.println("You chose to risk your life with some other strangers from the club. " +
                    "The classic version of Russian Roulette, can't be beat.");
            System.out.println("[Press any button to continue]");
            sc.nextLine();
            Thread.sleep(500);
            System.out.println("Enter number of players: ");
            int numOfPlayers = sc.nextInt();
            if (numOfPlayers < 2) {
                System.out.println("Not enough players");
                return;
            }
            for (int i = 0; i < numOfPlayers; i++) {
                players.add(new Player());
                System.out.println("Choose a name for Player " + i + ":");
                String nameChoice = sc.next();
                players.get(i).setName(nameChoice);
                players.get(i).addItem(new Item(Item.TypeOfItem.MAGNIFYING_GLASS));
            }
            Thread.sleep(500);
            System.out.println("Game starts with " + numOfPlayers + " players. Let the dance of life and death begin...");
            Thread.sleep(500);
            System.out.println("Every player has (ONE) MAGNIFYING GLASS item. Use it wisely...");
            Thread.sleep(1000);

            while (players.size() > 1) {
                Revolver r = new Revolver();
                r.addRounds(new Bullet(true));
                r.addRounds(new Bullet(false));
                r.addRounds(new Bullet(false));
                r.addRounds(new Bullet(false));
                r.addRounds(new Bullet(false));
                r.addRounds(new Bullet(false));
                    for(int i = 0; i < players.size(); i++){
                        System.out.println("[" + players.get(i).getName() + "'s turn]");
                        Thread.sleep(500);
                        System.out.println(players.get(i).getName() + " spins the chamber");
                        r.spinTheChamber();

                        System.out.println("Use ITEM (yes/no)???");
                        String playersChoice = sc.next();

                        if (playersChoice.equalsIgnoreCase("yes")) {
                            if (players.get(i).itemsSize() == 0){
                                System.out.println("You already used your item...");
                            }else {
                                System.out.println(r.getRound(0).isLiveOrBlank());
                                players.get(i).removeItem(0);
                                prizeMoney -= 400;
                            }

                        }
                        System.out.println("Who will be pulling the trigger???");
                        String triggerChoice = sc.next();
                        if (triggerChoice.equalsIgnoreCase("opp")) {
                            continue;
                        }
                        if (triggerChoice.equalsIgnoreCase("you")) {
                            Thread.sleep(300);
                            setCommand(new PullTriggerCommand(r));
                            System.out.println(players.get(i).getName() + " pulls the trigger...");
                            if (executeCommand()) {
                                System.out.println(players.get(i).getName() + " is eliminated.");
                                players.remove(players.get(i));
                                break;
                            }else {
                                i--;
                            }


                        }



                    prizeMoney += 1000;

                }
            }
            System.out.println("CONGRATULATIONS. The winner is " + players.get(0).getName() + "." + "\n"
                    + "You leave with $ " + prizeMoney);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void revolverWithAI() {
        try {
            int prizeMoney = 0;
            ArrayList<Player> players = new ArrayList<>();
            System.out.println("You chose to play with The Dealer. The look he gives you is soul-wrenching." +
                    "The classic version of Russian Roulette, can't be beat.");
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
            while (players.size() > 1) {
                Revolver r = new Revolver();
                r.addRounds(new Bullet(true));
                r.addRounds(new Bullet(false));
                r.addRounds(new Bullet(false));
                r.addRounds(new Bullet(false));
                r.addRounds(new Bullet(false));
                r.addRounds(new Bullet(false));


                boolean isOpponentsTurn = false;
                if(isOpponentsTurn == false){
                    System.out.println("[" + p.getName() + "'s turn]");
                    System.out.println(p.getName() + " spins the chamber.");
                    r.spinTheChamber();
                    System.out.println("Use ITEM (yes/no)???");
                    String playersChoice = sc.next();
                    if (playersChoice.equalsIgnoreCase("yes")) {
                        if(p.itemsSize() == 0){
                            System.out.println("You already used your item");
                        }else {
                            System.out.println(r.getRound(0).isLiveOrBlank());
                            prizeMoney -= 500;
                        }

                    }
                    System.out.println("Who will be pulling the trigger?");
                    String triggerChoice = sc.next();
                    if (triggerChoice.equalsIgnoreCase("opp")) {
                        isOpponentsTurn = true;
                    }
                    if (triggerChoice.equalsIgnoreCase("you")) {
                        Thread.sleep(500);
                        setCommand(new PullTriggerCommand(r));
                        System.out.println(p.getName() + " pulls the trigger...");
                        if (executeCommand()) {
                            System.out.println(p.getName() + " is eliminated.");
                            players.remove(p);
                            break;
                        }else {
                            isOpponentsTurn = false;
                        }


                    }
                }

                System.out.println();
                if(isOpponentsTurn == true){
                    System.out.println("[" + ai.getName() + "'s turn]");
                    System.out.println(ai.getName() + " spins the chamber");
                    r.spinTheChamber();
                    int useItem = random.nextInt(2);
                    boolean liveOrBlank = false;
                    if(useItem == 0 && ai.itemsSize() == 0){
                        System.out.println("The Dealer: No items. What a terrible shame...");
                    }
                    if(useItem == 0){
                        System.out.println("[The Dealer chose to use the item]");
                         liveOrBlank = r.getRound(0).isLiveOrBlank();
                         ai.removeItem(0);
                         Thread.sleep(500);
                        System.out.println(ai.getName() +": Very interesting...");
                        prizeMoney -= 500;

                    }else {
                        if(liveOrBlank){
                            continue;
                        }
                        if(!liveOrBlank){
                            Thread.sleep(300);
                            setCommand(new PullTriggerCommand(r));
                            System.out.println(ai.getName() + " pulls the trigger...");
                            if (executeCommand()) {
                                System.out.println(ai.getName() + " is eliminated.");
                                players.remove(ai);
                                break;
                            }else {
                                isOpponentsTurn = true;
                            }
                        }
                        System.out.println("[The Dealer chose to pull the trigger on himself]");
                        Thread.sleep(500);
                        System.out.println(ai.getName() + ": Are you ready..?");
                        setCommand(new PullTriggerCommand(r));
                        System.out.println(ai.getName() + " pulls the trigger...");
                        if (executeCommand()) {
                            System.out.println(ai.getName() + " is eliminated.");
                            players.remove(ai);
                            break;
                        }else {
                            isOpponentsTurn = true;


                        }
                    }
                }


                prizeMoney += 1000;
            }
            System.out.println("CONGRATULATIONS. The winner is " + players.get(0).getName() + "." + "\n"
                    + "leaving with $ " + prizeMoney);


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}

