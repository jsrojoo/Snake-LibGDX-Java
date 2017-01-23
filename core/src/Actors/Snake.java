package Actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Created by rojo on 1/22/17.
 */
public class Snake {
    private ShapeRenderer shapeRenderer;
    private int x = 0, y = 0;
    private int width = 50, height = 50;

    public Snake() {
        shapeRenderer = new ShapeRenderer();
    }

    public void draw(Camera c) {
        shapeRenderer.setProjectionMatrix(c.combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(1, 1, 0, 1);
        shapeRenderer.rect(x, y, width, height);
        shapeRenderer.end();
    }

    public void checkMovement(int width, int height) {

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            if (x > 0)
                x -= 10;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            if (x < width - this.width)
                x += 10;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            if (y > 0)
                y -= 10;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            if (y < height - this.height)
                y += 10;
        }

    }

}
