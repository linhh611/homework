package base;

import Game.GameCanvas;
import base.Counter.FrameCounter;
import base.Renderer.AnimationRenderer;
import base.Renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.lang.management.BufferPoolMXBean;
import java.util.ArrayList;

public class Player extends GameObject {
    FrameCounter fireCounter;

    public Player(){
        ArrayList<BufferedImage> images =  SpriteUtils.loadImages(
                "assets/images/players/straight/0.png",
                "assets/images/players/straight/1.png",
                "assets/images/players/straight/2.png",
                "assets/images/players/straight/3.png",
                "assets/images/players/straight/4.png",
                "assets/images/players/straight/5.png",
                "assets/images/players/straight/6.png"
                );
        this.renderer = new AnimationRenderer(images);
        this.position = new Vector2D(Settings.start_player_position_x, Settings.start_player_positioin_y);
        this.fireCounter = new FrameCounter(10);
    }

    @Override
    public void run() {
        if(KeyEventPress.isUpPress){
            this.move(0,-1);
        }
        if(KeyEventPress.isDownPress){
            this.move(0,1);
        }
        if(KeyEventPress.isRightPress){
            this.move(1,0);
        }
        if(KeyEventPress.isLeftPress){
            this.move(-1,0);
        }
        boolean fireCounterRun = this.fireCounter.run();
        if(KeyEventPress.isFirePress && fireCounterRun){
       // if(KeyEventPress.isFirePress){
            this.fire();
        }
    }

    public void fire(){
        if (this.fireCounter.run()) {
      //      PlayerBullet bullets = new PlayerBullet();
       //     GameCanvas.playerBullets.add(bullets);
            PlayerBullet bullets = GameObject.create(PlayerBullet.class);
            PlayerBullet2 bullet2 = GameObject.create(PlayerBullet2.class);
            PlayerBullet3 bullet3 = GameObject.create(PlayerBullet3.class);

            bullets.position.set(this.position.x, this.position.y);
            bullet2.position.set(this.position.x, this.position.y);
            bullet3.position.set(this.position.x, this.position.y);
            this.fireCounter.reset();
        }


    }

    public void move(int a, int b){
        this.position.addThis(a,b);


    }
}
