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

        public static ArrayList<Enemies> enemy;
        public static ArrayList<PlayerBullet> bullet;

    public GameCanvas(){
        this.background = new Background();
        this.player = new Player();
        this.enemy = new ArrayList<>();
        for(int i=0;i<10 ;i++){
            Enemies newEnemy = new Enemies();
            newEnemy.position= new Vector2D(Settings.Start_enemy_position_x,0);
            enemy.add(newEnemy);
        }
        bullet = new ArrayList<>();


            }
    public void run(){

        background.run();
        player.run();

        for(Enemies enemies : enemy){
            enemies.run();

        }
        for(PlayerBullet playerBullet: bullet){
            playerBullet.run();
        }


    }
    public void render(Graphics g){
        background.render(g);
        player.render(g);

        for(Enemies enemies : enemy){
            enemies.render(g);

        }
        for(PlayerBullet playerBullet: bullet){
            playerBullet.render(g);
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        this.render(g);

    }
}
