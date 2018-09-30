package base;

import Game.GameCanvas;
import base.Renderer.AnimationRenderer;
import base.Renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.lang.management.BufferPoolMXBean;
import java.util.ArrayList;

public class Player extends GameObject {
    PlayerBullet bullets;

    public Player(){
        ArrayList<BufferedImage> images = new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/players/straight/0.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/1.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/2.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/3.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/4.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/5.png"));
        images.add(SpriteUtils.loadImage("assets/images/players/straight/6.png"));
        this.renderer = new AnimationRenderer(images);
        this.position = new Vector2D(Settings.start_player_position_x, Settings.start_player_positioin_y);
        this.bullets = new PlayerBullet();
    }

    @Override
    public void run() {
        if(KeyEventPress.isUpPress){
            this.move(0,-1);
        }
        else if(KeyEventPress.isDownPress){
            this.move(0,1);
        }
        else if(KeyEventPress.isRightPress){
            this.move(1,0);
        }
        else if(KeyEventPress.isLeftPress){
            this.move(-1,0);
        }
        if(KeyEventPress.isShoot){
            this.shoot();
        }
    }

    public void shoot(){
        PlayerBullet bullets = new PlayerBullet();
        bullets.position.x = this.position.x;
        bullets.position.y= this.position.y;
        GameCanvas.bullet.add(bullets);
    }

    public void move(int a, int b){
        this.position.addThis(a,b);


    }
}
