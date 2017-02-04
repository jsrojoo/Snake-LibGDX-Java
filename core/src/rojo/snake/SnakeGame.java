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
import java.util.Random;

public class SnakeGame extends ApplicationAdapter {

    private OrthographicCamera orthographicCamera;
    private ShapeRenderer shapeRenderer;

    private final float DEFAULT_SIZE = 20;
    private float size = DEFAULT_SIZE;

    private float speed = 100f;
    private ArrayList<Point> points;

    private float frames = 20f;

    private Apple apple;
    private float r = 0;
    private float g = 0;
    private float b = 0;

    private float windowWidth;
    private float windowHeight;


    @Override
    public void create() {

        Gdx.graphics.setTitle("Bitin");
        orthographicCamera = new OrthographicCamera();
        shapeRenderer = new ShapeRenderer();

        windowWidth = Gdx.graphics.getWidth();
        windowHeight = Gdx.graphics.getHeight();

        orthographicCamera.setToOrtho(true, windowWidth, windowHeight);

        float windowCenterX = windowWidth / 2;
        float windowCenterY = windowHeight / 2;

        points = new ArrayList<Point>();

        int length = 50;
        for (int i = 0; i < length; i++) {
            points.add(new Point(windowCenterX, (windowCenterY) + i * size));
        }

        apple = new Apple();


    }

    @Override
    public void render() {
        float dt = Math.min(Gdx.graphics.getDeltaTime(), 1 / frames);

        clearScreen();
        speedSetter();
        fpsSetter(dt);

        Point head = points.get(0);
        float newPos = speed * dt;

        moveSnake(head, newPos);

        renderGameObjects(head);
        orthographicCamera.update();

    }

    private void moveBody(float oldX, float oldY) {
        Point tail = points.remove(points.size() - 1);
        tail.setX(oldX);
        tail.setY(oldY);
        points.add(1, tail);
    }

    private void clearScreen() {

        if (r < 0.5) {
//            r += 0.001;
            g += 0.001;
//            b += 0.001;
        }

        Gdx.gl.glClearColor(r, g, b, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
    }

    private void fpsSetter(float dt) {
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            frames += 1;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            if (frames > 10)
                frames -= 1;
        }
    }

    private void speedSetter() {
        if (Gdx.input.isKeyPressed(Input.Keys.Z)) {
            speed += 1f;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.X)) {
            speed -= 1f;
        }
    }

    private void moveSnake(Point head, float newPos) {
        float oldX = head.getX();
        float oldY = head.getY();

        checkKeyPressThenMove(head, newPos);
        moveBody(oldX, oldY);
    }

    private void checkKeyPressThenMove(Point head, float newPos) {
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            head.setX(head.getX() + newPos);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            head.setX(head.getX() - newPos);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.UP)) head.setY(head.getY() - newPos);

        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) head.setY(head.getY() + newPos);
    }

    private void renderGameObjects(Point head) {
        shapeRenderer.setProjectionMatrix(orthographicCamera.combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        drawSnake();
        drawApple(head);

        shapeRenderer.end();
    }

    private void drawApple(Point head) {
        if (apple != null) {
            apple.draw();
            apple.checkCollision(head);
        }
    }

    private void drawSnake() {
        for (Point point : points) {

            int index = points.indexOf(point);

            if (index == 0) shapeRenderer.setColor(Color.OLIVE);
            else if (index % 2 == 0) shapeRenderer.setColor(Color.BROWN);
            else shapeRenderer.setColor(Color.GRAY);

            shapeRenderer.rect(point.getX(), point.getY(), size, size);

        }
    }

    @Override
    public void dispose() {

    }

    private class Apple {
        private Random rand = new Random();
        private float randomFloatX = getRandomFloat();
        private float randomFloatY = getRandomFloat();

        private float getRandomFloat() {
            return rand.nextFloat() * (rand.nextInt((int) windowHeight) - (int) windowHeight) + windowHeight;
        }

        private void draw() {
            if (Gdx.input.isKeyPressed(Input.Keys.R)) {
                randomFloatX += 1;
            }
            shapeRenderer.setColor(0.863f, 0.078f, 0.235f, 0);
            shapeRenderer.rect(randomFloatX,
                    randomFloatY, size, size);
        }

        public void checkCollision(Point head) {
            int headX = (int) Math.abs(head.getX());
            int appleX = (int) Math.abs(randomFloatX);
            int headY = (int) Math.abs(head.getY());
            int appleY = (int) Math.abs(randomFloatY);


            if (appleX < headX + size && appleX + size > headX &&
                    appleY < headY + size && appleY + size > headY) {
                randomFloatX = getRandomFloat();
                randomFloatY = getRandomFloat();
            }
        }


    }
}
