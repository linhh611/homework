package base;

public class BoxCollider {
    public int width;
    public int height;

     public BoxCollider(int width, int height){
         this.width= width;
         this.height= height;
     }
    public int top(GameObject master){
         return (int) master.position.y;
    }

    public int bot(GameObject master){
         return (int) (master.position.y+this.height);

    }
    public int left(GameObject master){
         return (int) master.position.x;

    }
    public int right(GameObject master){
         return (int) (master.position.x+ this.width);
    }
     public boolean intersect(Physics other, GameObject master){
         //om = otherMaster
         // ob = otherBoxCollider
        GameObject om = (GameObject)other;
        BoxCollider ob = other.getBoxCollider();

        boolean yIntersect = (this.top(master) >= ob.top(om) && this.top(master) < ob.bot(om))
                || (this.bot(master)>= ob.top(om) &&this.bot(master)<ob.bot(om));
        boolean xIntersect = (this.right(master)>= ob.left(om)&& this.right(master)<ob.right(om))
                || (this.left(master)>= ob.left(om) && this.left(master)<ob.right(om));

        return yIntersect && xIntersect;



     }

    public static void main(String[] args) {
        PlayerBullet b1 = new PlayerBullet();
        PlayerBullet b2 = new PlayerBullet();
        PlayerBullet b3 = new PlayerBullet();
        b1.collider = new BoxCollider(5,5);
        b2.collider = new BoxCollider(5,5);
        b3.collider = new BoxCollider(5,5);

        b1.position.set(5,5);
        b2.position.set(8,8);
        b3.position.set(11,5);

        System.out.println(b1.collider.intersect(b2,b1)); //true
        System.out.println(b2.collider.intersect(b3,b2)); //true
        System.out.println(b1.collider.intersect(b3,b1)); //false
    }


}
