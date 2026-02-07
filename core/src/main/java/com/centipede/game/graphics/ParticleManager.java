package com.centipede.game.graphics;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ParticleManager {

    public void explosion(float x,float y){

        System.out.println("Particle explosion at "+x+","+y);
    }

    public void spawnExplosion(float x, float y) {
        explosion(x, y);
    }

    public void update(float delta){}

    public void render(SpriteBatch batch){}
}
