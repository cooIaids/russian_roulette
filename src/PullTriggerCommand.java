public class PullTriggerCommand implements Command {

    private final Gun g;

    public PullTriggerCommand(Gun g) {
        this.g = g;
    }

    /**
     * Returns the corresponding boolean value for the current bullet round.
     * @return the value of the bullet (true = live & false = blank)
     */
    @Override
    public boolean execute() {
        if(g.getRound(0).isLiveOrBlank()){
            System.out.println("The round is... LIVE");
            return true;
        }else {
            System.out.println("The round is... BLANK");
            return false;
        }
    }
}
