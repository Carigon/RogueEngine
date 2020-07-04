package com.maong.roguebeginning.jsonsupport;

public class JsonMapLayer {
    private int number;
    private JsonTile[] tiles;
    private String name;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public JsonTile[] getTiles() {
        return tiles;
    }

    public void setTiles(JsonTile[] tiles) {
        this.tiles = tiles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
