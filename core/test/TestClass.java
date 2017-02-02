import Model.Position;
import Model.SnakeEntity.Part;
import Model.SnakeEntity.Snake;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by rojo on 1/22/17.
 */
public class TestClass {
    Snake s = new Snake();

    @Test
    public void draw() {
        Position old;
        int speed = 10;
        ArrayList<Part> parts = s.getParts();
        for (Part part : parts) {
            old = part.getPosition();

            System.out.println(part.getPosition());
        }

    }

}
