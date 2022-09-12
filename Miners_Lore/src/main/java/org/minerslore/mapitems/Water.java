package org.minerslore.mapitems;

import org.minerslore.actors.Actor;

import java.awt.*;

public class Water extends Item implements Interactable {
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_RESET = "\u001B[0m";
    private static final char SYMBOL = 0x2591;
    private static final String MESSAGE = "This lake is massive! I wonder what's on the other side.";

    public Water(Point position) {
        super(SYMBOL, position, false);
    }
    public void interact(Actor actor) {
        System.out.println(MESSAGE);
    }

    @Override
    public String toString() {
        return ANSI_CYAN_BACKGROUND + super.toString() + ANSI_RESET;
    }



}