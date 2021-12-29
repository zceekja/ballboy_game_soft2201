package ballboy.model.snapshot;

import ballboy.model.entities.DynamicEntity;

import java.util.*;
import ballboy.model.Level;
import ballboy.model.Entity;
import ballboy.model.Observer;
public class LevelSnapshot implements SnapShot{
    private  List<Entity> entities = new ArrayList<>();
    private Level level;
    private int game_end;
    public List<Observer> observers;
 

    public LevelSnapshot(Level level, List<Entity> entities, List<Observer> observers, int game_end){
 
        this.level = level;
        this.entities = entities;
        this.observers = observers;
        this.game_end = game_end;
        for (int i =0;  i < entities.size() ; i++ ){
            try{
                ((DynamicEntity) entities.get(i)).backup();
                System.out.println("Entity saved");
            }catch (Exception e){
                System.out.println("this is not dynamic entity");
            }
        }
        for (int i = 0; i< observers.size(); i++){
            observers.get(i).backup();
        }
    }

    public void restore(){
        level.setEntities(entities,game_end);

        for(int i = 0; i < observers.size(); i++){
            observers.get(i).restore();
        }
        for(int i = 0; i < entities.size(); i++){
            try{
                ((DynamicEntity)entities.get(i)).restore();
            } catch(Exception e){
                System.out.println("this is not dynamic entity");
            }
        }
    }
}
