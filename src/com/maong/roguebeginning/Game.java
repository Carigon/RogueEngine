package com.maong.roguebeginning;

import com.maong.roguebeginning.entity.mob.player.Player;
import com.maong.roguebeginning.graphics.Screen;
import com.maong.roguebeginning.input.Keyboard;
import com.maong.roguebeginning.level.Level;
import com.maong.roguebeginning.level.SpawnLevel;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

/*A Canvas component represents a blank rectangular area of the screen onto which the application
 can draw or from which the application can trap input events from the user.*/

public class Game extends Canvas implements Runnable {
    private static boolean isDebug = true;

    private static final long serialVersionUID = 1L;
    private static final String TITLE = "Rogue";

    //aspectWH holds the aspect ratio to calculate height.  default is 16 by 9.
    public static int[] aspectWH = {16, 9};
    public static int width = 300;
    public static int height = width / aspectWH[0] * aspectWH[1];

    public static int scale = 6;//scaling factor for the game (e.g. each pixel will be 3x3, or 9 pixels)
    private Thread gameThread;//main game thread
    private JFrame frame;//The JFrame is required as the foundation or base container for all other graphical components.
    private boolean running = false;//boolean tracking whether the game is running or not.
    private Screen screen;//Screen object that we manipulate for display
    private Keyboard key;//Keyboard object that handles input from the user.
    private Level level;//holds the current level to be rendered.
    private Player player;//holds the player object.

    //contains the actual image data to be displayed in the Frame/Canvas. Then sets the data buffer for the buffered image to point to pixels.
    private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

    public Game() {
        Dimension size = new Dimension(width * scale, height * scale);
        setPreferredSize(size);
        screen = new Screen(width, height);
        frame = new JFrame();
        key = new Keyboard();//initialize the keyboard and add the listener (awt component)
        level = new SpawnLevel("/textures/levels/testlevel.png");
        player = new Player(key, level.getWidth()*screen.tileSize /2, level.getHeight()*screen.tileSize /2);

        addKeyListener(key);
    }

    public synchronized void start() {
        running = true;
        gameThread = new Thread(this, "Display");
        gameThread.start();
    }

    public synchronized void stop() {
        running = false;
        try {
            gameThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        long lastTime = System.nanoTime();//Initialize lastTime as start time for thread.
        final double ns = 1e9d / 60d;//1e9d is the constant to convert nanoseconds to milliseconds.  60d is essentially guides how often update (game logic) will be run per second.
        double delta = 0;//delta tracks cumulative time since last update.

        //variable initialization for frame/update metrics
        int frames = 0; //for tracking frames FPS
        int updates = 0; //for tracking successful updates per second
        long timer = System.currentTimeMillis();//for tracking seconds for FPS counter.  diff between current time in MS and timer for timing a second.

        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                update();
                updates++;
                delta--;
            }
            render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                frame.setTitle(Game.TITLE + ": " + updates + " ups, " + frames + " fps");
                updates = 0;
                frames = 0;
            }
        }
        stop();
    }

    public void update() {
        key.update();
        player.update();
    }

    public void render() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }

        screen.clear();

        int xScroll = player.x - screen.getWidth()/2;
        int yScroll = player.y - screen.getHeight()/2;

        //renders each layer in turn
        level.render(xScroll, yScroll, screen);
        player.render(screen);

        //iterates through the size of the pixels array and sets the screen's pixels = to the same index in screen.pixels.
        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = screen.pixels[i];
        }

        //creates a new graphics object, sets the default background color, and then fills that.
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        //draws the image (bufferedImage) in the screen.  remember, data for image is backed by the pixels array you've already processed above.
        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);

        //for drawing debug information
        if(isDebug) {
            g.setColor(Color.WHITE);
            g.setFont(new Font("Verdana", 0, 50));
            g.drawString("Player - X: " + player.x + " Y: " + player.y, 0, 50);
            g.drawString("Player - dir: " + player.getDir(), 0, 100);
        }

        //dispose dumps the current graphical assets, freeing the memory.
        g.dispose();
        //show() pops the display buffer queue and displays.
        bs.show();
    }

    public static void main(String[] args) {
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
