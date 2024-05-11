import java.util.ArrayList;
import java.util.Scanner;

public class GameMode {

    private final Scanner sc = new Scanner(System.in);
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
                    "The classic version of Russian Roulette, can't be beat");
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
                players.get(i).setName("Player " + i);
                players.get(i).addItem(new Item(Item.TypeOfItem.MAGNIFYING_GLASS));
            }
            Thread.sleep(500);
            System.out.println("Game starts with " + numOfPlayers + " players. Let the dance of life and death begin");
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
                    System.out.println(player.getName() + "'s turn");
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
        }catch(InterruptedException e){
            throw new RuntimeException(e);
        }
    }


}

