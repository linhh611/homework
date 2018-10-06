package base;

import base.Renderer.AnimationRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class EnemyBullet extends GameObject  implements  Physics{
    Vector2D velocity;
    BoxCollider collider;
    public EnemyBullet(){
        super ();
        ArrayList<BufferedImage> images = SpriteUtils.loadImages(
                "assets/images/enemies/bullets/blue.png"

        );
        this.renderer = new AnimationRenderer(images);
        this.position = new Vector2D(0,0);
        this.velocity = new Vector2D( 0,0);
        this.collider = new BoxCollider(16,16);

    }

    @Override
    public void run() {
        Player player = GameObject.intersect(Player.class, this);
        if(player!= null){
            player.destroy();
            this.destroy();
            return;

        }
        this.position.addThis(velocity.x, velocity.y);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.collider;
    }
}
