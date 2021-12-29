package ballboy.model.entities.behaviour;

import ballboy.model.Level;
import ballboy.model.entities.DynamicEntity;
import ballboy.model.entities.utilities.Vector2D;

/**
 * An aggressive strategy that makes the entity follow the ballboy.
 * Acceleration is applied horizontally in the direction of the ballboy
 * until a maximum velocity is reached.
 */
public class SquareCatBehaviourStrategy implements BehaviourStrategy {

    private final Level level;
    private int xOffset = -100;
    private int yOffset = -150;// -40 : 60
    public SquareCatBehaviourStrategy(Level level) {
        this.level = level;
    }

    @Override
    public void behave(
            DynamicEntity entity,
            double frameDurationMilli) {

        if (yOffset ==150 && xOffset ==-100 ){
             xOffset+=5;
        }
        else if (yOffset ==150 && xOffset !=100){
            xOffset+=5;
        }
        else if (xOffset == 100 && yOffset == 150){
                yOffset-=5;
            
        }
        else if (xOffset ==100 && yOffset != -150){
            yOffset-=5;
        }
        else if (yOffset == -150 && xOffset ==100)
        {
            xOffset-=5;
        }
        else if (yOffset == -150 && xOffset !=-100)
        {
            xOffset-=5;
        }
        else if (yOffset == -150 && xOffset  == -100){
            yOffset+=5;
        }
        else if (xOffset ==-100 && yOffset != 150){
            yOffset+=5;
        }
        entity.setPosition(entity.getPosition().setY(entity.getPositionBeforeLastUpdate().getY()));
        entity.setVelocity(entity.getVelocity().setY(0));
        Vector2D newPos = new Vector2D(level.getHeroX()+xOffset,level.getHeroY()+yOffset);
        entity.setPosition(newPos);
    }
}