package Model.SnakeEntityV1;

import Model.Direction;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.ArrayList;

/**
 * Created by rojo on 1/29/17.
 */
public class Snake {
    private Head head;
    private ArrayList<Body> body;
    public long speed = 1;
    private int size = 5;
    private ShapeRenderer shapeRenderer;
    private int direction = -1;

    public Snake(int speed) {
        this.speed = speed;
        this.head = new Head();
        this.body = new ArrayList<Body>();
        this.shapeRenderer = new ShapeRenderer();
    }

    public void eat() {
        Body newBody = new Body();
        body.add(0, newBody);
    }

    public void move(long speed) {
        Input input = Gdx.input;
        boolean right = input.isKeyPressed(Input.Keys.RIGHT);
        boolean left = input.isKeyPressed(Input.Keys.LEFT);
        boolean up = input.isKeyPressed(Input.Keys.UP);
        boolean down = input.isKeyPressed(Input.Keys.DOWN);

        if (right) {
            direction = Direction.RIGHT;
        }
        if (left) {
            direction = Direction.LEFT;
        }
        if (up)
            direction = Direction.UP;
        if (down)
            direction = Direction.DOWN;

        switch (direction) {
            case Direction.RIGHT:
                head.x += size;
                return;
            case Direction.LEFT:
                head.x -= size;
                return;
            case Direction.UP:
                head.y -= size;
                return;
            case Direction.DOWN:
                head.y += size;
                return;
        }
    }

    public void draw(Camera camera) {
        int oldHeadX = head.x;
        int oldHeadY = head.y;

        move(speed);

        shapeRenderer.setProjectionMatrix(camera.combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(head.color);
        shapeRenderer.rect(head.x, head.y, size, size);
        shapeRenderer.end();

        for (Body part : body) {
            if (body.indexOf(part) == 0) {
                part.x = oldHeadX;
                part.y = oldHeadY;
                shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
                shapeRenderer.setColor(part.color);
                shapeRenderer.rect(part.x, part.y, size, size);
                shapeRenderer.end();
            } else {
                Body prev = body.get(body.indexOf(part) - 1);
                shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
                shapeRenderer.setColor(part.color);
                shapeRenderer.rect(prev.x, prev.y, size, size);
                shapeRenderer.end();
                part.x = prev.x;
                part.y = prev.y;
            }
        }

    }

    private class Head {
        int x, y;
        Color color = Color.BROWN;

    }

    private class Body {
        int x, y;
        Color color = Color.GRAY;

    }
}
