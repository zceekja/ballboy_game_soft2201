package ballboy.model.entities.collision;

import ballboy.model.Entity;
import ballboy.model.Level;


public class CatCollisionStrategy implements CollisionStrategy {
    private final Level level;

    public CatCollisionStrategy(Level level) {
        this.level = level;
    }

    @Override
    public void collideWith(
            Entity cat,
            Entity hitEntity) {
        if( this.level.isEnemy(hitEntity)){
            System.out.println("hit enemy");
            this.level.notifyObservers(hitEntity);
            this.level.getEngine().notifyObservers(hitEntity);
            this.level.killEnemy(hitEntity);
        }
    }
}

