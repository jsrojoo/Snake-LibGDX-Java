package rojo.snake.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

/**
 * Created by rojo on 2/11/17.
 */
public class InputHandler {

    private Input input;

    public InputHandler() {
        input = Gdx.input;
    }

    public void handle() {
        exitApp();
    }

    private void exitApp() {
        if (escapeIsPressed()) {
            Gdx.app.exit();
        }
    }

    private boolean escapeIsPressed() {
        return input.isKeyPressed(Input.Keys.ESCAPE);
    }
}
