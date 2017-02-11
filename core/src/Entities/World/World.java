package Entities.World;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Matrix4;

/**
 * Created by rojo on 2/4/17.
 */
public class World {

    private OrthographicCamera camera;
    private float width;
    private float height;

    public World(float width, float height) {
        this.width = width;
        this.height = height;
        this.camera = new OrthographicCamera();
        this.camera.setToOrtho(true, width, height);

    }

    public void update() {
        camera.update();
    }

    public Matrix4 getMatrix() {
        return camera.combined;
    }
}
