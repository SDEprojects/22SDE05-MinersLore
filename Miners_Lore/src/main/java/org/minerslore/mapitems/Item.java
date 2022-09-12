package org.minerslore.mapitems;

import org.minerslore.actors.Actor;
import org.minerslore.GameEntity;

import java.awt.*;

public class Item extends GameEntity implements Interactable {
    private String Attributes;
    private boolean isPath;

    public Item(char symbol, Point location, boolean isPath) {


        super(symbol, location);
        this.isPath = isPath;
    }

    public boolean isPath() {
        return isPath;
    }

    public void setPath(boolean path) {
        isPath = path;
    }



    public void interact(Actor actor) {

        System.out.println();
    }
}
