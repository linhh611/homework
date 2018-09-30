package base;

import base.Renderer.Renderer;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GameObject {
    public  Vector2D position;
    Renderer renderer;
    public GameObject(){

    }
    public GameObject(BufferedImage image){
        this.position = new Vector2D(0,0);

    }

    public void run(){

    }
    public void render(Graphics g){
        if(this.renderer !=null){
            this.renderer.render(g, this);
        }
    }
}
