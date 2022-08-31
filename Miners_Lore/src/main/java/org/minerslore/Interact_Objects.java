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

    public Point getPosition(){
        return this.position;
    };
    public void move(int x,int y){
        this.position.setLocation(x,y);


    }

    public void changeBlock(Interact_Objects block1,Interact_Objects block2,Interact_Objects block3){


    };





}
