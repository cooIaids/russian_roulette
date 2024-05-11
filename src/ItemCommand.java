

public class ItemCommand implements Command {





    @Override
    public void execute(String s) {
        Player p = new Player();
        if(p.itemsSize() == 0){
            System.out.println("You have no items");
        }else{
            Item i = p.getItem(Integer.parseInt(s));
            switch (i.getType()){
                case POCKET_KNIFE:
                case CIGARETTES:
                case FLIP_PHONE:

            }



        }


    }
}
