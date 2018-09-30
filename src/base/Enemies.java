package base;

import base.Renderer.AnimationRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Enemies extends GameObject {
        public Enemies(){
            ArrayList<BufferedImage> image= new ArrayList<>();
            image.add(SpriteUtils.loadImage("assets/images/enemies/level0/black/0.png"));
            image.add(SpriteUtils.loadImage("assets/images/enemies/level0/black/1.png"));
            image.add(SpriteUtils.loadImage("assets/images/enemies/level0/black/2.png"));
            image.add(SpriteUtils.loadImage("assets/images/enemies/level0/black/4.png"));
            image.add(SpriteUtils.loadImage("assets/images/enemies/level0/black/5.png"));
            image.add(SpriteUtils.loadImage("assets/images/enemies/level0/black/6.png"));
            image.add(SpriteUtils.loadImage("assets/images/enemies/level0/black/7.png"));
            image.add(SpriteUtils.loadImage("assets/images/enemies/level0/black/8.png"));
            this.renderer = new AnimationRenderer(image);
            this.position = new Vector2D();

    }

    @Override
    public void run() {
        this.position.y++;
    }
}
