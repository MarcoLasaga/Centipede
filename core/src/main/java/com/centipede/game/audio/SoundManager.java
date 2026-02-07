package com.centipede.game.audio;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

public class SoundManager {

    Sound shoot;

    public SoundManager(){

        shoot = Gdx.audio.newSound(Gdx.files.internal("shoot.wav"));
    }

    public void shoot(){

        shoot.play();
    }
}
