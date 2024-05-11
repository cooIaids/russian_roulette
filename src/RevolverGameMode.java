import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RevolverGameMode {

    private final Scanner sc = new Scanner(System.in);
    private final Random random = new Random();
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public boolean executeCommand() {
        return command.execute();
    }

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
            while (players.size() > 1) {
                Revolver r = new Revolver();
                r.addRounds(new Bullet(true));
                r.addRounds(new Bullet(false));
                r.addRounds(new Bullet(false));
                r.addRounds(new Bullet(false));
                r.addRounds(new Bullet(false));
                r.addRounds(new Bullet(false));
                for (Player player : players) {
                    System.out.println("[" + player.getName() + "'s turn]");
                    System.out.println(player.getName() + " spins the chamber");
                    r.spinTheChamber();

                    System.out.println("Use ITEM (yes/no)???");
                    String playersChoice = sc.next();
                    if (playersChoice.equalsIgnoreCase("yes")) {
                        System.out.println(r.getRound(0).isLiveOrBlank());
                        prizeMoney -= 500;
                    }
                    System.out.println("Who will be pulling the trigger???");
                    String triggerChoice = sc.next();
                    if (triggerChoice.equalsIgnoreCase("opp")) {
                        continue;
                    }
                    if (triggerChoice.equalsIgnoreCase("you")) {
                        Thread.sleep(300);
                        setCommand(new PullTriggerCommand(r));
                        System.out.println(player.getName() + " pulls the trigger...");
                        if (executeCommand()) {
                            System.out.println(player.getName() + " is eliminated.");
                            players.remove(player);
                            break;
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


                System.out.println("[" + p.getName() + "'s turn]");
                System.out.println(p.getName() + " spins the chamber.");
                r.spinTheChamber();
                System.out.println("Use ITEM (yes/no)???");
                String playersChoice = sc.next();
                if (playersChoice.equalsIgnoreCase("yes")) {
                    System.out.println(r.getRound(0).isLiveOrBlank());
                    prizeMoney -= 500;
                }
                System.out.println("Who will be pulling the trigger???");
                String triggerChoice = sc.next();
                if (triggerChoice.equalsIgnoreCase("opp")) {
                    continue;
                }
                if (triggerChoice.equalsIgnoreCase("you")) {
                    Thread.sleep(300);
                    setCommand(new PullTriggerCommand(r));
                    System.out.println(p.getName() + " pulls the trigger...");
                    if (executeCommand()) {
                        System.out.println(p.getName() + " is eliminated.");
                        players.remove(p);
                        break;
                    }


                }
                System.out.println();
                System.out.println("[" + ai.getName() + "'s turn]");
                System.out.println(ai.getName() + " spins the chamber");
                r.spinTheChamber();
                int useItem = random.nextInt(2);
                switch (useItem){
                    case 0:
                        System.out.println("[The Dealer chose to use the item]");
                        boolean liveOrBlank = r.getRound(0).isLiveOrBlank();
                        System.out.println(ai.getName() +": Very interesting...");
                        prizeMoney -= 500;
                        if(liveOrBlank){
                            continue;
                        }
                        if(!liveOrBlank){
                            Thread.sleep(300);
                            setCommand(new PullTriggerCommand(r));
                            System.out.println(p.getName() + " pulls the trigger...");
                            if (executeCommand()) {
                                System.out.println(p.getName() + " is eliminated.");
                                players.remove(p);
                                break;
                            }
                        }

                    case 1:
                        System.out.println("[The Dealer chose to pull the trigger on himself]");
                        Thread.sleep(500);
                        System.out.println(ai.getName() + ": Are you ready..?");
                        setCommand(new PullTriggerCommand(r));
                        System.out.println(ai.getName() + " pulls the trigger...");
                        if (executeCommand()) {
                            System.out.println(ai.getName() + " is eliminated.");
                            players.remove(ai);
                            break;
                        }

                }

                prizeMoney += 1000;
            }
            System.out.println("CONGRATULATIONS. The winner is " + players.get(0).getName() + "." + "\n"
                    + "You leave with $ " + prizeMoney);


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}

