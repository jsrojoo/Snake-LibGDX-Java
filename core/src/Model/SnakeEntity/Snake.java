package Model.SnakeEntity;


import Model.Direction;
import Model.Interfaces.Drawable;
import Model.Interfaces.Hunger;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.ArrayList;

/**
 * Created by rojo on 1/28/17.
 */
public class Snake implements Drawable, Hunger {

    private int speed = 10;
    private int direction = -1;
    private ArrayList<Part> parts;

    public Snake() {
        this.parts = new ArrayList<Part>();
        parts.add(new Head());
        parts.add(new Body());
    }

    @Override
    public void draw(Camera camera) {
        ShapeRenderer shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(camera.combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        Part head = parts.remove(0);
        checkKeyPress();

        for (Part part : parts) {
            moveSnake(part);
            shapeRenderer.setColor(part.getColor());
            shapeRenderer.rect(part.getPosition().getX(), part.getPosition().getY() + part.getSize(), part.getSize(), part.getSize());
        }
        parts.add(head);
        shapeRenderer.end();
    }

    @Override
    public void eat() {
        parts.add(new Body());
    }

    private void checkKeyPress() {
        boolean lPressed = Gdx.input.isKeyPressed(Input.Keys.LEFT);
        boolean rPressed = Gdx.input.isKeyPressed(Input.Keys.RIGHT);
        boolean uPressed = Gdx.input.isKeyPressed(Input.Keys.UP);
        boolean dPressed = Gdx.input.isKeyPressed(Input.Keys.DOWN);

        if (lPressed) direction = Direction.LEFT;
        if (rPressed) direction = Direction.RIGHT;
        if (uPressed) direction = Direction.UP;
        if (dPressed) direction = Direction.DOWN;
    }

    private void moveSnake(Part part) {
        int oldX = part.getPosition().getX();
        int oldY = part.getPosition().getY();

        switch (direction) {
            case Direction.RIGHT:
                part.setPosition(oldX + speed, oldY);
                return;
            case Direction.LEFT:
                part.setPosition(oldX - speed, oldY);
                return;
            case Direction.UP:
                part.setPosition(oldX, oldY - speed);
                return;
            case Direction.DOWN:
                part.setPosition(oldX, oldY + speed);
                return;
        }

    }
//    private void renderHead(ShapeRenderer shapeRenderer, Part part) {
//        renderSnakePart(shapeRenderer, part);
//    }
//
//    private void renderBody(ShapeRenderer shapeRenderer, Part part) {
//        Point p = new Point(0, part.getSize() * parts.indexOf(part));
//        part.setPosition(p);
//        renderHead(shapeRenderer, part);
//    }
//
//    private void renderSnakePartsUsing(ShapeRenderer shapeRenderer) {
//
//        Part p = parts.remove(0);
//        moveSnake(p);
//
//        for (Part part : parts) {
//            shapeRenderer.setColor(part.getColor());
//            if (isHead(part)) {
//                renderBody(shapeRenderer, part);
//            } else {
//                renderHead(shapeRenderer, part);
//            }
//        }
//        parts.add(p);
//    }

//    private boolean isHead(Part part) {
//        return !(part.getColor() == Color.BROWN);
//    }
//
//    private void renderSnakePart(ShapeRenderer shapeRenderer, Part part) {
//        shapeRenderer.rect(part.getPosition().getX(), part.getPosition().getY(), part.getSize(), part.getSize());
//    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public ArrayList<Part> getParts() {
        return parts;
    }
}
