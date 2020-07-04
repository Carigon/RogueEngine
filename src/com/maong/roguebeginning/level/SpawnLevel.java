package com.maong.roguebeginning.level;

import com.google.gson.JsonSyntaxException;
import com.maong.roguebeginning.graphics.Screen;
import com.maong.roguebeginning.graphics.SpriteSheet;
import com.maong.roguebeginning.jsonsupport.JsonLevelMap;
import com.maong.roguebeginning.jsonsupport.JsonMapLayer;
import com.maong.roguebeginning.level.tile.Tile;
import com.maong.roguebeginning.level.tile.grasslands.GrassLandsTiles;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import com.google.gson.Gson;


public class SpawnLevel extends Level{

    protected Map<Integer, Tile> tileMap;
    protected JsonLevelMap response;

    /*public SpawnLevel(String path) {
        super(path);
        super.tileMap = generateSpawnTileMap();
    }*/

    public SpawnLevel(String path){
        super();
        tileMap = generateSpawnTileMap();
        loadLevel(path);
        generateLevel();
    }

    /**
     * renders the current level.
     * <p>
     * Sets offset for screen for player/map movement.
     * Sets the pins defining what gets rendered
     *
     * @param xScroll tracks X movement (col) per pixel precision
     * @param yScroll tracks Y movement (row) per pixel precision
     * @param screen  the screen being updated is passed in.
     */
    @Override
    public void render(int xScroll, int yScroll, Screen screen) {
        screen.setOffset(xScroll, yScroll); //setting the offset for redering the map in screen

        /*setting the corner pins.  this determines the render area, and is 1 tile larger in the x and y directions than the screen itself.
        converting those values from pixel precision to tile precision by through a bitwise operation based on tile size.*/
        int x0 = xScroll >> screen.bitWiseForTileSize;
        int x1 = (xScroll + screen.getWidth() + screen.tileSize) >> screen.bitWiseForTileSize;
        int y0 = yScroll >> screen.bitWiseForTileSize;
        int y1 = (yScroll + screen.getHeight() + screen.tileSize) >> screen.bitWiseForTileSize;

        for (int z = response.getLayers().length - 1; z >= 0; z--) {
            for (int y = y0; y < y1; y++) {
                for (int x = x0; x < x1; x++) {
                    this.getTile(x, y, z).render(x, y, screen);
                }
            }
        }
    }

    @Override
    protected void loadLevel(String path) {
        try{
            Gson gsonLevel = new Gson();
            System.out.println(SpawnLevel.class.getResource(path));
            File file = new File(SpawnLevel.class.getResource(path).toURI());
            FileReader reader = new FileReader(file);
            response = gsonLevel.fromJson(reader, JsonLevelMap.class);
            int w = width = response.tileswide;
            int h = height = response.tileshigh;
        } catch (JsonSyntaxException e){
            System.out.println("Exception!  Could not load Level file.");
        } catch (FileNotFoundException e){
            System.out.println("Exception! Could not load level file.");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void generateLevel(){
    }

    public Tile getTile(int x, int y, int z) {
        //check to see if position to be rendered is out of bounds. returns voidTile if rendering would cause IOOB.
        if (x < 0 || x >= width || y < 0 || y >= height) return Tile.voidTile;
        Tile temp = tileMap.get(response.getLayers()[z].getTiles()[x + y * width].getTile());
        if (temp != null) return temp;
        else return Tile.voidTile;
    }

    protected Map<Integer, Tile> generateSpawnTileMap(){
        Map<Integer, Tile> map = new HashMap<>();
        map.put(-1, GrassLandsTiles.voidTile);
        map.put(0, GrassLandsTiles.voidTile);
        map.put(1, GrassLandsTiles.grassVerd1);
        map.put(2, GrassLandsTiles.grassVerdInnerEdgeNW);
        map.put(3, GrassLandsTiles.grassVerdInnerEdgeN);
        map.put(4, GrassLandsTiles.grassVerdInnerEdgeNE);
        map.put(5, GrassLandsTiles.grassVerdOuterEdgeNW);
        map.put(6, GrassLandsTiles.grassVerdOuterEdgeNE);
        map.put(7, GrassLandsTiles.dirtLight1);
        map.put(8, GrassLandsTiles.dirtLight2);
        map.put(9, GrassLandsTiles.dirtLight3);
        map.put(10, GrassLandsTiles.grassVerd2);
        map.put(11, GrassLandsTiles.grassVerdInnerEdgeW);
        map.put(12, GrassLandsTiles.grassVerdFlower);
        map.put(13, GrassLandsTiles.grassVerdInnerEdgeE);
        map.put(14, GrassLandsTiles.grassVerdOuterEdgeSW);
        map.put(15, GrassLandsTiles.grassVerdOuterEdgeSE);
        map.put(16, GrassLandsTiles.dirtMedium1);
        map.put(17, GrassLandsTiles.dirtMedium2);
        map.put(18, GrassLandsTiles.dirtMedium3);
        map.put(19, GrassLandsTiles.grassVerd3);
        map.put(20, GrassLandsTiles.grassVerdInnerEdgeSW);
        map.put(21, GrassLandsTiles.grassVerdInnerEdgeS);
        map.put(22, GrassLandsTiles.grassVerdInnerEdgeSE);
        map.put(23, GrassLandsTiles.grassWallStone1);
        map.put(24, GrassLandsTiles.dirtDark1);
        map.put(25, GrassLandsTiles.dirtDark2);
        map.put(26, GrassLandsTiles.dirtDark3);
        map.put(27, GrassLandsTiles.grassPale1);
        map.put(28, GrassLandsTiles.grassPaleInnerEdgeNW);
        map.put(29, GrassLandsTiles.grassPaleInnerEdgeN);
        map.put(30, GrassLandsTiles.grassPaleInnerEdgeNE);
        map.put(31, GrassLandsTiles.grassPaleOuterEdgeNW);
        map.put(32, GrassLandsTiles.grassPaleOuterEdgeNE);
        map.put(33, GrassLandsTiles.grassPale2);
        map.put(34, GrassLandsTiles.grassPaleInnerEdgeW);
        map.put(35, GrassLandsTiles.grassPaleFlower);
        map.put(36, GrassLandsTiles.grassPaleInnerEdgeE);
        map.put(37, GrassLandsTiles.grassPaleOuterEdgeSW);
        map.put(38, GrassLandsTiles.grassPaleOuterEdgeSE);
        map.put(39, GrassLandsTiles.grassPale3);
        map.put(40, GrassLandsTiles.grassPaleInnerEdgeSW);
        map.put(41, GrassLandsTiles.grassPaleInnerEdgeS);
        map.put(42, GrassLandsTiles.grassPaleInnerEdgeSE);
        map.put(43, GrassLandsTiles.grassBrown1);
        map.put(44, GrassLandsTiles.grassBrownInnerEdgeNW);
        map.put(45, GrassLandsTiles.grassBrownInnerEdgeN);
        map.put(46, GrassLandsTiles.grassBrownInnerEdgeNE);
        map.put(47, GrassLandsTiles.grassBrownOuterEdgeNW);
        map.put(48, GrassLandsTiles.grassBrownOuterEdgeNE);
        map.put(49, GrassLandsTiles.grassBrown2);
        map.put(50, GrassLandsTiles.grassBrownInnerEdgeW);
        map.put(51, GrassLandsTiles.grassBrownFlower);
        map.put(52, GrassLandsTiles.grassBrownInnerEdgeE);
        map.put(53, GrassLandsTiles.grassBrownOuterEdgeSW);
        map.put(54, GrassLandsTiles.grassBrownOuterEdgeSE);
        map.put(55, GrassLandsTiles.grassBrown3);
        map.put(56, GrassLandsTiles.grassBrownInnerEdgeSW);
        map.put(57, GrassLandsTiles.grassBrownInnerEdgeS);
        map.put(58, GrassLandsTiles.grassBrownInnerEdgeSE);
        map.put(59, GrassLandsTiles.voidTile);
        map.put(60, GrassLandsTiles.grassWallStoneEntrance);
        return map;
    }

}
