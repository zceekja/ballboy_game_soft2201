package ballboy.model.factories;

import ballboy.ConfigurationParseException;
import ballboy.model.Entity;
import ballboy.model.Level;
import ballboy.model.entities.behaviour.AggressiveEnemyBehaviourStrategy;
import ballboy.model.entities.behaviour.BehaviourStrategy;
import ballboy.model.entities.behaviour.PassiveEntityBehaviourStrategy;
import ballboy.model.entities.behaviour.ScaredEnemyBehaviourStrategy;
import ballboy.model.entities.collision.CollisionStrategy;
import ballboy.model.entities.collision.EnemyCollisionStrategy;
import ballboy.model.entities.DynamicEntityImpl;
import ballboy.model.entities.utilities.AxisAlignedBoundingBox;
import ballboy.model.entities.utilities.AxisAlignedBoundingBoxImpl;
import ballboy.model.entities.utilities.KinematicState;
import ballboy.model.entities.utilities.KinematicStateImpl;
import ballboy.model.entities.utilities.Vector2D;
import javafx.scene.image.Image;
import org.json.simple.JSONObject;

import java.util.Optional;

public class EnemyFactory implements EntityFactory {

    @Override
    public Entity createEntity(
            Level level,
            JSONObject config) {
        try {
            double startX = ((Number) config.get("startX")).doubleValue();
            double startY = ((Number) config.get("startY")).doubleValue();
            double startVelocityX = ((Number) config.get("startVelocityX")).doubleValue();
            String behaviour = (String) config.get("behaviour");

            Optional<Double> height = Optional.ofNullable(((Number) config.get("height"))).map(Number::doubleValue);

            String imageName = (String) config.getOrDefault("image", "slimePa.png");

            Vector2D startingPosition = new Vector2D(startX, startY);

            KinematicState kinematicState = new KinematicStateImpl.KinematicStateBuilder()
                    .setPosition(startingPosition)
                    .setHorizontalVelocity(startVelocityX)
                    .build();

            


            CollisionStrategy collisionStrategy = new EnemyCollisionStrategy(level);

            BehaviourStrategy behaviourStrategy;
            switch (behaviour) {
                case "scared":
                    imageName = "slimeBa.png";
                    behaviourStrategy = new ScaredEnemyBehaviourStrategy(level);
                    break;
                case "passive":
                    imageName = "slimeGa.png";
                    behaviourStrategy = new PassiveEntityBehaviourStrategy();
                    break;
                case "aggressive":
                    imageName = "slimeRa.png";
                    behaviourStrategy = new AggressiveEnemyBehaviourStrategy(level);
                    break;
                default:
                    throw new ConfigurationParseException(
                            String.format("%s is not a valid entity behaviour\n", behaviour));
            }
            Image image = new Image(imageName);
            AxisAlignedBoundingBox volume = new AxisAlignedBoundingBoxImpl(
                    startingPosition,
                    height.orElse(image.getHeight()),
                    height.map(h -> h * image.getWidth() / image.getHeight()).orElse(image.getWidth())
            );

            DynamicEntityImpl newEnemy = new DynamicEntityImpl(
                    kinematicState,
                    volume,
                    Entity.Layer.FOREGROUND,
                    image,
                    collisionStrategy,
                    behaviourStrategy
            );
            switch (behaviour) {
                case "scared":
                    newEnemy.setColour("blue");
                    break;
                case "passive":
                    newEnemy.setColour("green");
                    break;
                case "aggressive":
                    newEnemy.setColour("red");
                    break;
            }
            
            return newEnemy;

        } catch (Exception e) {
            throw new ConfigurationParseException(
                    String.format("Invalid cloud entity configuration | %s | %s", config, e));
        }
    }
}
