import java.util.ArrayList;
import java.util.Collections;

public class Revolver extends Gun{


    @Override
    public void addRounds(Boolean b) {
        super.addRounds(b);
    }

    @Override
    public boolean getRound(int index) {
        return super.getRound(index);
    }

    @Override
    public String writeOutRounds() {
        return super.writeOutRounds();
    }

    public void spinCylinder(){
        Collections.shuffle(getAllRounds());
    }
}
