
import java.util.ArrayList;

public class ShotgunGameModePlayer extends GameMode {

    public void startGame(){
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

            System.out.println(">You chose to risk your life with some other strangers from the club. " + "\n" +
                    ">Buckshot roulette, a new, innovative version of Russian roulette.");
            System.out.println("[Press any button to continue]");
            sc.nextLine();
            Thread.sleep(500);
            System.out.println("Do you wish to remove any items from the game? (yes/no)");
            String playersChoiceToRemove = sc.next();
            Thread.sleep(500);
            if (playersChoiceToRemove.equalsIgnoreCase("yes")){
                System.out.println("Which item do you want to remove?");
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
            System.out.println("Enter number of players: ");
            int numOfPlayers = sc.nextInt();
            while(numOfPlayers < 2){
                 System.out.println("Not enough players");
                 System.out.println("Enter number of players: ");
                 numOfPlayers = sc.nextInt();
            }
            for (int i = 0; i < numOfPlayers; i++) {
                int randomItem = random.nextInt(items.size());
                players.add(new Player());
                System.out.println("Choose a name for Player " + i + ":");
                String nameChoice = sc.next();
                players.get(i).setName(nameChoice);
                players.get(i).setCurrentHealth(players.get(i).getMaxHealth());
                players.get(i).addItem(items.get(randomItem));


            }
            Thread.sleep(500);
            System.out.println("Game starts with " + numOfPlayers + " players. Let the dance of life and death begin...");
            Thread.sleep(500);
            System.out.println("Every player gets one item per round. Use them wisely...");
            Thread.sleep(1000);

            while (players.size() > 1) {
                int indexOfItem = 0;
                Shotgun sg = new Shotgun();
                boolean usedTheKnife = false;
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
                for (int i = 0; i < players.size(); i++) {
                    System.out.println();
                    System.out.println("[" + players.get(i).getName() + "'s turn]");

                    System.out.println(players.get(i).getName() + "'s items: " + players.get(i).writeOutItems());
                    System.out.println("Use an ITEM (yes/no)?");
                    String playersChoice = sc.next();

                    if (playersChoice.equalsIgnoreCase("yes")) {
                        if (players.get(i).itemsSize() == 0) {
                            System.out.println("You don't have any items...");
                        } else {
                            System.out.println("Choose which item you want to use: ");
                            indexOfItem = sc.nextInt();
                            players.get(i).useAnItem(indexOfItem,sg);
                            if(players.get(i).getItem(indexOfItem).getType().equals(Item.TypeOfItem.POCKET_KNIFE)){
                                usedTheKnife = true;
                            }
                            prizeMoney -= 500;
                        }

                    }
                    System.out.println();
                    System.out.println("[Who will be pulling the trigger???]");
                    String triggerChoice = sc.next();
                    if (triggerChoice.equalsIgnoreCase("opp")) {
                        continue;
                    }
                    if (triggerChoice.equalsIgnoreCase("you")) {
                        setCommand(new PullTriggerCommand(sg));
                        System.out.println(players.get(i).getName() + " pulls the trigger...");
                        if (executeCommand()) {
                            sg.removeRound(0);
                            System.out.println(players.get(i).getName() + " lost " + sg.getDamage() + " life/lives.");
                            players.get(i).setCurrentHealth(players.get(i).getCurrentHealth() - sg.getDamage());
                            if(players.get(i).getCurrentHealth() == 0){
                                players.remove(players.get(i));
                                break;
                            }
                        } else {
                            sg.removeRound(0);
                            i--;

                        }


                    }
                    if(usedTheKnife){
                        sg.setDamage(1);
                    }

                    prizeMoney += 1000;

                }
            }
            System.out.println("CONGRATULATIONS. The winner is " + players.get(0).getName() + "." + "\n"
                    + "They leave with $ " + prizeMoney);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
