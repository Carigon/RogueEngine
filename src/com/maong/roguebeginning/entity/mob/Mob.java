package com.maong.roguebeginning.entity.mob;

import com.maong.roguebeginning.entity.Entity;
import com.maong.roguebeginning.graphics.Screen;
import com.maong.roguebeginning.graphics.Sprite;

public abstract class Mob extends Entity {

    protected Sprite sprite;

    protected int dir = 0;
    protected int prevDir = 0;
    protected boolean moving = false;

    public void move(int deltaX, int deltaY){
        prevDir = dir;

        if (deltaY < 0 && deltaX == 0) dir = 0;
        if (deltaX > 0 && deltaY < 0) dir = 1;
        if (deltaX > 0 && deltaY == 0) dir = 2;
        if (deltaX > 0 && deltaY > 0) dir = 3;
        if (deltaY > 0 && deltaX == 0) dir = 4;
        if (deltaX < 0 && deltaY > 0) dir = 5;
        if (deltaX < 0 && deltaY == 0) dir = 6;
        if (deltaX < 0 && deltaY < 0) dir = 7;

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
