package org.minerslore.Actors;
import org.minerslore.Interact_Objects;

import java.awt.Point;
public class Actor extends Interact_Objects {
    public char symbol;
    public Point Position=new Point(0, 0);
    int goldKG;

    char N='N';
    char S='N';
    char E='N';
    char W='N';

    public Actor(char symbol, Point location) {
        super(symbol, location);
    }

    public void resetNeighbors(){
        this.N='N';
        this.S='N';
        this.E='N';
        this.W='N';
    }



    public void move(int x, int y){
        this.Position.setLocation(x,y);

    }



}
