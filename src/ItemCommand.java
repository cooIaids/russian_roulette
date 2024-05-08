import java.util.Scanner;

public class ItemCommand implements Command {

    private Scanner sc = new Scanner(System.in);
    private Gun g = new Gun();


    @Override
    public void execute(String s) {
        Player p = new Player();
        p.addItem(new Item(Item.TypeOfItem.POCKET_KNIFE));
        if(p.itemsSize() == 0){
            System.out.println("You have no items");
        }else{
            Item i = p.getItem(Integer.parseInt(s));
            switch (i.getType()){
                case POCKET_KNIFE:
                    g.setDamage(2*g.getDamage());
                    System.out.println(g.getDamage());
                case CIGARETTES:
                    p.setHealth(p.getHealth()+1);
                case FLIP_PHONE:

            }



        }


    }
}
