package com.centipede.game;

import com.badlogic.gdx.Game;
import com.centipede.game.graphics.Assets;
import com.centipede.game.screens.GameScreen;

public class Main extends Game {

    @Override
    public void create() {
        Assets.load();
        setScreen(new GameScreen());
    }

    @Override
    public void dispose() {
        Assets.dispose();
    }
}
