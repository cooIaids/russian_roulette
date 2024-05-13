public class GameMode {
    protected Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public boolean executeCommand() {
        return command.execute();
    }
}
