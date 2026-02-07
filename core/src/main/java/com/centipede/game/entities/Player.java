package com.centipede.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.centipede.game.graphics.Assets;
import com.centipede.game.util.Constants;

public class Player {

    public float x = 400;
    public float y = 50;

    float cooldown = 0;

    public void update(float delta) {

        if (Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.LEFT))
            x -= Constants.PLAYER_SPEED * delta;

        if (Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.RIGHT))
            x += Constants.PLAYER_SPEED * delta;

        cooldown -= delta;
    }

    public boolean canShoot() {

        if (Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.SPACE)
                && cooldown <= 0) {

            cooldown = 0.25f;
            return true;
        }

        return false;
    }

    public Bullet shoot() {

        return new Bullet(x + 8, y + 20);
    }

    public void render(SpriteBatch batch) {

        batch.draw(Assets.player, x, y);
    }
}
