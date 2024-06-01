package Guns;

public class Bullet {

    private final boolean liveOrBlank;

    public Bullet(boolean liveOrBlank) {
        this.liveOrBlank = liveOrBlank;
    }

    public boolean isLiveOrBlank() {
        return liveOrBlank;
    }


    @Override
    public String toString() {
        return "liveOrBlank=" + liveOrBlank;
    }
}
