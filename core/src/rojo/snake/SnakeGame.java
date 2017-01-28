package rojo.snake;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class SnakeGame extends ApplicationAdapter {

    private OrthographicCamera orthographicCamera;
//    private SnakeHead head;

    @Override
    public void create() {

        Gdx.graphics.setTitle("Bitin");

        orthographicCamera = new OrthographicCamera();
//        head = new SnakeHead(10);
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();


        orthographicCamera.setToOrtho(true, w, h);

    }

    @Override
    public void render() {

        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

//        SnakeController.control(head);
//        head.draw(orthographicCamera);

        orthographicCamera.update();
    }

    @Override
    public void dispose() {

    }
}
