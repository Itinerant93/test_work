package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;

import javafx.scene.text.Font;

/**
 * Created by Cool_Prog on 28.09.2016.
 */

public class MainScreen implements Screen {

    MyGdxGame myGdxGame;
    //OrthographicCamera camera;

    SpriteBatch batch;
    Sprite sprite;

    private Stage stage;
    private Skin skin;
    private Table table;
    private TextButton startButton;
    private TextButton settingsButton;
    private TextButton quitButton;


    public MainScreen (final MyGdxGame myGdxGame) {

        this.myGdxGame = myGdxGame;
        //camera = new OrthographicCamera();
        //camera.setToOrtho(false, 800, 480);

        //skin = new Skin(Gdx.files.internal("uiskin.json"));

        stage = new Stage();
        table = new Table();
        table.setWidth(stage.getWidth());
        table.align(Align.center|Align.top);
        table.setPosition(0, Gdx.graphics.getHeight());

        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = new com.badlogic.gdx.graphics.g2d.BitmapFont();

        startButton = new TextButton("Start", textButtonStyle);
        settingsButton = new TextButton("Settings", textButtonStyle);
        quitButton = new TextButton("Quit", textButtonStyle);

        startButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                myGdxGame.setScreen(new GameScreen(myGdxGame));
                dispose();

            }
        });

        table.padTop(30);
        table.add(startButton).padBottom(20);
        table.row();
        table.add(settingsButton).padBottom(20);
        table.row();
        table.add(quitButton);

        stage.addActor(table);

        batch = new SpriteBatch();
        sprite = new Sprite(new Texture(Gdx.files.internal("badlogic.jpg")));
        sprite.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0.3f, 0, 0.8f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        sprite.draw(batch);
        batch.end();

        stage.act(Gdx.graphics.getDeltaTime());
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

        batch.dispose();
        stage.dispose();
    }
}
