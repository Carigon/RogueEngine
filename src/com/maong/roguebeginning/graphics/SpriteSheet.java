package com.maong.roguebeginning.graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SpriteSheet {
    private String path; //contains the file path for the specific spritesheet
    public final int SIZE; //spritesheet size.
    public int[] pixels;

    public static SpriteSheet tiles = new SpriteSheet("/textures/spritesheets/SpriteSheet3.png", 256);
    public static SpriteSheet grasslands = new SpriteSheet("/textures/spritesheets/grasslands2.png", 144);

    public SpriteSheet(String path, int size) {
        this.path = path;
        this.SIZE = size;
        pixels = new int[SIZE * SIZE];
        load();
    }

    private void load() {
        try {
            BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
            int w = image.getWidth();
            int h = image.getHeight();
            image.getRGB(0, 0, w, h, pixels, 0, w);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
