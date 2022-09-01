package org.minerslore.Actors;
import org.minerslore.Interact_Objects;

import java.awt.Point;
public class Actor extends Interact_Objects {
    public char symbol;
    public Point Position;
    int goldKG;

    char N='N';
    char S='N';
    char E='N';
    char W='N';

    public Actor(char symbol, Point location) {
        super(symbol, location);
        Position=location;
    }

    public void resetNeighbors(){
        this.N='N';
        this.S='N';
        this.E='N';
        this.W='N';
    }



    public void moveTo(int x ,int y){
        this.Position.setLocation(x,y);

    }

    public void moveNorth(){

        this.Position.setLocation(Position.x,Position.y-1);

    }
    public void moveSouth(){
        this.Position.setLocation(Position.x,Position.y+1);

    }

    public void moveEast(){
        this.Position.setLocation(Position.x+1,Position.y);

    }

    public void moveWest(){
        this.Position.setLocation(Position.x-1,Position.y);

    }

}
