package rojo.snake;

import com.badlogic.gdx.ApplicationAdapter;
import rojo.snake.controller.InputHandler;
import rojo.snake.model.Shapes;
import rojo.snake.world.World;

/**
 * Created by rojo on 2/4/17.
 */
public class SnakeGameV1 extends ApplicationAdapter {


    private World world;
    private Shapes shapes;
    private InputHandler inputHandler;

    @Override
    public void create() {
        world = new World();
        shapes = new Shapes();
        inputHandler = new InputHandler();

        world.init();
        shapes.init();
    }

    @Override
    public void render() {
        world.clear();
        inputHandler.handle();
        shapes.draw(world);
        world.update();
    }

    @Override
    public void dispose() {

    }

    @Override
    public void resize(int width, int height) {
        world.getViewport().update(width, height);
    }

}
