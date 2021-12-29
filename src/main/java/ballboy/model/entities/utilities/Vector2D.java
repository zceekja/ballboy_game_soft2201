package ballboy.model.entities.utilities;

import ballboy.model.snapshot.Vector2DSnapshot;

/**
 * Utility object for 2D coordinates.
 * <p>
 * All state is immutable.
 */
public class Vector2D {
    public static final Vector2D ZERO = new Vector2D(0, 0);

    private  double x;
    private  double y;
    private Vector2DSnapshot save;

    public Vector2D(
            double x,
            double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return this.x;
    }

    public Vector2D setX(double x) {
        return new Vector2D(x, this.y);
    }

    public double getY() {
        return this.y;
    }

    public Vector2D setY(double y) {
        return new Vector2D(this.x, y);
    }

    public Vector2D reflectY() {
        return new Vector2D(this.x, -this.y);
    }

    public Vector2D reflectX() {
        return new Vector2D(-this.x, this.y);
    }

    public Vector2D add(Vector2D v) {
        return new Vector2D(this.x + v.getX(), this.y + v.getY());
    }

    public Vector2D addX(double x) {
        return new Vector2D(this.x + x, this.y);
    }

    public Vector2D addY(double y) {
        return new Vector2D(this.x, this.y + y);
    }

    public Vector2D scale(double scale) {
        return new Vector2D(this.x * scale, this.y * scale);
    }

    public boolean isLeftOf(double x) {
        return this.x < x;
    }

    public boolean isRightOf(double x) {
        return this.x > x;
    }

    public boolean isAbove(double y) {
        return this.y < y;
    }

    public boolean isBelow(double y) {
        return this.y > y;
    }
    public void restore(){
        save.restore();
    }
    public void backup(){
        save = new Vector2DSnapshot(this,x,y);
    }
    public void load(double x, double y){
        this.x = x;
        this.y = y;
    }
}
