package com.maong.roguebeginning.graphics;

import java.util.Arrays;
import java.util.Random;

public class Screen {
    private int width, height;
    public int[] pixels;

    public int tileSize = 16; //note, this must be a power of two.
    public int bitWiseForTileSize;
    public int mapTileRows = 64;
    public int mapTileCols = 64;
    public int[] mapTiles = new int[mapTileCols * mapTileRows];

    private Random random  = new Random();

    public Screen(int width, int height){
        this.width = width;
        this.height = height;
        bitWiseForTileSize = getBitwiseForTileSize();
        pixels = new int[width * height];
        for(int i = 0; i < mapTileCols * mapTileRows; i++){
            mapTiles[i] = random.nextInt(0xffffff);
        }
    }

    public void render(){
        for (int row = 0; row < height; row++){
            int rowrow = row;
            //if(rowrow < 0 || rowrow >= height) break;
            for (int col = 0; col < width; col++){
                int colcol = col+40;
                //if(colcol < 0 || colcol >= height) break;
                int tileIndex = ((colcol >> bitWiseForTileSize) & mapTileCols-1) + ((rowrow >> bitWiseForTileSize) & mapTileCols-1) * mapTileCols;
                pixels[col + row * width] = mapTiles[tileIndex];
            }
        }
    }

    public void clear(){
        Arrays.fill(pixels, 0);
    }

    private int getBitwiseForTileSize(){
        int start = 2;
        int counter = 1;
        if(tileSize<2) return 0;
        while (start < tileSize){
            start = start*2;
            counter++;
        }
        return counter;
    }

}
