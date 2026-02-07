package com.centipede.game.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.centipede.game.graphics.Assets;

public class Mushroom {

    public float x,y;

    public Mushroom(float x,float y){

        this.x=x;
        this.y=y;
    }

    public void render(SpriteBatch batch){

        batch.draw(Assets.mushroom,x,y);
    }
}
