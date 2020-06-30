package com.maong.roguebeginning.entity.mob.player;

import com.maong.roguebeginning.entity.mob.Mob;
import com.maong.roguebeginning.graphics.Screen;
import com.maong.roguebeginning.graphics.Sprite;
import com.maong.roguebeginning.input.Keyboard;

import java.util.HashMap;
import java.util.Map;

public class Player extends Mob {
    private Keyboard input;
    private Map<Integer, Sprite[]> spriteMap;
    private int anim = 0;
    private int pacing = 20;
    private int gait = 0;

    public Player(Keyboard input, int x, int y) {
        this(input);
        this.x = x;
        this.y = y;
    }

    public Player(Keyboard input) {
        this.input = input;
        sprite = Sprite.playerS;
        this.spriteMap = new HashMap<>();
        spriteMap.put(0, new Sprite[]{Sprite.playerN, Sprite.playerNR, Sprite.playerN, Sprite.playerNL});
        spriteMap.put(1, new Sprite[]{Sprite.playerNE, Sprite.playerNER, Sprite.playerNE, Sprite.playerNEL});
        spriteMap.put(2, new Sprite[]{Sprite.playerE, Sprite.playerER, Sprite.playerE, Sprite.playerEL});
        spriteMap.put(3, new Sprite[]{Sprite.playerSE, Sprite.playerSER, Sprite.playerSE, Sprite.playerSEL});
        spriteMap.put(4, new Sprite[]{Sprite.playerS, Sprite.playerSR, Sprite.playerS, Sprite.playerSL});
        spriteMap.put(5, new Sprite[]{Sprite.playerSW, Sprite.playerSWR, Sprite.playerSW, Sprite.playerSWL});
        spriteMap.put(6, new Sprite[]{Sprite.playerW, Sprite.playerWR, Sprite.playerW, Sprite.playerWL});
        spriteMap.put(7, new Sprite[]{Sprite.playerNW, Sprite.playerNWR, Sprite.playerNW, Sprite.playerNWL});
    }

    @Override
    public void update() {
        if (anim < Integer.MAX_VALUE) anim++;
        else anim = 0;
        if(anim%pacing == 0) gait++;

        int xa = 0;
        int ya = 0;
        if (input.up) ya--;
        if (input.down) ya++;
        if (input.left) xa--;
        if (input.right) xa++;

        if (xa != 0 || ya != 0) {
            moving = true;
            move(xa, ya);
        } else moving = false;
    }

    @Override
    public void render(Screen screen) {
        if (moving) {
            sprite = spriteMap.get(dir)[gait % spriteMap.get(dir).length];
        } else {
            sprite = spriteMap.get(dir)[0];
        }
        screen.renderPlayer(x - this.sprite.SIZE / 2, y - this.sprite.SIZE / 2, this.sprite);
    }
}
