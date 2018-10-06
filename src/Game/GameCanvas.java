package Game;

import base.*;
import tklibs.SpriteUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameCanvas extends JPanel {
    Background background;
    Player player;
    Enemies enemy;
    public GameCanvas(){
        //this.background = new Background();
        this.background = GameObject.recycle(Background.class);
        this.player = GameObject.recycle(Player.class);

        this.enemy = GameObject.recycle(Enemies.class);
            }
    public void run(){

    GameObject.runAll(); //>> quan li chung

    }
    public void render(Graphics g){

      GameObject.renderAll(g); //quan li chung
    }

    @Override
    protected void paintComponent(Graphics g) {
        this.render(g);

    }
}
