package base;

import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.nio.Buffer;

public class Background extends GameObject{
    public Background( ){
        BufferedImage image = SpriteUtils.loadImage("assets/images/background/0.png");
        this.image = image;
        this.x = 0;
        this.y = 0;
    }
    @Override
    public void run() {
        if (this.y >= -image.getHeight()+ 600 ) {
            this.y -=50;
        }
    }




}
