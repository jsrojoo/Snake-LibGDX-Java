package Model.SnakeEntityV2;

/**
 * Created by rojo on 2/1/17.
 */
public class Part {
    private Point point;
    private final float DEFAULT_SIZE = 10;
    private float size = DEFAULT_SIZE;

    public Part(Point point) {
        this.point = point;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        if (size > DEFAULT_SIZE)
            this.size = size;
    }
}
