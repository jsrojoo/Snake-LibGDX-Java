package Model.Entities.Snake;

import Model.Entities.Base.Part;
import Model.Entities.Base.Point;
import com.badlogic.gdx.graphics.Color;

/**
 * Created by rojo on 2/4/17.
 */
public class Body extends Part {

    private Color color;

    public Body(Point point, float size) {
        super(point, size);
        this.color = Color.BROWN;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

}
