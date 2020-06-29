package com.maong.roguebeginning.entity.mob.player;

import com.maong.roguebeginning.entity.mob.Mob;
import com.maong.roguebeginning.graphics.Screen;
import com.maong.roguebeginning.graphics.Sprite;
import com.maong.roguebeginning.input.Keyboard;

public class Player extends Mob {
    private Keyboard input;

    public Player(Keyboard input){
        this.input = input;
        sprite = Sprite.playerStanding;
    }

    public Player(Keyboard input, int x, int y){
        this.x = x;
        this.y = y;
        this.input = input;
        sprite = Sprite.playerStanding;
    }

    @Override
    public void update(){
        int xa = 0;
        int ya = 0;
        if(input.up) ya--;
        if(input.down) ya++;
        if(input.left) xa--;
        if(input.right) xa++;

        if(xa != 0 || ya != 0) move(xa, ya);
    }

    @Override
    public void render(Screen screen){
        screen.renderPlayer(x, y, this);
    }
}
