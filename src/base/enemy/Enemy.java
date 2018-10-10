package base.enemy;

import base.*;
import base.action.*;
import base.physics.BoxCollider;
import base.physics.Physics;
import base.renderer.AnimationRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;


public class Enemy extends GameObject implements Physics {
    BoxCollider collider;
    Action action;

        public Enemy(){
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
            this.defineAction();
    }
    void defineAction() {
        ActionWait actionWait = new ActionWait(20);
        Action actionFire = new Action() {
            @Override
            public void run(GameObject master) {
                fire();
                this.isDone= true;
            }

            @Override
            public void reset() {
                this.isDone = false;
            }
        };
        Action actionMoveLeft = new Action() {
            @Override
            public void run(GameObject master) {
                if(position.x>0){
                    position.addThis(-19, 6);
                }
                    else{
                        position.addThis(19,-6);
                }

                this.isDone= true;
            }

            @Override
            public void reset() {
                this.isDone = false;
            }
        };

            ActionParallel actionParallel = new ActionParallel(actionMoveLeft, actionFire);

        ActionSequence actionSequence = new ActionSequence(actionWait,actionParallel);


        ActionRepeat actionRepeat = new ActionRepeat(actionSequence);
        this.action = actionRepeat;

    }



    @Override
    public void run() {

        this.action.run(this);
    }

    public void fire(){
            EnemyBullet bullet = GameObject.recycle(EnemyBullet.class);
            bullet.position.set(this.position.x, this.position.y+5);
    }
    @Override
    public BoxCollider getBoxCollider() {
        return this.collider;
    }
}
