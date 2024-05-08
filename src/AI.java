import java.util.Random;

public class AI extends Player{
    private Random r = new Random();

    public void generateCommand(){
        int randomIndex = r.nextInt(commands.size());
        String randomCommand = (String) commands.keySet().toArray()[randomIndex];
        setCommand(randomCommand);
    }


}
