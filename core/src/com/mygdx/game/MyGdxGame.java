package com.mygdx.game;

import Actors.Snake;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class MyGdxGame extends ApplicationAdapter {

    private OrthographicCamera orthographicCamera;
    private Snake s;

    @Override
    public void create() {

        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();

        s = new Snake();
        orthographicCamera = new OrthographicCamera();
        orthographicCamera.setToOrtho(true, w, h);
    }

    @Override
    public void render() {

        orthographicCamera.update();
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        s.checkMovement(Gdx.graphics.getWidth(),
                Gdx.graphics.getHeight());
        s.draw(orthographicCamera);

    }

    @Override
    public void dispose() {

    }
}
