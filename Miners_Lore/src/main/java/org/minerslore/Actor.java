package org.minerslore;
import java.awt.Point;
public class Actor {
    char symbol;
    Point Position=new Point(0, 0);
    int goldKG;

    char N='N';
    char S='N';
    char E='N';
    char W='N';

    public void resetNeighbors(){
        this.N='N';
        this.S='N';
        this.E='N';
        this.W='N';
    }

    public void move(int x,int y){
        this.Position.setLocation(x,y);

    }



}
