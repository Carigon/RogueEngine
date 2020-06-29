package com.maong.roguebeginning.graphics;

import com.maong.roguebeginning.level.tile.Tile;

import java.util.Arrays;
import java.util.Random;

public class Screen {


    private int width, height;
    public int[] pixels;

    public int spriteSize = 16; //note, this must be a power of two. equates to a 16x16 tile/sprite
    public int bitWiseForTileSize;
    public int mapSize = 64;
    public int xOffset, yOffset;

    public int[] mapTiles = new int[mapSize * mapSize];

    private Random random = new Random();

    public Screen(int width, int height) {
        this.width = width;
        this.height = height;
        bitWiseForTileSize = getBitwiseForTileSize();
        pixels = new int[width * height];
    }

    /* removed the legacy rendering method.  keeping in comments for posterity.

    public void render(int xOffset, int yOffset) {
        for (int row = 0; row < height; row++) {
            int rowp = row + yOffset;
            if (rowp < 0 || rowp >= height) continue;
            for (int col = 0; col < width; col++) {
                int colp = col + xOffset;
                if (colp < 0 || colp >= width) continue;
                pixels[colp + rowp * width] = Sprite.grass.pixels[(col & 15) + (row & 15) * Sprite.grass.SIZE];
            }
        }

    }*/

    public void renderTile(int xp, int yp, Tile tile){
        xp -= xOffset;
        yp -= yOffset;
        for(int y = 0; y < tile.sprite.SIZE; y++){
            int ya = y + yp; // ya (y absolute) is equal to the y pos plus some offset (yp).
            for(int x = 0; x < tile.sprite.SIZE; x++){
                int xa = x + xp; // xa (x absolute) is equal to the x pos plus some offset (xp).
                if(xa < -tile.sprite.SIZE || xa >= width || ya < -tile.sprite.SIZE || ya >= height) break; //ensures that tiles that are outside of render area are not rendered.
                if(xa<0) xa = 0;
                if(ya<0) ya = 0;
                pixels[xa + ya * width] = tile.sprite.pixels[x + y * tile.sprite.SIZE];
            }
        }
    }

    public void setOffset(int xOffset, int yOffset){
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

    public void clear() {
        Arrays.fill(pixels, 0);
    }

    private int getBitwiseForTileSize() {
        int start = 2;
        int counter = 1;
        if (spriteSize < 2) return 0;
        while (start < spriteSize) {
            start = start * 2;
            counter++;
        }
        return counter;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
