package base.Renderer;

import base.GameObject;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class AnimationRenderer extends Renderer {
    ArrayList<BufferedImage> image;
    int currentImage = 0;

    public AnimationRenderer (ArrayList<BufferedImage> image){
        this.image = image;
    }
    int frameCount =0;

    @Override
    public void render(Graphics g, GameObject master) {
        if(image.size()>0){
            g.drawImage(image.get(currentImage), (int)master.position.x, (int) master.position.y, null);

            if(frameCount>5){
                currentImage++;
                if(currentImage >= image.size()-1){
                    currentImage =0;
                }
                frameCount=0;
            }else frameCount++;


        }
    }
}
