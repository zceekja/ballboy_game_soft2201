package ballboy.model.snapshot;
import ballboy.model.TotalScoreDisplay;
public class TotalScoreSnapShot implements SnapShot {
    private int total_score =0;
    TotalScoreDisplay display;
    public TotalScoreSnapShot(TotalScoreDisplay display, int score){
        this.total_score =score;
        System.out.println("saved score");
        System.out.println(total_score);
        this.display =display;
    }
    public void restore(){
        System.out.println(total_score);
        display.setScore(total_score);

    }

}
