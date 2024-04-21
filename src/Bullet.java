public class Bullet {

    private boolean liveOrBlank;

    public Bullet(boolean liveOrBlank) {
        this.liveOrBlank = liveOrBlank;
    }

    public boolean isLiveOrBlank() {
        return liveOrBlank;
    }

    public void setLiveOrBlank(boolean liveOrBlank) {
        this.liveOrBlank = liveOrBlank;
    }

    @Override
    public String toString() {
        return "liveOrBlank=" + liveOrBlank;
    }
}
