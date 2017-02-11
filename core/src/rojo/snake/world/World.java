package rojo.snake.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import rojo.snake.model.Dimension;

/**
 * Created by rojo on 2/11/17.
 */
public class World {
    private OrthographicCamera orthographicCamera;
    private Dimension dimension;
    private Viewport viewport;


    public void init() {
        Gdx.graphics.setTitle("Bitin");

        dimension = new Dimension(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        orthographicCamera = new OrthographicCamera();
        orthographicCamera.setToOrtho(false, dimension.getWidth(), dimension.getHeight());
        viewport = new FitViewport(dimension.getWidth(), dimension.getHeight(), orthographicCamera);
    }

    public OrthographicCamera getOrthographicCamera() {
        return orthographicCamera;
    }

    public Viewport getViewport() {
        return viewport;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public void update() {
        orthographicCamera.update();
    }

    public void clear() {
        Gdx.gl.glClearColor(0.09f, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
    }
}
