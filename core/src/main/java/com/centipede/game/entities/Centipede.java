package com.centipede.game.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.centipede.game.graphics.Assets;

import java.util.ArrayList;

public class Centipede {

    ArrayList<CentipedeSegment> segments = new ArrayList<>();

    float speed = 100;
    int direction = 1;

    public Centipede(int length, com.centipede.game.graphics.SpriteManager sprites){

        for(int i=0;i<length;i++)
            segments.add(new CentipedeSegment(100-i*20,500,sprites));
    }

    public void update(float delta, ArrayList<Mushroom> mushrooms){

        CentipedeSegment head = segments.get(0);

        head.x += speed * direction * delta;

        if(head.x < 0 || head.x > 780){

            direction *= -1;
            head.y -= 20;
        }

        for(int i=segments.size()-1;i>0;i--){

            segments.get(i).x = segments.get(i-1).x;
            segments.get(i).y = segments.get(i-1).y;
        }
    }

    public void render(SpriteBatch batch){

        for(CentipedeSegment s:segments)
            batch.draw(Assets.centipede,s.x,s.y);
    }

    public boolean checkCollision(Bullet bullet){

        for(int i=0;i<segments.size();i++){

            CentipedeSegment s = segments.get(i);

            if(Math.abs(s.x-bullet.x)<16 &&
               Math.abs(s.y-bullet.y)<16){

                segments.remove(i);
                return true;
            }
        }
        return false;
    }
}
