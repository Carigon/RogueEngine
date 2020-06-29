package com.maong.roguebeginning.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

public class Keyboard implements KeyListener {

    private boolean[] keys = new boolean[120];
    public boolean up, down, left, right;
    public Map<String, int[]> keyboardMapping; //Hashmap containing key bindings
    public Map<Integer, Boolean> actions; //Hashmap containing state of all actions

    public Map<String, int[]> getKeyboardMapping() {
        return keyboardMapping;
    }

    public Keyboard() {
        super();
        keyboardMapping = generateDefaultKeyboardBindings();
    }

    public void update() {
        up = getKeyState("up");
        down = getKeyState("down");
        left = getKeyState("left");
        right = getKeyState("right");
        /*up = keys[keyboardMapping.get("up")[0]] || keys[keyboardMapping.get("up")[1]];
        down = keys[keyboardMapping.get("down")[0]] || keys[keyboardMapping.get("down")[1]];
        left = keys[keyboardMapping.get("left")[0]] || keys[keyboardMapping.get("left")[1]];
        right = keys[keyboardMapping.get("right")[0]] || keys[keyboardMapping.get("right")[1]];*/
    }

    private boolean getKeyState(String key) {
        boolean result = false;
        int[] potentials = keyboardMapping.get(key);
        for (int curr : potentials) {
            result = keys[curr] || result;
        }
        return result;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }

    public HashMap<String, int[]> generateDefaultKeyboardBindings() {
        HashMap<String, int[]> map = new HashMap<>();
        map.put("up", new int[]{KeyEvent.VK_UP, KeyEvent.VK_W});
        map.put("down", new int[]{KeyEvent.VK_DOWN, KeyEvent.VK_S});
        map.put("left", new int[]{KeyEvent.VK_LEFT, KeyEvent.VK_A});
        map.put("right", new int[]{KeyEvent.VK_RIGHT, KeyEvent.VK_D});

        return map;
    }

    /*public HashMap<Integer, Boolean> generateActionsMap(){
        HashMap<Integer, Boolean> map = new HashMap<>();

        return map;
    }*/
}
