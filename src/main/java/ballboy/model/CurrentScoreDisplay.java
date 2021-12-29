package ballboy.model;
import ballboy.model.Entity;
import ballboy.model.entities.DynamicEntity;
import ballboy.model.snapshot.CurrentScoreSnapShot;
public class CurrentScoreDisplay implements Observer {
    private int red_score=0;
    private int blue_score=0;
    private int green_score=0;
    private CurrentScoreSnapShot backup;
    public String output ="Current Level Red Score: " + Integer.toString(red_score) + "\n"+ "Current Level Blue Score: " + Integer.toString(blue_score) + "\n" + "Current Level Green Score: " + Integer.toString(green_score) + "\n";

    public CurrentScoreDisplay(Level x){
        x.registerObserver(this);
        System.out.println("observer registered");
    }
    public void update(Entity entity){
       if(entity.getColour().equals("red")){
            red_score++;
       }
       if(entity.getColour().equals("blue")){
        blue_score++;
  
        }
        if(entity.getColour().equals("green")){
            green_score++;
    
       }
        updatedisplay();
        print();
    }
    public void updatedisplay(){
        output = "Current Level Red Score: " + Integer.toString(red_score) + "\n"+ "Current Level Blue Score: " + Integer.toString(blue_score) + "\n" + "Current Level Green Score: " + Integer.toString(green_score) + "\n";
    }
    public String print(){

        return output;
    }
    public void backup(){
        backup = new CurrentScoreSnapShot(this, red_score, blue_score, green_score);
    }
    public void restore(){
        backup.restore();
    }
    public void setScore(int red_score, int blue_score, int green_score){
        this.red_score =red_score;
        this.blue_score = blue_score;
        this.green_score = green_score;
        updatedisplay();
    }

}
