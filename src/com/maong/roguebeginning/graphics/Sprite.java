package com.maong.roguebeginning.graphics;

import java.util.Arrays;

public class Sprite {
    public final int SIZE;
    private int x, y;
    public int[] pixels;

    private SpriteSheet sheet;

    //Sprites from SpriteSheet3, includes player sprites
    public static Sprite voidSprite = new Sprite(16, 0);
    public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.tiles);
    public static Sprite grassFlower = new Sprite(16, 1, 0, SpriteSheet.tiles);
    public static Sprite grassRock = new Sprite(16, 2, 0, SpriteSheet.tiles);
    public static Sprite ocean = new Sprite(16, 3, 0, SpriteSheet.tiles);

    public static Sprite bricks = new Sprite(16, 0, 1, SpriteSheet.tiles);
    public static Sprite torchWallFront = new Sprite(16, 1, 1, SpriteSheet.tiles);
    public static Sprite torchWallSide = new Sprite(16, 2, 1, SpriteSheet.tiles);

    public static Sprite stoneCut = new Sprite(16, 0, 2, SpriteSheet.tiles);
    public static Sprite CaveDirtBrown1 = new Sprite(16, 1, 2, SpriteSheet.tiles);
    public static Sprite CaveDirtBrown2 = new Sprite(16, 2, 2, SpriteSheet.tiles);
    public static Sprite CaveDirtBrown3 = new Sprite(16, 3, 2, SpriteSheet.tiles);

    public static Sprite stoneCutGate = new Sprite(16, 0, 3, SpriteSheet.tiles);
    public static Sprite CaveDirtGrey1 = new Sprite(16, 1, 3, SpriteSheet.tiles);
    public static Sprite CaveDirtGrey2 = new Sprite(16, 2, 3, SpriteSheet.tiles);
    public static Sprite CaveDirtGrey3 = new Sprite(16, 3, 3, SpriteSheet.tiles);

    public static Sprite lava1 = new Sprite(16, 0, 4, SpriteSheet.tiles);

    public static Sprite wallSideTopRight = new Sprite(16, 4, 0, SpriteSheet.tiles);
    public static Sprite wallSideTopLeft = new Sprite(16, 5, 0, SpriteSheet.tiles);
    public static Sprite wallSideRight = new Sprite(16, 4, 1, SpriteSheet.tiles);
    public static Sprite wallSideLeft = new Sprite(16, 5, 1, SpriteSheet.tiles);
    public static Sprite wallSideBottomRightEndStone = new Sprite(16, 4, 2, SpriteSheet.tiles);
    public static Sprite wallSideBottomLeftEndStone = new Sprite(16, 5, 2, SpriteSheet.tiles);
    public static Sprite wallSideBottomRightEndBrick = new Sprite(16, 4, 3, SpriteSheet.tiles);
    public static Sprite wallSideBottomLeftEndBrick = new Sprite(16, 5, 3, SpriteSheet.tiles);

    //16 scale player sprites
    //facing south
    public static Sprite playerS = new Sprite(16, 0, 15, SpriteSheet.tiles);
    public static Sprite playerSR = new Sprite(16, 0, 14, SpriteSheet.tiles);
    public static Sprite playerSL = new Sprite(16, 0, 13, SpriteSheet.tiles);
    //facing north
    public static Sprite playerN = new Sprite(16, 1, 15, SpriteSheet.tiles);
    public static Sprite playerNR = new Sprite(16, 1, 14, SpriteSheet.tiles);
    public static Sprite playerNL = new Sprite(16, 1, 13, SpriteSheet.tiles);
    //facing east
    public static Sprite playerE = new Sprite(16, 2, 15, SpriteSheet.tiles);
    public static Sprite playerER = new Sprite(16, 2, 14, SpriteSheet.tiles);
    public static Sprite playerEL = new Sprite(16, 2, 13, SpriteSheet.tiles);
    //facing west
    public static Sprite playerW = new Sprite(16, 3, 15, SpriteSheet.tiles);
    public static Sprite playerWR = new Sprite(16, 3, 14, SpriteSheet.tiles);
    public static Sprite playerWL = new Sprite(16, 3, 13, SpriteSheet.tiles);
    //facing Southwest
    public static Sprite playerSW = new Sprite(16, 4, 15, SpriteSheet.tiles);
    public static Sprite playerSWR = new Sprite(16, 4, 14, SpriteSheet.tiles);
    public static Sprite playerSWL = new Sprite(16, 4, 13, SpriteSheet.tiles);
    //facing Northeast
    public static Sprite playerNE = new Sprite(16, 5, 15, SpriteSheet.tiles);
    public static Sprite playerNER = new Sprite(16, 5, 14, SpriteSheet.tiles);
    public static Sprite playerNEL = new Sprite(16, 5, 13, SpriteSheet.tiles);
    //facing Northwest
    public static Sprite playerNW = new Sprite(16, 6, 15, SpriteSheet.tiles);
    public static Sprite playerNWR = new Sprite(16, 6, 14, SpriteSheet.tiles);
    public static Sprite playerNWL = new Sprite(16, 6, 13, SpriteSheet.tiles);
    //facing Southeast
    public static Sprite playerSE = new Sprite(16, 7, 15, SpriteSheet.tiles);
    public static Sprite playerSER = new Sprite(16, 7, 14, SpriteSheet.tiles);
    public static Sprite playerSEL = new Sprite(16, 7, 13, SpriteSheet.tiles);
    //Big sprites
    public static Sprite playerBig = new Sprite(32, 2,7, SpriteSheet.tiles);

    //Grasslands Sprites
    //Verdent Grass
    public static Sprite grassVerd1 = new Sprite(16, 0, 0, SpriteSheet.grasslands);
    public static Sprite grassVerd2 = new Sprite(16, 0, 1, SpriteSheet.grasslands);
    public static Sprite grassVerd3 = new Sprite(16, 0, 2, SpriteSheet.grasslands);
    public static Sprite grassVerdFlower = new Sprite(16, 2, 1, SpriteSheet.grasslands);
    public static Sprite grassVerdInnerEdgeNW = new Sprite(16, 1, 0, SpriteSheet.grasslands);
    public static Sprite grassVerdInnerEdgeW = new Sprite(16, 1, 1, SpriteSheet.grasslands);
    public static Sprite grassVerdInnerEdgeSW = new Sprite(16, 1, 2, SpriteSheet.grasslands);
    public static Sprite grassVerdInnerEdgeN = new Sprite(16, 2, 0, SpriteSheet.grasslands);
    public static Sprite grassVerdInnerEdgeS = new Sprite(16, 2, 2, SpriteSheet.grasslands);
    public static Sprite grassVerdInnerEdgeNE = new Sprite(16, 3, 0, SpriteSheet.grasslands);
    public static Sprite grassVerdInnerEdgeE = new Sprite(16, 3, 1, SpriteSheet.grasslands);
    public static Sprite grassVerdInnerEdgeSE = new Sprite(16, 3, 2, SpriteSheet.grasslands);
    public static Sprite grassVerdOuterEdgeNW = new Sprite(16, 4, 0, SpriteSheet.grasslands);
    public static Sprite grassVerdOuterEdgeSW = new Sprite(16, 4, 1, SpriteSheet.grasslands);
    public static Sprite grassVerdOuterEdgeNE = new Sprite(16, 5, 0, SpriteSheet.grasslands);
    public static Sprite grassVerdOuterEdgeSE = new Sprite(16, 5, 1, SpriteSheet.grasslands);

    //Pale Grass
    public static Sprite grassPale1 = new Sprite(16, 0, 3, SpriteSheet.grasslands);
    public static Sprite grassPale2 = new Sprite(16, 0, 4, SpriteSheet.grasslands);
    public static Sprite grassPale3 = new Sprite(16, 0, 5, SpriteSheet.grasslands);
    public static Sprite grassPaleFlower = new Sprite(16, 2, 4, SpriteSheet.grasslands);
    public static Sprite grassPaleInnerEdgeNW = new Sprite(16, 1, 3, SpriteSheet.grasslands);
    public static Sprite grassPaleInnerEdgeW = new Sprite(16, 1, 4, SpriteSheet.grasslands);
    public static Sprite grassPaleInnerEdgeSW = new Sprite(16, 1, 5, SpriteSheet.grasslands);
    public static Sprite grassPaleInnerEdgeN = new Sprite(16, 2, 3, SpriteSheet.grasslands);
    public static Sprite grassPaleInnerEdgeS = new Sprite(16, 2, 5, SpriteSheet.grasslands);
    public static Sprite grassPaleInnerEdgeNE = new Sprite(16, 3, 3, SpriteSheet.grasslands);
    public static Sprite grassPaleInnerEdgeE = new Sprite(16, 3, 4, SpriteSheet.grasslands);
    public static Sprite grassPaleInnerEdgeSE = new Sprite(16, 3, 5, SpriteSheet.grasslands);
    public static Sprite grassPaleOuterEdgeNW = new Sprite(16, 4, 3, SpriteSheet.grasslands);
    public static Sprite grassPaleOuterEdgeSW = new Sprite(16, 4, 4, SpriteSheet.grasslands);
    public static Sprite grassPaleOuterEdgeNE = new Sprite(16, 5, 3, SpriteSheet.grasslands);
    public static Sprite grassPaleOuterEdgeSE = new Sprite(16, 5, 4, SpriteSheet.grasslands);

    //Brown Grass
    public static Sprite grassBrown1 = new Sprite(16, 0, 6, SpriteSheet.grasslands);
    public static Sprite grassBrown2 = new Sprite(16, 0, 7, SpriteSheet.grasslands);
    public static Sprite grassBrown3 = new Sprite(16, 0, 8, SpriteSheet.grasslands);
    public static Sprite grassBrownFlower = new Sprite(16, 2, 7, SpriteSheet.grasslands);
    public static Sprite grassBrownInnerEdgeNW = new Sprite(16, 1, 6, SpriteSheet.grasslands);
    public static Sprite grassBrownInnerEdgeW = new Sprite(16, 1, 7, SpriteSheet.grasslands);
    public static Sprite grassBrownInnerEdgeSW = new Sprite(16, 1, 8, SpriteSheet.grasslands);
    public static Sprite grassBrownInnerEdgeN = new Sprite(16, 2, 6, SpriteSheet.grasslands);
    public static Sprite grassBrownInnerEdgeS = new Sprite(16, 2, 8, SpriteSheet.grasslands);
    public static Sprite grassBrownInnerEdgeNE = new Sprite(16, 3, 6, SpriteSheet.grasslands);
    public static Sprite grassBrownInnerEdgeE = new Sprite(16, 3, 7, SpriteSheet.grasslands);
    public static Sprite grassBrownInnerEdgeSE = new Sprite(16, 3, 8, SpriteSheet.grasslands);
    public static Sprite grassBrownOuterEdgeNW = new Sprite(16, 4, 6, SpriteSheet.grasslands);
    public static Sprite grassBrownOuterEdgeSW = new Sprite(16, 4, 7, SpriteSheet.grasslands);
    public static Sprite grassBrownOuterEdgeNE = new Sprite(16, 5, 6, SpriteSheet.grasslands);
    public static Sprite grassBrownOuterEdgeSE = new Sprite(16, 5, 7, SpriteSheet.grasslands);

    //Walls
    public static Sprite grassWallStone1 = new Sprite(16, 6, 3, SpriteSheet.grasslands);
    public static Sprite grassWallStoneEntrance = new Sprite(16, 7, 3, SpriteSheet.grasslands);

    //Dirts
    //dirt light
    public static Sprite dirtLight1 = new Sprite(16, 6, 0, SpriteSheet.grasslands);
    public static Sprite dirtLight2 = new Sprite(16, 7, 0, SpriteSheet.grasslands);
    public static Sprite dirtLight3 = new Sprite(16, 8, 0, SpriteSheet.grasslands);

    //dirt medium
    public static Sprite dirtMedium1 = new Sprite(16, 6, 1, SpriteSheet.grasslands);
    public static Sprite dirtMedium2 = new Sprite(16, 7, 1, SpriteSheet.grasslands);
    public static Sprite dirtMedium3 = new Sprite(16, 8, 1, SpriteSheet.grasslands);

    //dirt dark
    public static Sprite dirtDark1 = new Sprite(16, 6, 2, SpriteSheet.grasslands);
    public static Sprite dirtDark2 = new Sprite(16, 7, 2, SpriteSheet.grasslands);
    public static Sprite dirtDark3 = new Sprite(16, 8, 2, SpriteSheet.grasslands);

    public Sprite(int size, int x, int y, SpriteSheet sheet) {
        this.SIZE = size;
        pixels = new int[SIZE*SIZE];
        this.x = x * SIZE;
        this.y = y * SIZE;
        this.sheet = sheet;
        load();
    }

    public Sprite(int size, int color){
         this.SIZE = size;
         pixels = new int[SIZE*SIZE];
         setColor(color);
    }

    private void setColor(int color){
        Arrays.fill(pixels, color);
    }

    private void load(){
        for(int y = 0; y < SIZE; y++){
            for(int x = 0; x<SIZE; x++){
                pixels[x+y*SIZE] = sheet.pixels[(x+this.x)+(y+this.y)*sheet.SIZE];
            }
        }
    }
}
