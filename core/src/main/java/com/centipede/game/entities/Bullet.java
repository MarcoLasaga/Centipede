package com.centipede.game.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.centipede.game.graphics.Assets;
import com.centipede.game.util.Constants;

public class Bullet {

    public float x,y;

    public Bullet(float x,float y){

        this.x=x;
        this.y=y;
    }

    public void update(float delta){

        y += Constants.BULLET_SPEED * delta;
    }

    public void render(SpriteBatch batch){

        batch.draw(Assets.bullet,x,y);
    }
}
