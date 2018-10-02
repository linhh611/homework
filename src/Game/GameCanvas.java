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

 //       public static ArrayList<Enemies> enemy;
 //       public static ArrayList<PlayerBullet> playerBullets;

    public GameCanvas(){
        //this.background = new Background();
        this.background = GameObject.create(Background.class);
        this.player = GameObject.create(Player.class);
 //       enemy = new ArrayList<>();
 //       playerBullets = new ArrayList<>();
        //enemies
        Enemies  enemy = GameObject.create(Enemies.class);
            }
    public void run(){
/*
        background.run();
        player.run();

        for(Enemies enemies : enemy){
            enemies.run();

        }
        for(PlayerBullet playerBullet: playerBullets){
            playerBullet.run();
        }
*/
    GameObject.runAll(); //>> quan li chung

    }
    public void render(Graphics g){
      /*  background.render(g);
        player.render(g);

        for(Enemies enemies : enemy){
            enemies.render(g);

        }
        for(PlayerBullet playerBullet: playerBullets){
            playerBullet.render(g);
        }
*/
      GameObject.renderAll(g); //quan li chung
    }

    @Override
    protected void paintComponent(Graphics g) {
        this.render(g);

    }
}
