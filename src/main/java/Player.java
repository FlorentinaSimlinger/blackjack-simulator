public class Player {

    private final int LIMIT = 21;
    private int score;
    private boolean isPlaying;
    private final String name;

    // constructor
    public Player(String n) {
        score = 0;
        isPlaying = true;
        name = n;
    }

    // updates the score
    public void updateScore(int val) {
        score = score + val;
    }

    // returns true if the score is above the limit
    public boolean isAboveLimit() {
        return score > LIMIT;
    }

    // setters and getters
    public void setIsPlaying(boolean b) {
        isPlaying = b;
    }

    public int getScore() {
        return score;
    }

    public boolean getIsPlaying() {
        return isPlaying;
    }

    public String getName() {
        return name;
    }





}
