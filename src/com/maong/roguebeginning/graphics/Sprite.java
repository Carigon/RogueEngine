package com.maong.roguebeginning.graphics;

import java.util.Arrays;

public class Sprite {
    public final int SIZE;
    private int x, y;
    public int[] pixels;

    private SpriteSheet sheet;

    public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.tiles);
    public static Sprite voidSprite = new Sprite(16, 0);
    //16 scale player sprites
    //facing south
    public static Sprite playerS = new Sprite(16, 0, 15, SpriteSheet.tiles);
    public static Sprite playerSR = new Sprite(16, 0, 14, SpriteSheet.tiles);
    public static Sprite playerSL = new Sprite(16, 0, 13, SpriteSheet.tiles);
    //facing north
    public static Sprite playerN = new Sprite(16, 1, 15, SpriteSheet.tiles);
    public static Sprite playerNR = new Sprite(16, 1, 14, SpriteSheet.tiles);
    public static Sprite playerNL = new Sprite(16, 1, 13, SpriteSheet.tiles);
    //facing east
    public static Sprite playerE = new Sprite(16, 2, 15, SpriteSheet.tiles);
    public static Sprite playerER = new Sprite(16, 2, 14, SpriteSheet.tiles);
    public static Sprite playerEL = new Sprite(16, 2, 13, SpriteSheet.tiles);
    //facing west
    public static Sprite playerW = new Sprite(16, 3, 15, SpriteSheet.tiles);
    public static Sprite playerWR = new Sprite(16, 3, 14, SpriteSheet.tiles);
    public static Sprite playerWL = new Sprite(16, 3, 13, SpriteSheet.tiles);
    //facing Southwest
    public static Sprite playerSW = new Sprite(16, 4, 15, SpriteSheet.tiles);
    public static Sprite playerSWR = new Sprite(16, 4, 14, SpriteSheet.tiles);
    public static Sprite playerSWL = new Sprite(16, 4, 13, SpriteSheet.tiles);
    //facing Northeast
    public static Sprite playerNE = new Sprite(16, 5, 15, SpriteSheet.tiles);
    public static Sprite playerNER = new Sprite(16, 5, 14, SpriteSheet.tiles);
    public static Sprite playerNEL = new Sprite(16, 5, 13, SpriteSheet.tiles);
    //facing Northwest
    public static Sprite playerNW = new Sprite(16, 6, 15, SpriteSheet.tiles);
    public static Sprite playerNWR = new Sprite(16, 6, 14, SpriteSheet.tiles);
    public static Sprite playerNWL = new Sprite(16, 6, 13, SpriteSheet.tiles);
    //facing Southeast
    public static Sprite playerSE = new Sprite(16, 7, 15, SpriteSheet.tiles);
    public static Sprite playerSER = new Sprite(16, 7, 14, SpriteSheet.tiles);
    public static Sprite playerSEL = new Sprite(16, 7, 13, SpriteSheet.tiles);
    //Big sprites
    public static Sprite playerBig = new Sprite(32, 2,7, SpriteSheet.tiles);

    public Sprite(int size, int x, int y, SpriteSheet sheet) {
        this.SIZE = size;
        pixels = new int[SIZE*SIZE];
        this.x = x * SIZE;
        this.y = y * SIZE;
        this.sheet = sheet;
        load();
    }

    public Sprite(int size, int color){
         this.SIZE = size;
         pixels = new int[SIZE*SIZE];
         setColor(color);
    }

    private void setColor(int color){
        Arrays.fill(pixels, color);
    }

    private void load(){
        for(int y = 0; y < SIZE; y++){
            for(int x = 0; x<SIZE; x++){
                pixels[x+y*SIZE] = sheet.pixels[(x+this.x)+(y+this.y)*sheet.SIZE];
            }
        }
    }
}
