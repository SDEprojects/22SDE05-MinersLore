package org.minerslore.GameEntities.mapitems;

import org.minerslore.GameEntities.actors.Actor;

import java.awt.*;

public class Boundary extends Item implements Interactable {
    private static final char SYMBOL = ' ';
    private static final String MESSAGE = "I can seem to pass through this terrain, better find another way.";

    public Boundary(Point position) {
        super(SYMBOL, position, false);
    }

    public void interact(Actor actor) {
        System.out.println(MESSAGE);
    }

    public final String inspect() {
        return MESSAGE;
    }

    @Override
    public String toString() {
        return String.valueOf(SYMBOL);
    }


}