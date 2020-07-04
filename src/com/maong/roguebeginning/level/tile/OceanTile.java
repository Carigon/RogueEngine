package com.maong.roguebeginning.level.tile;

import com.maong.roguebeginning.graphics.Screen;
import com.maong.roguebeginning.graphics.Sprite;

public class OceanTile extends Tile {
    public OceanTile(Sprite sprite) {
        super(sprite);
    }

    /**
     * Renders the grass tile.
     * @param x represents the x position of the tile to be rendered. this is a PIXEL location, not tile.
     * @param y represents the y position of the tile to be rendered. this is a PIXEL location, not tile.
     * @param screen The screen object that contains the game rendering.
     */
    @Override
    public void render(int x, int y, Screen screen) {
        screen.renderTile(x << screen.bitWiseForTileSize, y << screen.bitWiseForTileSize, this);
    }
}
