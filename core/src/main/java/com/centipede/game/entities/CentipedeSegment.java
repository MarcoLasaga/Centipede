package com.centipede.game.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;
import com.centipede.game.graphics.SpriteManager;

public class CentipedeSegment {

    float x,y;
    float speed = 100;

    Texture sprite;

    public CentipedeSegment(float x,float y,SpriteManager sprites){

        this.x=x;
        this.y=y;
        this.sprite=sprites.segment;
    }

    public void move(float delta){

        x+=speed*delta;
    }

    public void follow(CentipedeSegment leader){

        x=leader.x-32;
        y=leader.y;
    }

    public void render(SpriteBatch batch){

        batch.draw(sprite,x,y);
    }
}
