package com.centipede.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.centipede.game.entities.*;
import com.centipede.game.graphics.ParticleManager;
import com.centipede.game.graphics.SpriteManager;

import java.util.ArrayList;
import java.util.Iterator;

public class GameScreen implements Screen {

    SpriteBatch batch;

    Player player;

    ArrayList<Bullet> bullets = new ArrayList<>();
    ArrayList<Mushroom> mushrooms = new ArrayList<>();

    Centipede centipede;

    ParticleManager particles;

    public GameScreen() {

        batch = new SpriteBatch();
        SpriteManager sprites = new SpriteManager();

        player = new Player();

        centipede = new Centipede(12, sprites);

        particles = new ParticleManager();

        generateMushrooms();
    }

    private void generateMushrooms() {

        for (int i = 0; i < 40; i++) {

            mushrooms.add(new Mushroom(
                    (int)(Math.random()*760),
                    (int)(Math.random()*500)+50
            ));
        }
    }

    @Override
    public void render(float delta) {

        update(delta);

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        player.render(batch);

        centipede.render(batch);

        for (Mushroom m : mushrooms)
            m.render(batch);

        for (Bullet b : bullets)
            b.render(batch);

        particles.render(batch);

        batch.end();
    }

    private void update(float delta) {

        player.update(delta);

        if (player.canShoot()) {

            bullets.add(player.shoot());
        }

        centipede.update(delta, mushrooms);

        updateBullets(delta);

        particles.update(delta);
    }

    private void updateBullets(float delta) {

        Iterator<Bullet> it = bullets.iterator();

        while (it.hasNext()) {

            Bullet b = it.next();

            b.update(delta);

            if (b.y > 600)
                it.remove();

            if (centipede.checkCollision(b)) {

                particles.spawnExplosion(b.x, b.y);

                it.remove();
            }
        }
    }

    public void dispose() {
        batch.dispose();
    }

    public void show(){}
    public void resize(int w,int h){}
    public void pause(){}
    public void resume(){}
    public void hide(){}
}
