package Model.Entities.Base;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by rojo on 2/4/17.
 */
public class Part {

    private Point point;
    private float size;
    private Color color;

    public Part(Point point, float size) {
        this.point = point;
        this.size = size;
        this.color = Color.DARK_GRAY;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Rectangle getBounds() {
        return new Rectangle(point.getX(), point.getY(), size, size);
    }

}
