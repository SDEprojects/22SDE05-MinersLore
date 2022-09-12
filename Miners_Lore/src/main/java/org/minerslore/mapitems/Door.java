package org.minerslore.mapitems;

import org.minerslore.actors.Actor;

import java.awt.*;

public class Door extends Item implements Interactable {
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";
    private static final char SYMBOL = 0x2592;
    private static final String MESSAGE = "This is the path into the tunnel. Enter at your peril!";

    public Door(Point position) {
        super(SYMBOL, position, true);
    }
    @Override
    public String toString() {
        return ANSI_CYAN_BACKGROUND + super.toString() + ANSI_RESET;
    }
    public void interact(Actor actor) {

        System.out.println();
    }

}
