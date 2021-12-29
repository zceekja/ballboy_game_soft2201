package ballboy.model.snapshot;
import java.util.*;
import ballboy.model.Observer;
import ballboy.model.GameEngine;
import ballboy.model.Level;
public class GameEngineSnapShot implements SnapShot{
    private List<Level> levels;
    private Level level;
    public List<Observer> observers;
    public GameEngine gm;

    public GameEngineSnapShot (GameEngine gm, List<Level> levels, Level level, List<Observer> observers ){
        this.levels = levels;
        for (int i = 0; i< levels.size();i++){
            levels.get(i).backup();
        }
        this.level = level;

        this.gm = gm;
        this.observers = observers;
        for (int i = 0; i< observers.size(); i++){
            observers.get(i).backup();
        }
    }

    public void restore(){
        for (int i = 0; i< levels.size();i++){
            levels.get(i).restore();
        }
        for(int i = 0; i < observers.size(); i++){
            observers.get(i).restore();
        }
        gm.setlevel(level);
        gm.setObservers(observers);
    }
}
