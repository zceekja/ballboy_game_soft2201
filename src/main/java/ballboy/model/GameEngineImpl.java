package ballboy.model;

import java.util.*;

import ballboy.model.snapshot.GameEngineSnapShot;

/**
 * Implementation of the GameEngine interface.
 * This provides a common interface for the entire game.
 */
public class GameEngineImpl implements GameEngine {
    private Level level;
    public List<Level> levels;
    public List<Observer> observers;
    public GameEngineSnapShot backup;
    public GameEngineImpl( List<Level>  levels) {
        //this.level = level;
        this.levels = levels;
        this.level =levels.get(0);
        this.level.setGM(this);
        observers = new ArrayList<>();
        new TotalScoreDisplay(this);
    }

    public Level getCurrentLevel() {
        return level;
    }

    public void startLevel() {
        // TODO: Handle when multiple levels has been implemented
        System.out.println("fwfew");
        this.level =levels.get(level.getCurrentLevel()+1);
        this.level.setGM(this);
        
        return;
    }

    public boolean boostHeight() {
        return level.boostHeight();
    }

    public boolean dropHeight() {
        return level.dropHeight();
    }

    public boolean moveLeft() {
        return level.moveLeft();
    }

    public boolean moveRight() {
        return level.moveRight();
    }

    public void tick() {
        level.update();
    }
    public List<Level> getLevel(){
        return levels;
    }
    public void registerObserver(Observer o){
        observers.add(o);
    }
    public void removeObserver(Observer o){
        ;
    }
    public void notifyObservers(Entity entity){
        System.out.println("update");
        observers.forEach(o -> o.update(entity));
    }
    public List<Observer> getObservers(){
        return this.observers;
    }
    public void save(){
        System.out.println("progress saved");
        backup = new GameEngineSnapShot(this, levels,level, observers);
    }

    public void restore(){
        System.out.println("progress restored");;
        backup.restore();
    }
    public void setlevel(Level level){
        this.level =level;
    }
    public void setObservers(List<Observer> observers){
        this.observers = observers;
        System.out.println("reset score");
    }
}