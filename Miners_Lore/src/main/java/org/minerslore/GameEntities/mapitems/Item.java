package org.minerslore.GameEntities.mapitems;

import org.minerslore.GameEntities.GameEntity;
import org.minerslore.GameEntities.actors.Actor;

import java.awt.*;

public class Item extends GameEntity implements Interactable {
    private String Attributes;
    private boolean isPath;
    private static final String MESSAGE = "Over there is a walkable path.";

    public Item(char symbol, Point location, boolean isPath) {


        super(symbol, location);
        this.isPath = isPath;
    }

    public final boolean isPath() {
        return isPath;
    }


    public void interact(Actor actor) {

        System.out.println();
    }

    public String inspect() {
        return MESSAGE;
    }
}
