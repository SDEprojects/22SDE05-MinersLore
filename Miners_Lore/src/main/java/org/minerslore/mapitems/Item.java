package org.minerslore.mapitems;

import org.minerslore.Actors.Actor;
import org.minerslore.GameEntity;

import java.awt.*;

public class Item extends GameEntity {
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
    public static void interact(Actor actor) {

    }
}
