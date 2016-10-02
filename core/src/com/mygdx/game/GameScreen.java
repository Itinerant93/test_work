package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

/**
 * Created by Cool_Prog on 28.09.2016.
 */

public class GameScreen implements Screen {

    MyGdxGame myGdxGame;
    private Stage stage;

    public class MyActor extends Actor {

        Texture texture = new Texture("square.png");
        float actorX = 0, actorY = 0;
        public boolean started = false;

        public MyActor() {
            setBounds(actorX, actorY, texture.getWidth(), texture.getHeight());
            addListener(new InputListener() {
                public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                    ((MyActor)event.getTarget()).started = true;
                    return true;
                }
            });
        }

        @Override
        public void draw(Batch batch, float alpha) {
            batch.draw(texture, actorX, actorY);
        }

        @Override
        public void act(float Delta) {
            if (started) {
                actorX += 5;
                actorY +=5;
            }
        }
    }

    public GameScreen(final MyGdxGame myGdxGame) {

        this.myGdxGame = myGdxGame;
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        MyActor myActor = new MyActor();
        myActor.setTouchable(Touchable.enabled);
        stage.addActor(myActor);
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
    }
}
