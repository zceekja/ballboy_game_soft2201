package ballboy.model.factories;

import ballboy.ConfigurationParseException;
import ballboy.model.Entity;
import ballboy.model.Level;
import ballboy.model.entities.behaviour.SquareCatBehaviourStrategy;
import ballboy.model.entities.collision.CatCollisionStrategy;
import ballboy.model.entities.DynamicEntityImpl;
import ballboy.model.entities.utilities.AxisAlignedBoundingBox;
import ballboy.model.entities.utilities.AxisAlignedBoundingBoxImpl;
import ballboy.model.entities.utilities.KinematicState;
import ballboy.model.entities.utilities.KinematicStateImpl;
import ballboy.model.entities.utilities.Vector2D;
import javafx.scene.image.Image;
import org.json.simple.JSONObject;

 /*
 * Concrete entity factory for cloud entities.
 */

public class CatFactory implements EntityFactory {

    @Override
    public Entity createEntity(
            Level level,
            JSONObject config) {
                System.out.println("cat created");
        try {
            double startX = ((Number) config.get("startX")).doubleValue();
            double startY = ((Number) config.get("startY")).doubleValue();
            String imageName = (String) config.getOrDefault("image", "cat.png");

            Vector2D startingPosition = new Vector2D(startX, startY);

            KinematicState kinematicState = new KinematicStateImpl.KinematicStateBuilder()
                    .setPosition(startingPosition)
                    .setHorizontalVelocity(0)
                    .build();

            Image image = new Image(imageName);

            AxisAlignedBoundingBox volume = new AxisAlignedBoundingBoxImpl(
                    startingPosition,
                    image.getHeight(),
                    image.getWidth()
            );
            System.out.println("cat created");
            return new DynamicEntityImpl(  
                    kinematicState,        
                    volume,
                    Entity.Layer.FOREGROUND,
                    image,
                    new CatCollisionStrategy(level),
                    new SquareCatBehaviourStrategy(level)
            );

        } catch (Exception e) {
            System.out.println("cat fail to create");
            throw new ConfigurationParseException(
                    String.format("Invalid cloud entity configuration | %s | %s", config, e));
        }
    }
}
