package Entities.Base;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by rojo on 2/4/17.
 */
public class BodyPart {

    private Position position;
    private float size;
    private Color color;

    public BodyPart(float size) {
        this.size = size;
        this.color = Color.DARK_GRAY;
    }

    public Position getPosition() {
        if (position == null) position = new Position(0, 0);
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
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
        return new Rectangle(position.getX(), position.getY(), size, size);
    }

}
