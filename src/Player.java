import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Player {

    protected String name;
    protected int health;
    protected ArrayList<Item> playersItems = new ArrayList<>(8);

    protected Command command;
    protected HashMap<String, Command> commands = new HashMap<>();
    private Scanner sc = new Scanner(System.in);


    public void initialisation(){
        commands.put("use gun", new GunCommand());
        commands.put("help", new HelpCommand());
        commands.put("use item", new ItemCommand());
    }

    public void setCommand(String commandName) {
        this.command = commands.get(commandName);
    }

    public void executeCommand(String s){
        if(command != null){
            command.execute(s);
        }else {
            System.out.println("Command not found");
        }
    }


    public void addItem(Item i){
        playersItems.add(i);
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int itemsSize(){
        return playersItems.size();
    }

    public String writeOutItems(){
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < playersItems.size(); i++){
            s.append(playersItems.get(i));
        }
        return s.toString();
    }

    public Item getItem(int index){
        return playersItems.get(index);
    }

    public void useAnItem(int index){
        Item i = playersItems.get(index);
        switch (i.getType()){

        }
    }


    public void usingTheGun(String playersChoice){

    }
}
