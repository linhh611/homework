package base;

import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class Player extends GameObject {
    public Player(){
        BufferedImage image= SpriteUtils.loadImage("assets/images/players/straight/0.png");
        this.image = image;
        this.x= 200;
        this.y= 300;
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
    }

    public void move(int a, int b){
        this.x +=a;
        this.y +=b;
    }
}
