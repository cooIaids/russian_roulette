import java.util.ArrayList;
import java.util.Collections;

public class Gun {

    private ArrayList<Bullet> rounds = new ArrayList<>();

    public void addRounds(Bullet b){
        rounds.add(b);
    }

    public ArrayList<Bullet> getAllRounds(){
        return new ArrayList<>(rounds);
    }

    public boolean getRound(int index){
        return rounds.get(index).isLiveOrBlank();
    }

    public String writeOutRounds(){
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < rounds.size(); i++){
            s.append(rounds.get(i)).append(", ");
        }
        return s.toString();
    }


}
