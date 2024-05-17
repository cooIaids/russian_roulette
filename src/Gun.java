import java.util.ArrayList;
import java.util.Collections;

public class Gun {

    protected ArrayList<Bullet> rounds = new ArrayList<>();
    protected int damage = 1;

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void addRounds(Bullet b){
        rounds.add(b);
    }

    public void removeRound(int index){
        rounds.remove(index);
    }

    public int size(){
        return rounds.size();
    }

    public Bullet getRound(int index){
        return rounds.get(index);
    }



    public String writeOutRounds(){
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < rounds.size(); i++){
            s.append(rounds.get(i));
        }
        return s.toString();
    }

    @Override
    public String toString() {
        return "Gun{" +
                "rounds=" + rounds +
                ", damage=" + damage +
                '}';
    }
}
