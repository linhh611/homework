package game;

import base.*;
import base.enemy.Enemy;
import base.player.Player;

import javax.swing.*;
import java.awt.*;

public class GameCanvas extends JPanel {
    Background background;
    Player player;
    public GameCanvas(){
        //this.background = new Background();
        this.background = GameObject.recycle(Background.class);
        this.player = GameObject.recycle(Player.class);
        Enemy enemy = GameObject.create(Enemy.class);

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
