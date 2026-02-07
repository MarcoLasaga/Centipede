package com.centipede.game.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;

public class Assets {

    public static Texture player;
    public static Texture bullet;
    public static Texture centipede;
    public static Texture mushroom;

    public static void load(){

        // Create placeholder textures (1x1 white pixel)
        Pixmap pixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        pixmap.setColor(1, 1, 1, 1);
        pixmap.fillRectangle(0, 0, 1, 1);
        
        player = new Texture(pixmap);
        bullet = new Texture(pixmap);
        centipede = new Texture(pixmap);
        mushroom = new Texture(pixmap);
        
        pixmap.dispose();
    }

    public static void dispose(){

        player.dispose();
        bullet.dispose();
        centipede.dispose();
        mushroom.dispose();
    }
}
