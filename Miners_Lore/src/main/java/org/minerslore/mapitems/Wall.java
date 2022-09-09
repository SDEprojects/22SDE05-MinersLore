package org.minerslore.mapitems;

import org.minerslore.Actors.Actor;

import java.awt.*;

public class Wall extends Item {
    private static final char SYMBOL = 0x2593;
    private static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";
    private static final String MESSAGE = "This is a rock wall, you can't move here.";

    public Wall(Point position) {
        super(SYMBOL, position, false);
    }

    public static void interact(Actor actor) {

        System.out.println(MESSAGE);
    }

    @Override
    public String toString() {
        return ANSI_YELLOW + super.toString() + ANSI_RESET;
    }


}

// prev state dirt
// actor holds the tile they're on
// rock