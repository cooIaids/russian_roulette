import java.util.ArrayList;

public class ShotgunGameModePlayer extends GameMode {

    public void startGame(){
        try {
            int prizeMoney = 0;
            ArrayList<Player> players = new ArrayList<>();
            ArrayList<Item> items = new ArrayList<>();
            items.add(new Item(Item.TypeOfItem.POCKET_KNIFE));
            items.add(new Item(Item.TypeOfItem.CIGARETTES));
            items.add(new Item(Item.TypeOfItem.MAGNIFYING_GLASS));
            items.add(new Item(Item.TypeOfItem.BEER));
            items.add(new Item(Item.TypeOfItem.EXPIRED_MEDICINE));
            items.add(new Item(Item.TypeOfItem.FLIP_PHONE));

            System.out.println("You chose to risk your life with some other strangers from the club. " +
                    "Buckshot roulette, a new, innovative version of Russian roulette.");
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
                int randomItem = random.nextInt(items.size());
                players.add(new Player());
                System.out.println("Choose a name for Player " + i + ":");
                String nameChoice = sc.next();
                players.get(i).setName(nameChoice);
                players.get(i).addItem(items.get(randomItem));


            }
            Thread.sleep(500);
            System.out.println("Game starts with " + numOfPlayers + " players. Let the dance of life and death begin...");
            Thread.sleep(500);
            System.out.println("Every player gets one item per round. Use them wisely...");
            Thread.sleep(1000);

            while (players.size() > 1) {
                Revolver r = new Revolver();
                r.addRounds(new Bullet(true));
                r.addRounds(new Bullet(false));
                r.addRounds(new Bullet(false));
                r.addRounds(new Bullet(false));
                r.addRounds(new Bullet(false));
                r.addRounds(new Bullet(false));
                for (int i = 0; i < players.size(); i++) {
                    System.out.println("[" + players.get(i).getName() + "'s turn]");
                    Thread.sleep(500);
                    System.out.println(players.get(i).getName() + " spins the chamber");
                    r.spinTheChamber();

                    System.out.println("Use ITEM (yes/no)???");
                    String playersChoice = sc.next();

                    if (playersChoice.equalsIgnoreCase("yes")) {
                        if (players.get(i).itemsSize() == 0) {
                            System.out.println("You already used your item...");
                        } else {
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
                        } else {
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
}
