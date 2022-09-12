package org.minerslore.GameEntities.mapitems;

import org.minerslore.GameEntities.actors.Actor;

import java.awt.*;

public class Door extends Item implements Interactable {
    private static final String ANSI_CYAN_BACKGROUND = "\u001B[34m";
    private static final String ANSI_RESET = "\u001B[0m";
    private static final char SYMBOL = 0x2592;
    private static final String MESSAGE = "This is the door, I wonder if it is unlocked.";

    public Door(Point position) {
        super(SYMBOL, position, true);
    }

    public void interact(Actor actor) {

        System.out.println();
    }

    public final String inspect() {
        return MESSAGE;
    }

    @Override
    public String toString() {
        return ANSI_CYAN_BACKGROUND + super.toString() + ANSI_RESET;
    }

}
