package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * Created by Cool_Prog on 28.09.2016.
 */

public class GameScreen implements Screen {

    MyGdxGame myGdxGame;
    private Stage stage;

    public GameScreen(final MyGdxGame myGdxGame) {

        this.myGdxGame = myGdxGame;
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        FirstActor firstActor = new FirstActor("yellow_bird.png", 3, 0);
        //myActor1.setPosition(Gdx.graphics.getWidth() - 128);
        SecondActor secondActor = new SecondActor("blue_bird.png", 4, Gdx.graphics.getWidth() - 128);
        //myActor1.setTouchable(Touchable.enabled);
        stage.addActor(firstActor);
        stage.addActor(secondActor);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0.3f, 0.3f, 0, 0.8f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act();
        stage.draw();
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
        stage.dispose();
    }
}
