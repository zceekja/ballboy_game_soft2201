package ballboy.model.snapshot;
import ballboy.model.CurrentScoreDisplay;

public class CurrentScoreSnapShot implements SnapShot {
    private int red_score=0;
    private int blue_score=0;
    private int green_score=0;
    CurrentScoreDisplay score;
    public CurrentScoreSnapShot(CurrentScoreDisplay score, int red, int blue, int green){
        this.red_score = red;
        this.blue_score = blue;
        this.green_score = green;
        this.score =score;
    }
    public void restore(){
        score.setScore(red_score, blue_score,green_score);
        System.out.println("set new score");
    }
}
