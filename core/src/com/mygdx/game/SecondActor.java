package com.mygdx.game;

import com.badlogic.gdx.Gdx;

/**
 * Created by Cool_Prog on 03.10.2016.
 */

public class SecondActor extends CommonActor {

    public SecondActor(String name_texture, int _duration, int x) {
        super(name_texture, _duration);
        super.actorX = x;
        super.actorY = parabola(x);
        super.x0 = super.actorX;
        super.setBounds(super.actorX, super.actorY, super.texture.getWidth(), super.texture.getHeight());
    }

    public float getY (float x) {
        return parabola(x);
    }

    public float parabola (float x) {
        return (float) Math.pow((x - Gdx.graphics.getWidth()/2.0f + 128 / 2), 2) / (Gdx.graphics.getHeight() / 2.0f - 64) * (-1)
                + Gdx.graphics.getHeight() - 128 +30;
    }
}
