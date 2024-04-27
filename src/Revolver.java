import java.util.ArrayList;
import java.util.Collections;

public class Revolver extends Gun{


    public void spinCylinder(){
        Collections.shuffle(getAllRounds());
    }


}
