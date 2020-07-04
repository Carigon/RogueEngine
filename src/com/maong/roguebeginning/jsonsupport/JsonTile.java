package com.maong.roguebeginning.jsonsupport;

public class JsonTile {
    private int x;
    private boolean flipX;
    private int y;
    private int index;
    private int tile;
    private int rot;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public boolean isFlipX() {
        return flipX;
    }

    public void setFlipX(boolean flipX) {
        this.flipX = flipX;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getTile() {
        return tile;
    }

    public void setTile(int tile) {
        this.tile = tile;
    }

    public int getRot() {
        return rot;
    }

    public void setRot(int rot) {
        this.rot = rot;
    }

}
