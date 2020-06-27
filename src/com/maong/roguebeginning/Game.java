package com.maong.roguebeginning;

import com.maong.roguebeginning.graphics.Screen;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

/*A Canvas component represents a blank rectangular area of the screen onto which the application
 can draw or from which the application can trap input events from the user.*/

public class Game extends Canvas implements Runnable{
    private static final long serialVersionUID = 1L;
    private static final String TITLE = "Rogue";

    //aspectWH holds the aspect ratio to calculate height.  default is 16 by 9.
    public static int[] aspectWH = {16,9};
    public static int width = 300;
    public static int height = width / aspectWH[0] * aspectWH[1];
    //scaling factor for the game (e.g. each pixel will be 3x3, or 9 pixels)
    public static int scale = 6;



    //main game thread
    private Thread gameThread;

    //The JFrame is required as the foundation or base container for all other graphical components.
    private JFrame frame;

    //boolean tracking whether the game is running or not.
    private boolean running = false;

    //Screen object that we manipulate for display
    private Screen screen;

    //contains the actual image data to be displayed in the Frame/Canvas.
    private BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
    private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();

    public Game(){
        Dimension size = new Dimension(width*scale, height*scale);
        setPreferredSize(size);
        screen = new Screen(width,height);

        frame = new JFrame();
    }

    public synchronized void start(){
        running = true;
        gameThread = new Thread(this, "Display");
        gameThread.start();
    }

    public synchronized void stop(){
        running = false;
        try {
            gameThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run(){
        //setting time related variables.  Initialize lastTime as start time for thread, ns->ms conversion factor etc.
        long lastTime = System.nanoTime();
        //1e9d is the constant to convert nanoseconds to milliseconds.  60d is essentially guides how often update will be run per second.
        final double ns = 1e9d / 60d;
        double delta = 0;

        //variable initialization for frame/update metrics
        int frames = 0; //for tracking frames FPS
        int updates = 0; //for tracking successful updates per second
        long timer = System.currentTimeMillis();

        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1){
                update();
                updates++;
                delta--;
            }
            render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000){
                timer+=1000;
                frame.setTitle(Game.TITLE + ": " + updates + " ups, " + frames + " fps");
                updates = 0;
                frames = 0;
            }
        }
        stop();
    }

    public void update(){

    }

    public void render(){
        BufferStrategy bs = getBufferStrategy();
        if(bs == null){
            createBufferStrategy(3);
            return;
        }

        screen.clear();
        screen.render();
        for(int i = 0; i<pixels.length; i++){
            pixels[i] = screen.pixels[i];
        }

        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);

        //dispose dumps the current graphical assets, freeing the memory.
        g.dispose();
        //show() pops the display buffer queue and displays.
        bs.show();
    }

    public static void main(String[] args){
        Game game = new Game();
        game.frame.setResizable(false);
        game.frame.setTitle(Game.TITLE);
        game.frame.add(game);
        game.frame.pack();
        game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.frame.setLocationRelativeTo(null);
        game.frame.setVisible(true);

        game.start();
    }
}
