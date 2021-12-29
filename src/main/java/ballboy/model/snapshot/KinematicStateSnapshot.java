package ballboy.model.snapshot;

import ballboy.model.entities.utilities.KinematicState;
import ballboy.model.entities.utilities.Vector2D;


public class KinematicStateSnapshot implements SnapShot{
    private Vector2D position;
    private Vector2D previousPosition;
    private Vector2D velocity;
    private double horizontalAcceleration;
    private KinematicState k;
    
    public KinematicStateSnapshot(KinematicState k,
        Vector2D position, 
        Vector2D previousPosition,
        Vector2D velocity, 
        double horizontalAcceleration){
            this.k =k;
            this.position = position;
            this.previousPosition = previousPosition;
            this.velocity = velocity;
            this.horizontalAcceleration = horizontalAcceleration;
            position.backup();
            previousPosition.backup();
            velocity.backup();
            System.out.println("kinematic saved");
         }
    public void restore(){
        position.restore();
        previousPosition.restore();
        velocity.restore();
        k.load(position, previousPosition, velocity, horizontalAcceleration);
        System.out.println("kinematic restore");
    }
        

}
