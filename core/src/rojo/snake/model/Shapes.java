package rojo.snake.model;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import rojo.snake.world.World;

/**
 * Created by rojo on 2/11/17.
 */
public class Shapes {
    private ShapeRenderer shapeRenderer;
    private float radius;
    private float spaceBetween;

    public void init() {
        shapeRenderer = new ShapeRenderer();
        radius = 10f;
        spaceBetween = 5f;
    }

    public void draw(World world) {
        shapeRenderer.setProjectionMatrix(world.getOrthographicCamera().combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        shapeRenderer.setColor(Color.BLUE);
        shapeRenderer.circle(centerWidth(world) + spaceBetween * 2, centerHeight(world), radius);
        shapeRenderer.setColor(Color.GREEN);
        shapeRenderer.circle(centerWidth(world) + spaceBetween * 1, centerHeight(world), radius);
        shapeRenderer.setColor(Color.RED);
        shapeRenderer.circle(centerWidth(world) + spaceBetween * 0, centerHeight(world), radius);

        shapeRenderer.end();
    }

    private float centerHeight(World world) {
        return world.getDimension().getHeight() / 2;
    }

    private float centerWidth(World world) {
        return world.getDimension().getWidth() / 2;
    }
}

