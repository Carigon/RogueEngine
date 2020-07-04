package com.maong.roguebeginning.level.tile;

import com.maong.roguebeginning.graphics.Screen;
import com.maong.roguebeginning.graphics.Sprite;

public class Tile {
    public int x, y;
    public Sprite sprite;

    //void tile
    public static Tile voidTile = new VoidTile(Sprite.voidSprite);

    //tiles in spritesheet3
    public static Tile grass = new GrassTile(Sprite.grass);
    public static Tile grassFlower = new GrassFlowerTile(Sprite.grassFlower);
    public static Tile grassRock = new GrassRockTile(Sprite.grassRock);
    public static Tile ocean = new OceanTile(Sprite.ocean);


    public Tile(Sprite sprite){
        this.sprite = sprite;
    }

    public void render(int x, int y, Screen screen) {
        screen.renderTile(x << screen.bitWiseForTileSize, y << screen.bitWiseForTileSize, this);
    }

    public boolean solid(){
        return false;
    }
}
