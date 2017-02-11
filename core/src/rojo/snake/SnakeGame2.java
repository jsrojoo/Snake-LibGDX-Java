package rojo.snake;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

/**
 * Created by rojo on 2/4/17.
 */
public class SnakeGame2 extends ApplicationAdapter {

    private OrthographicCamera orthographicCamera;
    private float windowWidth;
    private float windowHeight;

    @Override
    public void create() {

        Gdx.graphics.setTitle("Bitin");

        windowWidth = Gdx.graphics.getWidth();
        windowHeight = Gdx.graphics.getHeight();

        orthographicCamera = new OrthographicCamera();
        orthographicCamera.setToOrtho(false, windowWidth, windowHeight);

    }

    @Override
    public void render() {

        orthographicCamera.update();
    }

    @Override
    public void dispose() {

    }

}
