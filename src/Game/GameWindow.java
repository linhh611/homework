package Game;

import base.KeyEventPress;
import base.Settings;
import tklibs.SpriteUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class GameWindow extends JFrame {
    GameCanvas canvas;

    public GameWindow(){
        //setup

        this.setSize(Settings.screen_width, Settings.screen_height);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setupEventListener();
        //init game
        canvas = new GameCanvas();
        this.add(canvas);
        this.setVisible(true);
    }

    private void setupEventListener() {
        this.addKeyListener(new KeyAdapter() {


            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_W ){
                    KeyEventPress.isUpPress = true;
                }
                else if(e.getKeyCode()==KeyEvent.VK_S){
                    KeyEventPress.isDownPress = true;
                }
                else if(e.getKeyCode()==KeyEvent.VK_A){
                    KeyEventPress.isLeftPress = true;
                }
                else if(e.getKeyCode()==KeyEvent.VK_D){
                    KeyEventPress.isRightPress = true;
                }
                if(e.getKeyCode()==KeyEvent.VK_SPACE){
                    KeyEventPress.isShoot = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_W){
                    KeyEventPress.isUpPress = false;
                }
                else if(e.getKeyCode()==KeyEvent.VK_S){
                    KeyEventPress.isDownPress = false;
                }
                else if(e.getKeyCode()==KeyEvent.VK_A){
                    KeyEventPress.isLeftPress = false;
                }
                else if(e.getKeyCode()==KeyEvent.VK_D){
                    KeyEventPress.isRightPress = false;
                }
                if(e.getKeyCode()==KeyEvent.VK_SPACE){
                    KeyEventPress.isShoot= false;
                }
            }

        });

    }

    public void gameLoop(){
        long delay = 1000/60;
        long lastTime = 0;
        while(true){
            long currentTime = System.currentTimeMillis();
            if(currentTime- lastTime > delay){
                canvas.run();

                this.repaint();
                lastTime = currentTime;
            }

        }
    }


}
