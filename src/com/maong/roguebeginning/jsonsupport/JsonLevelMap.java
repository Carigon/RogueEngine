package com.maong.roguebeginning.jsonsupport;

public class JsonLevelMap {
    public int getTilewidth() {
        return tilewidth;
    }

    public void setTilewidth(int tilewidth) {
        this.tilewidth = tilewidth;
    }

    public int getTileshigh() {
        return tileshigh;
    }

    public void setTileshigh(int tileshigh) {
        this.tileshigh = tileshigh;
    }

    public JsonMapLayer[] getLayers() {
        return layers;
    }

    public void setLayers(JsonMapLayer[] layers) {
        this.layers = layers;
    }

    public int getTileheight() {
        return tileheight;
    }

    public void setTileheight(int tileheight) {
        this.tileheight = tileheight;
    }

    public int getTileswide() {
        return tileswide;
    }

    public void setTileswide(int tileswide) {
        this.tileswide = tileswide;
    }

    public int tilewidth;
    public int tileshigh;
    public JsonMapLayer[] layers;
    public int tileheight;
    public int tileswide;

}
