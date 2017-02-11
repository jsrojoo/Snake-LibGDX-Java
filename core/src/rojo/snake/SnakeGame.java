package rojo.snake;

import Entities.Base.Position;
import Entities.World.World;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.ArrayList;
import java.util.Random;

public class SnakeGame extends ApplicationAdapter {

    private World world;
    private ShapeRenderer shapeRenderer;
    private SpriteBatch batch;
    private BitmapFont font;

    private final float DEFAULT_SIZE = 20;
    private float size = DEFAULT_SIZE;

    private float speed = 100f;
    private ArrayList<Position> positions;

    private float frames = 20f;

    private Apple apple;
    private float r = 0;
    private float g = 0;
    private float b = 0;

    private float windowWidth;
    private float windowHeight;

    private int score;


    @Override
    public void create() {

        Gdx.graphics.setTitle("Bitin");
        shapeRenderer = new ShapeRenderer();
        batch = new SpriteBatch();
        font = new BitmapFont();

        windowWidth = Gdx.graphics.getWidth();
        windowHeight = Gdx.graphics.getHeight();

        world = new World(windowWidth, windowHeight);

        float windowCenterX = windowWidth / 2;
        float windowCenterY = windowHeight / 2;

        positions = new ArrayList<Position>();

        int length = 50;
        for (int i = 0; i < length; i++) {
            positions.add(new Position(windowCenterX, (windowCenterY) + i * size));
        }

        apple = new Apple();


    }

    @Override
    public void render() {
        float dt = Math.min(Gdx.graphics.getDeltaTime(), 1 / frames);
        clearScreen();

        batch.begin();
        font.draw(batch, "Score : " + score, 0, 12);
        batch.end();

        speedSetter();
        fpsSetter(dt);

        Position head = positions.get(0);
        float newPos = speed * dt;

        moveSnake(head, newPos);

        renderGameObjects(head);


        world.update();

    }

    private void moveBody(float oldX, float oldY) {
        Position tail = positions.remove(positions.size() - 1);
        tail.setX(oldX);
        tail.setY(oldY);
        positions.add(1, tail);
    }

    private void clearScreen() {

        if (r < .6 && g < 0.63 && b < 0.65) {
            r += 0.001;
            g += 0.001;
            b += 0.001;
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

    private void moveSnake(Position head, float newPos) {
        float oldX = head.getX();
        float oldY = head.getY();

        checkKeyPressThenMove(head, newPos);
        moveBody(oldX, oldY);
    }

    private void checkKeyPressThenMove(Position head, float newPos) {
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            if (head.getX() < windowWidth - size) head.setX(head.getX() + newPos);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            if (head.getX() > 0) head.setX(head.getX() - newPos);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            if (head.getY() > 0) head.setY(head.getY() - newPos);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.DOWN))
            if (head.getY() < windowHeight - size) head.setY(head.getY() + newPos);
    }

    private void renderGameObjects(Position head) {
        shapeRenderer.setProjectionMatrix(world.getMatrix());
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        drawSnake();
        drawApple(head);

        shapeRenderer.end();
    }

    private void drawApple(Position head) {
        if (apple != null) {
            apple.draw();
            apple.checkCollision(head);
        }
    }

    private void drawSnake() {
        for (Position position : positions) {

            int index = positions.indexOf(position);

            if (index == 0) shapeRenderer.setColor(Color.OLIVE);
            else if (index % 2 == 0) shapeRenderer.setColor(Color.BROWN);
            else shapeRenderer.setColor(Color.GRAY);

            shapeRenderer.rect(position.getX(), position.getY(), size, size);

        }
    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
        shapeRenderer.dispose();
    }

    private class Apple {
        private Random rand = new Random();
        private float randomFloatX = getRandomFloat();
        private float randomFloatY = getRandomFloat();

        private float getRandomFloat() {
            return rand.nextFloat() * (rand.nextInt((int) windowHeight) - (int) windowHeight) + windowHeight - size;
        }

        private void draw() {
            if (Gdx.input.isKeyPressed(Input.Keys.R)) {
                randomFloatX += 1;
            }
            shapeRenderer.setColor(0.863f, 0.078f, 0.235f, 0);
            shapeRenderer.rect(randomFloatX,
                    randomFloatY, size, size);
        }

        public void checkCollision(Position head) {
            int headX = (int) Math.abs(head.getX());
            int appleX = (int) Math.abs(randomFloatX);
            int headY = (int) Math.abs(head.getY());
            int appleY = (int) Math.abs(randomFloatY);


            if (appleX < headX + size && appleX + size > headX &&
                    appleY < headY + size && appleY + size > headY) {
                randomFloatX = getRandomFloat();
                randomFloatY = getRandomFloat();
                score = score + 1;
            }
        }


    }
}
