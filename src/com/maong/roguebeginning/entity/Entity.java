package com.maong.roguebeginning.entity;

import com.maong.roguebeginning.graphics.Screen;
import com.maong.roguebeginning.level.Level;

import java.util.Random;

public abstract class Entity {

    public int x, y; //pixel precision
    private boolean removed = false; //whether the entity has been removed from the level.
    protected Level level;
    protected final Random random = new Random();

    /**
     * updates the game logic related to the entity
     */
    public void update(){

    }

    /**
     * renders the entity
     * @param screen
     */
    public void render(Screen screen){

    }

    /**
     * removes the entity from the level
     */
    public void remove(){
        removed = true;
    }

    /**
     * returns whether the item is removed.
     * @return
     */
    public boolean isRemoved(){
        return removed;
    }
}
