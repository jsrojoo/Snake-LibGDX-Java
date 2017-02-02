package rojo.snake;

import Model.SnakeEntityV2.Point;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.ArrayList;

public class SnakeGame extends ApplicationAdapter {

    private OrthographicCamera orthographicCamera;
    private ShapeRenderer shapeRenderer;
    private float windowWidth;
    private float windowHeight;

    private final float DEFAULT_SIZE = 20;
    private float size = DEFAULT_SIZE;

    private float x;
    private float y;

    private float speed = 20f;
    private int length = 11;
    private ArrayList<Point> points;

    private float frames = 20f;

    @Override
    public void create() {

        Gdx.graphics.setTitle("Bitin");
        orthographicCamera = new OrthographicCamera();
        windowWidth = Gdx.graphics.getWidth();
        windowHeight = Gdx.graphics.getHeight();
        shapeRenderer = new ShapeRenderer();
        orthographicCamera.setToOrtho(true, windowWidth, windowHeight);

        x = windowWidth / 2;
        y = windowHeight / 2;

        points = new ArrayList<Point>();

        for (int i = 0; i < length; i++) {
            points.add(new Point(x, (y) + i * size));
        }
    }

    @Override
    public void render() {
        float dt = Math.min(Gdx.graphics.getDeltaTime(), 1 / frames);

        clearScreen();
        speedSetter();
        fpsSetter(dt);

        Point head = points.get(0);
        float oldX = head.getX();
        float oldY = head.getY();
        float newPos = speed * dt;

        moveSnake(head, newPos);

        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            Point tail = points.remove(points.size() - 1);
            tail.setX(oldX);
            tail.setY(oldY);
            points.add(1, tail);
        }


        renderSnake();
        orthographicCamera.update();

    }

    private void clearScreen() {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
    }

    private void fpsSetter(float dt) {
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            frames += 1;
            System.out.println("Frames : " + frames);
            System.out.println("Delta : " + dt);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            frames -= 1;
            System.out.println("Frames : " + frames);
            System.out.println("Delta : " + dt);
        }
    }

    private void speedSetter() {
        if (Gdx.input.isKeyPressed(Input.Keys.Z)) {
            speed += 1f;
            System.out.println(speed);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.X)) {
            speed -= 1f;
            System.out.println(speed);
        }
    }

    private void moveSnake(Point head, float newPos) {
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            head.setX(head.getX() + newPos);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            head.setX(head.getX() - newPos);

        }

        if (Gdx.input.isKeyPressed(Input.Keys.UP)) head.setY(head.getY() - newPos);

        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) head.setY(head.getY() + newPos);
    }

    private void renderSnake() {
        shapeRenderer.setProjectionMatrix(orthographicCamera.combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        for (Point point : points) {

            int index = points.indexOf(point);

            if (index == 0) shapeRenderer.setColor(Color.OLIVE);
            else if (index % 2 == 0) shapeRenderer.setColor(Color.BROWN);
            else shapeRenderer.setColor(Color.GRAY);

            shapeRenderer.rect(point.getX(), point.getY(), size, size);

        }

        shapeRenderer.end();
    }

    @Override
    public void dispose() {

    }
}
