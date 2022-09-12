package org.minerslore.GameEntities.mapitems;

import org.minerslore.GameEntities.actors.Actor;

import java.awt.*;

public class Water extends Item implements Interactable {
    private static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    private static final String ANSI_RESET = "\u001B[0m";
    private static final char SYMBOL = 0x2591;
    private static final String MESSAGE = "This lake is massive! I wonder what's on the other side.";

    public Water(Point position) {
        super(SYMBOL, position, false);
    }

    public final void interact(Actor actor) {
        System.out.println(MESSAGE);

    }

    public final String inspect() {
        return MESSAGE;
    }

    @Override
    public String toString() {

        return ANSI_CYAN_BACKGROUND + super.toString() + ANSI_RESET;
    }


}