import java.util.Random;
import java.util.Scanner;

public class GameMode {

    protected final Scanner sc = new Scanner(System.in);
    protected final Random random = new Random();
    protected Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public boolean executeCommand() {
        return command.execute();
    }
}
