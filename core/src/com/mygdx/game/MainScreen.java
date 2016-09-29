package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

/**
 * Created by Cool_Prog on 28.09.2016.
 */

public class MainScreen implements Screen {

    MyGdxGame myGdxGame;
    OrthographicCamera camera;

    public MainScreen (final MyGdxGame myGdxGame) {

        this.myGdxGame = myGdxGame;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0.3f, 0, 0.8f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();

        myGdxGame.batch.setProjectionMatrix(camera.combined);
        myGdxGame.batch.begin();
        myGdxGame.batch.draw(myGdxGame.img, 480, 100);
        myGdxGame.font.draw(myGdxGame.batch, "Catch all drops", 100, 150);
        myGdxGame.font.draw(myGdxGame.batch, "Touch screen for begining!", 100, 100);
        myGdxGame.batch.end();

        if (Gdx.input.isTouched()) {
            myGdxGame.setScreen(new GameScreen(myGdxGame));
            dispose();
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

        /*myGdxGame.font.dispose();
        myGdxGame.img.dispose();
        myGdxGame.batch.dispose();*/
    }
}
