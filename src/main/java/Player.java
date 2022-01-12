public class Player {

    private static final int LIMIT = 21;
    public int score;
    public String status;

    // constructor
    public Player() {
        score = 0;
        status = "playing";
    }

    // adds a value to this players score
    public void addCard(int val) {
        score = score + val;
    }

    // returns true if the score is above the limit
    public boolean isAboveLimit() {
        if (score > LIMIT) {
            return true;
        } else {
            return false;
        }
    }

    // sets the status
    public void setStatus(String s) {
        status = s;
    }





}
