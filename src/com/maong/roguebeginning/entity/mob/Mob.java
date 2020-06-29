package com.maong.roguebeginning.entity.mob;

import com.maong.roguebeginning.entity.Entity;
import com.maong.roguebeginning.graphics.Screen;
import com.maong.roguebeginning.graphics.Sprite;

public abstract class Mob extends Entity {

    protected Sprite sprite;

    protected int dir = 0;
    protected boolean moving = false;

    public void move(int deltaX, int deltaY){
        if(deltaX>0) dir = 1;
        if(deltaX<0) dir = 3;
        if(deltaY>0) dir = 2;
        if(deltaY<0) dir = 0;

        if(!collision()) {
            x += deltaX;
            y += deltaY;
        }
    }

    @Override
    public void update(){
    }

    public void render(Screen screen){

    }

    private boolean collision(){
        return false;
    }

    public int getDir() {
        return dir;
    }

    public Sprite getSprite() {
        return sprite;
    }
}
