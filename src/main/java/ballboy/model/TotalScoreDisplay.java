
package ballboy.model;
import ballboy.model.Entity;
import ballboy.model.entities.DynamicEntity;
import ballboy.model.snapshot.TotalScoreSnapShot;
public class TotalScoreDisplay implements Observer {
    private int score=0;
    private TotalScoreSnapShot backup;
    public String output ="Total Score: " + Integer.toString(score) + "\n";

    public TotalScoreDisplay(GameEngine model){
        model.registerObserver(this);
        System.out.println("observer registered");
    }
    public void update(Entity entity){
        score++;
        updatedisplay();
        print();
    }
    public void updatedisplay(){
        output = "Total Score: " + Integer.toString(score) + "\n";
    }
    public String print(){
 
        return output;
    }
    public void backup(){
        backup = new TotalScoreSnapShot(this, score);
    }
    public void restore(){
        backup.restore();
    }
    public void setScore(int score){
    
        this.score = score;
        updatedisplay();
    }
}
