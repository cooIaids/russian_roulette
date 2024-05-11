

import java.util.Scanner;

public class GunCommand implements Command {
    private Scanner sc = new Scanner(System.in);
    private Gun g = new Gun();
    @Override
    public void execute(String s) {
        Player p1 = new Player();
        Player p2 = new Player();
        int oppHealth = 3;
        int yourHealth = 3;

        System.out.println("Player used the gun");
        if(s.equalsIgnoreCase("you")){
            System.out.println("Player chose to shoot themselves");

        }else if (s.equalsIgnoreCase("opp")){
            System.out.println("Player chose to shoot opponent");

        }

       /* Gun g = new Gun();
        Player player = new Player();
        Player opponent = new Player();
        Bullet currentRound ;
        System.out.println("Shoot (YOU)RSELF or the (OPP)onent???");
        System.out.println("(Shooting yourself with a blank skips opponent's turn (max. 2 times))");
        String playersChoice = sc.next();
        for(int i = 0; i < g.size(); i++){
            currentRound = g.getRound(i);
            switch(playersChoice){
                case "YOU":
                    System.out.println("You chose to shoot YOURSELF");
                    if(currentRound.isLiveOrBlank() == true){
                        System.out.println("The round is... LIVE");
                        player.health-=1;
                        g.removeRound(currentRound);
                        if(player.health == 0){
                            System.out.println(player.name + "DIED");
                        }

                    } else if (currentRound.isLiveOrBlank() == false) {
                        System.out.println("The round is... BLANK");
                        g.removeRound(currentRound);


                    }
                case "OPP":
                    System.out.println("You chose to shoot the OPPONENT");
                    if(currentRound.isLiveOrBlank() == true){
                        System.out.println("The round is... LIVE");
                        opponent.health-=1;
                        g.removeRound(currentRound);
                        if(opponent.health == 0){
                            System.out.println(opponent.name + "DIED");
                        }


                    } else if (currentRound.isLiveOrBlank() == false) {
                        System.out.println("The round is... BLANK");
                        g.removeRound(currentRound);
                    }



            }
        }*/


    }
}
