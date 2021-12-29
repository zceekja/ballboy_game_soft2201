package ballboy.model.snapshot;

import javax.xml.XMLConstants;
import ballboy.model.entities.utilities.Vector2D;

public class Vector2DSnapshot implements SnapShot {
    private double x;
    private double y;
    private Vector2D vector;
    public Vector2DSnapshot(Vector2D vector, double x, double y ){
        this.vector = vector;
        this.x = x;
        this.y = y;
    }
    public void restore(){
        vector.load(x,y);

    }
}
