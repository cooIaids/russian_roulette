import java.util.ArrayList;
import java.util.Collections;

public class Gun {

    private ArrayList<Boolean> rounds = new ArrayList<>();

    public void addRounds(Boolean b){
        rounds.add(b);
    }

    public void spinCylinder(){
        Collections.shuffle(rounds);
    }

    public boolean getRound(int index){
        return rounds.get(index);
    }

    public String writeOutRounds(){
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < rounds.size(); i++){
            s.append(rounds.get(i)).append(", ");
        }
        return s.toString();
    }
}
