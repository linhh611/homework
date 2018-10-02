package base;

import java.util.Vector;

public class Vector2D {
    public float x;
    public float y;
    public Vector2D(){
        this.x=0;
        this.y=0;

    }
    public Vector2D(float x, float y){
        this.x=x;
        this.y=y;
    }
    /*
    *Return an other vector with x,y
     */
    public Vector2D clone(){
        Vector2D result = new Vector2D(this.x, this.y);
        return result;
    }
    /*
    *return new vector = old Vector + x, y;
     */
    public Vector2D add(float x, float y){
        Vector2D result = new Vector2D(this.x,this.y);
        result.x +=x;
        result.y +=y;
        return result;
    }

    public Vector2D addThis(float x, float y){
        this.x += x;
        this.y += y;
        return this;
    }
    public Vector2D subtract(float x, float y){
        Vector2D result = new Vector2D(this.x, this.y);
        result.x -=x;
        result.y -=y;
        return result;
    }
    public Vector2D scale(float x, float y){
        return  new Vector2D(this.x*x, this.y*y);

    }
    public Vector2D subtractThis(float x, float y){
        this.x -= x;
        this.y -= y;
        return this;
    }
    public Vector2D scaleThis(float x, float y){

        this.x -=x;
        this.y -=y;
        return this;
    }
    public Vector2D set(float x, float y){
        this.x = x;
        this.y = y;
        return this;
    }
    /**
     *
     * @param x
     * @param y
     * @return pitago
     */
    public float length(float x, float y){
        return (float) Math.sqrt(x*x+y*y);
    }
    public void print(){
        System.out.println(x+", "+y);

    }

    public static void main(String[] args) {
        Vector2D vt = new Vector2D(10, 10);
        vt.print();
        Vector2D result2 = new Vector2D(5,5);
        result2.print();
    }

}
