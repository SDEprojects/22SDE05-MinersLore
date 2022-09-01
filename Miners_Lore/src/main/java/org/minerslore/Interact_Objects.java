package org.minerslore;
import java.awt.Point;

public abstract class Interact_Objects {
    char original_symbol;
    char current_symbol;
    Point position;

    public Interact_Objects(char symbol, Point location) {
        this.current_symbol = symbol;
        this.original_symbol = symbol;
        this.position = location;
    }

    public int getX(){
        return this.position.x;
    };
    public int getY(){
        return this.position.y;
    };
    public void move(int x,int y){
        this.position.setLocation(x,y);
    }

    public Interact_Objects changeBlock(Interact_Objects actionBlock){
        return this;


    };

    public char getSymbol() {

        return this.current_symbol;
    }

    @Override
    public String toString() {
        return String.valueOf( current_symbol);
    }
}
