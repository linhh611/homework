package base.Renderer;

import base.Counter.FrameCounter;
import base.GameObject;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class AnimationRenderer extends Renderer {
    ArrayList<BufferedImage> images;
    int currentImage = 0;
    FrameCounter frameCounter;

    public AnimationRenderer (ArrayList<BufferedImage> image){

        this.images = image;
        this.frameCounter = new FrameCounter(5);
    }
    public AnimationRenderer(ArrayList<BufferedImage> images, int frameCount){
        this.images = images;
        this.frameCounter = new FrameCounter(frameCount);
    }

    @Override
    public void render(Graphics g, GameObject master) {
        if(images.size()>0){
            g.drawImage(images.get(currentImage), (int)master.position.x, (int) master.position.y, null);

            if(this.frameCounter.run()){
                currentImage++;
                if(currentImage >= images.size()-1){
                    currentImage =0;
                }
                this.frameCounter.reset();
            }


        }
    }
}
