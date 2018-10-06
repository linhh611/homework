package base;

import base.Counter.FrameCounter;
import base.Renderer.AnimationRenderer;
import tklibs.SpriteUtils;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Enemies extends GameObject implements  Physics{
    BoxCollider collider;
    FrameCounter fireCounter;

        public Enemies(){
            super();

            ArrayList<BufferedImage> images = SpriteUtils.loadImages(
                    "assets/images/enemies/level0/pink/0.png",
                    "assets/images/enemies/level0/pink/1.png",
                    "assets/images/enemies/level0/pink/2.png",
                    "assets/images/enemies/level0/pink/3.png"
            );
            this.renderer = new AnimationRenderer(images);
            this.position = new Vector2D(200,100);
            this.collider = new BoxCollider(28,28);
            this.fireCounter = new FrameCounter(70);
    }

    @Override
    public void run() {

        this.shoot();

    }

    public void shoot(){
            if(this.fireCounter.run()){
                EnemyBullet bullet = GameObject.recycle(EnemyBullet.class);

                bullet.velocity.set(0,3);
                bullet.position.set(this.position.x, this.position.y);
                this.fireCounter.reset();
            }
    }
    @Override
    public BoxCollider getBoxCollider() {
        return this.collider;
    }
}
