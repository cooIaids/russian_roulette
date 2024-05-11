public class PullTriggerCommand implements Command{

    private Gun g;

    public PullTriggerCommand(Gun g) {
        this.g = g;
    }

    @Override
    public boolean execute() {
        if(g.getRound(0).isLiveOrBlank() == true){
            System.out.println("The round is... LIVE");
            return true;
        }else {
            System.out.println("The round is... BLANK");
            return false;
        }
    }
}
