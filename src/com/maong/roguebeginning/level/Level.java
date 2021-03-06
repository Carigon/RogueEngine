package com.maong.roguebeginning.level;

import com.maong.roguebeginning.graphics.Screen;
import com.maong.roguebeginning.level.tile.Tile;

import java.util.HashMap;
import java.util.Map;

public class Level {
    protected int width;
    protected int height; // only for random generation. in tiles.
    protected int[] tilesInt;
    protected int[] tiles;
    protected Map<Integer, Tile> tileMap;

    /**
     * constructor for Level where level is randomly generated.
     *
     * @param width  width of level in tiles
     * @param height height of level in tiles
     */
    public Level(int width, int height) {
        this.width = width;
        this.height = height;
        tilesInt = new int[width * height];
        generateLevel();
    }

    /**
     * Constructor for Level object.
     *
     * @param path within the class path, specifies the location of the file containing level data.
     */
    public Level(String path) {
        tileMap = generateTileMap();
        loadLevel(path);
        generateLevel();
    }

    //public Level()

    public Level() {

    }

    /**
     * Generates a Level.  primarily for testing/debugging purposes.
     */
    protected void generateLevel() {
    }

    /**
     * reads the width and height, then generates the level from the information contained in path
     *
     * @param path within the class path, specifies the location of the file containing level data.
     */
    protected void loadLevel(String path) {

    }

    /**
     * updates our level.  tracking entities in the level.
     */
    public void update() {

    }

    /**
     * Tracks the ingame time to track any potential impact on time on the level.
     */
    private void time() {

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
    public void render(int xScroll, int yScroll, Screen screen) {
        screen.setOffset(xScroll, yScroll); //setting the offset for redering the map in screen

        /*setting the corner pins.  this determines the render area, and is 1 tile larger in the x and y directions than the screen itself.
        converting those values from pixel precision to tile precision by through a bitwise operation based on tile size.*/
        int x0 = xScroll >> screen.bitWiseForTileSize;
        int x1 = (xScroll + screen.getWidth() + screen.tileSize) >> screen.bitWiseForTileSize;
        int y0 = yScroll >> screen.bitWiseForTileSize;
        int y1 = (yScroll + screen.getHeight() + screen.tileSize) >> screen.bitWiseForTileSize;

        for (int y = y0; y < y1; y++) {
            for (int x = x0; x < x1; x++) {
                getTile(x, y).render(x, y, screen);
            }
        }
    }

    /**
     * Retrieves the a given tile from the level array.
     *
     * @param x the x (col) position in the level
     * @param y the y (row) position in the level
     * @return
     */
    public Tile getTile(int x, int y) {
        //check to see if position to be rendered is out of bounds. returns voidTile if rendering would cause IOOB.
        if (x < 0 || x >= width || y < 0 || y >= height) return Tile.voidTile;
        Tile temp = tileMap.get(tiles[x + y * width]);
        if (temp != null) return temp;
        else return Tile.voidTile;
    }

    /**
     * generates by color code -> tile type
     * Grass = 0x00FF00
     * GrassFlower = 0xFFFF00
     * RockFlower = 0xBBBBBB
     * Ocean = 0x0000FF
     */
    protected Map<Integer, Tile> generateTileMap(){
        Map<Integer, Tile> map = new HashMap<>();
        map.put(0xff00ff00, Tile.grass);
        map.put(0xFFFFFF00, Tile.grassFlower);
        map.put(0xFFBBBBBB, Tile.grassRock);
        map.put(0xFF0000FF, Tile.ocean);
        return map;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }


}
