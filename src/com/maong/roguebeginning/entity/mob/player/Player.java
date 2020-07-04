package com.maong.roguebeginning.entity.mob.player;

import com.maong.roguebeginning.entity.mob.Mob;
import com.maong.roguebeginning.graphics.PlayerSprite;
import com.maong.roguebeginning.graphics.Screen;
import com.maong.roguebeginning.graphics.Sprite;
import com.maong.roguebeginning.input.Keyboard;

import java.util.HashMap;
import java.util.Map;

public class Player extends Mob {
    private Keyboard input;
    private Map<Integer, Sprite[]> spriteMap;
    private int anim = 0;
    private int pacing = 15;
    private int frame = 0;

    public Player(Keyboard input, int x, int y) {
        this(input);
        this.x = x;
        this.y = y;
    }

    public Player(Keyboard input) {
        this.input = input;
        sprite = PlayerSprite.playerS;
        this.spriteMap = new HashMap<>();
        spriteMap.put(0, new Sprite[]{PlayerSprite.playerN, PlayerSprite.playerNR, PlayerSprite.playerN, PlayerSprite.playerNL});
        spriteMap.put(1, new Sprite[]{PlayerSprite.playerNE, PlayerSprite.playerNER, PlayerSprite.playerNE, PlayerSprite.playerNEL});
        spriteMap.put(2, new Sprite[]{PlayerSprite.playerE, PlayerSprite.playerER, PlayerSprite.playerE, PlayerSprite.playerEL});
        spriteMap.put(3, new Sprite[]{PlayerSprite.playerSE, PlayerSprite.playerSER, PlayerSprite.playerSE, PlayerSprite.playerSEL});
        spriteMap.put(4, new Sprite[]{PlayerSprite.playerS, PlayerSprite.playerSR, PlayerSprite.playerS, PlayerSprite.playerSL});
        spriteMap.put(5, new Sprite[]{PlayerSprite.playerSW, PlayerSprite.playerSWR, PlayerSprite.playerSW, PlayerSprite.playerSWL});
        spriteMap.put(6, new Sprite[]{PlayerSprite.playerW, PlayerSprite.playerWR, PlayerSprite.playerW, PlayerSprite.playerWL});
        spriteMap.put(7, new Sprite[]{PlayerSprite.playerNW, PlayerSprite.playerNWR, PlayerSprite.playerNW, PlayerSprite.playerNWL});
    }

    @Override
    public void update() {
        if (anim < Integer.MAX_VALUE) anim++;
        else anim = 0;
        if(anim%pacing == 0) frame++;

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
            sprite = spriteMap.get(dir)[frame % spriteMap.get(dir).length];
        } else {
            sprite = spriteMap.get(dir)[0];
        }
        screen.renderPlayer(x - this.sprite.SIZE / 2, y - this.sprite.SIZE / 2, this.sprite);
    }
}
