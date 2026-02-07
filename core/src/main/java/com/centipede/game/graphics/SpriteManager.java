package com.centipede.game.graphics;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;

public class SpriteManager {

    public Texture player;
    public Texture segment;

    public SpriteManager(){

        // Create placeholder textures (1x1 white pixel)
        Pixmap pixmap = new Pixmap(32, 32, Pixmap.Format.RGBA8888);
        pixmap.setColor(0.5f, 0.5f, 0.5f, 1);
        pixmap.fillRectangle(0, 0, 32, 32);
        
        player = new Texture(pixmap);
        segment = new Texture(pixmap);
        
        pixmap.dispose();
    }
}
