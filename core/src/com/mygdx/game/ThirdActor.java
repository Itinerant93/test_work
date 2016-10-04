package com.mygdx.game;

import com.badlogic.gdx.Gdx;

import java.util.Random;

/**
 * Created by Cool_Prog on 04.10.2016.
 */

public class ThirdActor extends SecondActor {

    public ThirdActor(String name_texture, int _duration, int x) {
        super(name_texture, _duration, x);
        x1 = new Random().nextFloat();
        y1 = new Random().nextFloat();
    }

    float x0, x1, y0, y1;

    public  void someAction() {
        super.someAction();
        float temp_x0 = x0, temp_y0 = y0;
        temp_y0 = 2*(Gdx.graphics.getHeight() - y0);
    }
    public float geyY (float x) {
        x0 = super.actorX;
        y0 = super.actorY;
        return straight(x);
    }

    public float straight (float x) {
        return (x - x0)*(y1-y0)/(x1-x0) + y0;
    }
}
