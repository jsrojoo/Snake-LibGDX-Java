package Model.Entities.Snake;

import Model.Entities.Base.Part;
import Model.Entities.Base.Point;
import com.badlogic.gdx.graphics.Color;

/**
 * Created by rojo on 2/4/17.
 */
public class Head extends Part {

    private Color color;

    public Head(Point point, float size) {
        super(point, size);
        this.color = Color.CHARTREUSE;
    }


    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }


}
