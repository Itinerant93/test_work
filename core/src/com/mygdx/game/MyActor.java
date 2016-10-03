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
    public float actorX, actorY;
    private boolean started = false;
    private int duration;

    public MyActor(String name_texture, int _duration) {

        texture = new Texture(name_texture);
        duration = _duration;
        actorX = 0;
        actorY = parabola(actorX);
        setBounds(actorX, actorY, texture.getWidth(), texture.getHeight());
        addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                ((MyActor)event.getTarget()).started = true;
                return true;
            }
        });
    }

    public void setPosition (float x) {
        actorX = x;
        actorY = parabola(actorX);
        setBounds(actorX, actorY, texture.getWidth(), texture.getHeight());
        x0 = actorX;
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
            actorY = getY(actorX);

            if (progress >= 1f || actorX >=Math.abs(Gdx.graphics.getWidth() - 128 + 1)) {
                x0 = actorX;
                deltaX *= -1;
                progress = 0;
            }
        }
    }

    private float getY(float x) {
        return parabola(x);
    }

    public float parabola (float x) {
        return (float) Math.pow((x - Gdx.graphics.getWidth()/2.0f + 128 / 2), 2) / (Gdx.graphics.getHeight() / 2.0f - 64) * (-1)
                + Gdx.graphics.getHeight() - 128 +30;
    }
}