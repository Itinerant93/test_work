package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

/**
 * Created by Cool_Prog on 03.10.2016.
 */

public class CommonActor extends Actor {

    protected Texture texture;
    public float actorX = 0, actorY = 0;
    private boolean started = false;
    private int duration;

    public CommonActor(String name_texture, int _duration) {

        texture = new Texture(name_texture);
        duration = _duration;
        setBounds(actorX, actorY, texture.getWidth(), texture.getHeight());
        addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                ((CommonActor)event.getTarget()).started = true;
                return true;
            }
        });

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
                someAction();
            }
        }
    }

    public void someAction () {
        x0 = actorX;
        deltaX *= -1;
        progress = 0;
    }

    public float getY(float x) {
        return actorY;
    }
}