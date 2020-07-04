package com.maong.roguebeginning.level;

import com.maong.roguebeginning.level.tile.Tile;
import com.maong.roguebeginning.level.tile.grasslands.GrassLandsTiles;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SpawnLevel extends Level{

    private Map<Integer, Tile> tileMap;

    /*public SpawnLevel(String path) {
        super(path);
        super.tileMap = generateSpawnTileMap();
    }*/

    public SpawnLevel(String path){
        super();
        super.tileMap = generateSpawnTileMap();
        loadLevel(path);
        generateLevel();
    }


    @Override
    protected void loadLevel(String path) {
        try{
            BufferedImage image = ImageIO.read(SpawnLevel.class.getResource(path));
            int w = width = image.getWidth();
            int h = height = image.getHeight();
            tiles = new int[w*h];
            image.getRGB(0,0, w, h, tiles, 0, w);
        } catch (IOException e){
            System.out.println("Exception!  Could not load Level file.");
        }
    }

    @Override
    protected void generateLevel(){
    }

    protected Map<Integer, Tile> generateSpawnTileMap(){
        Map<Integer, Tile> map = new HashMap<>();
        map.put(0xff00ff00, GrassLandsTiles.grassVerd1);
        map.put(0xFFFFFF00, GrassLandsTiles.grassVerd2);
        map.put(0xFFBBBBBB, GrassLandsTiles.grassVerd3);
        map.put(0xFF0000FF, GrassLandsTiles.grassVerdFlower);
        return map;
    }

}
