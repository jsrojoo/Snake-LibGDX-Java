package Model.SnakeEntity;

import Model.Position;
import com.badlogic.gdx.graphics.Color;

/**
 * Created by rojo on 1/28/17.
 */
public abstract class Part {
    private final int defaultSize = 10;
    private Color color;
    private int size = defaultSize;
    private Position position;

    public Color getColor() {
        if (color != null)
            return color;
        else return Color.WHITE;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        if (!(size < defaultSize))
            this.size = size;
    }

    public Position getPosition() {
        if (position!= null)
        return position;
        else return new Position();
    }

    public void setPosition(int x, int y) {
        this.position.setX(x);
        this.position.setY(y);
    }


}
