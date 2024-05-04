import java.util.Scanner;

public class ItemCommand implements Command {

    private Scanner sc = new Scanner(System.in);
    private Player p = new Player();
    private Gun g = new Gun();


    @Override
    public void execute() {
        if(p.size() == 0){
            System.out.println("You have no items");
        }else{
            System.out.println("Which item do you want to use?");
            int playersChoice = 0;
            playersChoice = sc.nextInt();

        }


    }
}
