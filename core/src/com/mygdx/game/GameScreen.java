package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by Cool_Prog on 28.09.2016.
 */

public class GameScreen implements Screen {

    MyGdxGame myGdxGame;
    OrthographicCamera camera;
    Texture squareTexture;
    Rectangle squareRectangle;
    Boolean flag;

    public GameScreen(final MyGdxGame myGdxGame) {

        this.myGdxGame = myGdxGame;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);

        squareTexture = new Texture("square.png");
        squareRectangle = new Rectangle();
        squareRectangle.x = 800 / 2 - 128 / 2;
        squareRectangle.y = 0;
        squareRectangle.width = 128;
        squareRectangle.height = 128;

        flag = false;
    }

    @Override
    public void show() {

    }


    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0.3f, 0.3f, 0, 0.8f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();

        myGdxGame.batch.setProjectionMatrix(camera.combined);
        myGdxGame.batch.begin();


        myGdxGame.font.draw(myGdxGame.batch, squareRectangle.x + "", 100, 200);
        myGdxGame.font.draw(myGdxGame.batch, squareRectangle.y + "", 100, 170);
        myGdxGame.font.draw(myGdxGame.batch, "Coordinates:", 100, 230);
        myGdxGame.batch.draw(squareTexture, squareRectangle.x, squareRectangle.y);

        myGdxGame.batch.end();

        /*if (Gdx.input.isTouched()) {
            myGdxGame.setScreen(new MainScreen(myGdxGame));
            dispose();
        }*/

        if (squareRectangle.y < 300 && !flag) {
            squareRectangle.y += 200 * Gdx.graphics.getDeltaTime();
        }
        else if (squareRectangle.y > 300 && flag) {
            squareRectangle.y -= 200 * Gdx.graphics.getDeltaTime();
        }

        if (squareRectangle.y >= 300)
            flag = true;
        else if (squareRectangle.y <= 128)
            flag = false;
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
        squareTexture.dispose();
    }
}
