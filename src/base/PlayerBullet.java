package base;

import base.Renderer.AnimationRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class PlayerBullet extends GameObject {
    public PlayerBullet(){
        ArrayList<BufferedImage> images= new ArrayList<>();
        images.add(SpriteUtils.loadImage("assets/images/player-bullets/a/0.png"));
        images.add(SpriteUtils.loadImage("assets/images/player-bullets/a/1.png"));
        images.add(SpriteUtils.loadImage("assets/images/player-bullets/a/2.png"));
        images.add(SpriteUtils.loadImage("assets/images/player-bullets/a/3.png"));
        this.renderer = new AnimationRenderer(images);
        this.position= new Vector2D(Settings.start_player_position_x, Settings.start_player_positioin_y);
    }

    public void move(int translateX, int translateY) {
        this.position.addThis(translateX, translateY);
    }

    @Override
    public void run() {
        this.move(0, -10);
    }
}
