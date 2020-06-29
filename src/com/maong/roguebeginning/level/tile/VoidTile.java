package com.maong.roguebeginning.level.tile;

import com.maong.roguebeginning.graphics.Screen;
import com.maong.roguebeginning.graphics.Sprite;

public class VoidTile extends Tile {
    public VoidTile(Sprite sprite) {
        super(sprite);
    }

    @Override
    public void render(int x, int y, Screen screen) {
        screen.renderTile(x << screen.bitWiseForTileSize, y << screen.bitWiseForTileSize, this);
    }
}
