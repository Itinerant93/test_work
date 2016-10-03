package com.mygdx.game;

import com.badlogic.gdx.Gdx;

/**
 * Created by Cool_Prog on 03.10.2016.
 */

public class MySecondActor extends MyActor {

    public MySecondActor(String name_texture, int _duration, int x) {
        super(name_texture, _duration);
        super.actorX = x;
    }

    @Override
    public void act(float Delta) {
        super.act(Delta);
    }

    @Override
    public float parabola(float x) {
        return super.parabola(x);
    }
}
