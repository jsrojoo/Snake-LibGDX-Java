package Entities.Renderer;

import Entities.Base.Position;
import Entities.Snake.Snake;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Created by rojo on 2/4/17.
 */
public class Renderer {
    private ShapeRenderer renderer = new ShapeRenderer();
    private Camera camera = new OrthographicCamera();

    public Renderer() {
        renderer.setProjectionMatrix(camera.combined);
        renderer.begin(ShapeRenderer.ShapeType.Filled);
    }
}
