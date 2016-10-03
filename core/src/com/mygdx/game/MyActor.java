package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

/**
 * Created by Cool_Prog on 03.10.2016.
 */

public class MyActor extends Actor {

    private Texture texture; // = new Texture("square.png");
    public float actorX = 0, actorY = 0;
    private boolean started = false;
    private int duration = 0;

    public MyActor(String name_texture, int _duration) {

        texture = new Texture(name_texture);
        duration = _duration;
        setBounds(actorX, actorY, texture.getWidth(), texture.getHeight());
        addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                ((MyActor)event.getTarget()).started = true;
                return true;
            }
        });
    }

    public void setPosition (float x, float y) {
        actorX = x;
        actorY = y;
        setBounds(actorX, actorY, texture.getWidth(), texture.getHeight());
    }

    @Override
    public void draw(Batch batch, float alpha) {
        batch.draw(texture, actorX, actorY);
    }

    float x0 = actorX, deltaX = Math.abs(Gdx.graphics.getWidth() - 128), progress = 0;

    @Override
    public void act(float Delta) {
        
        if (started) {
            progress += Delta / duration;
            actorX = x0 + progress * deltaX;

            Gdx.app.log("MyTag", "Progress = " + progress + " deltaX = " + deltaX);

            if (progress >= 1f) {
                x0 = actorX;
                deltaX *= -1;
                progress = 0;
            }
        }
    }
}