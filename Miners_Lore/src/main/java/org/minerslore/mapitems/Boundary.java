package org.minerslore.mapitems;

import org.minerslore.Actors.Actor;

import java.awt.*;

public class Boundary extends Item {
    private static final char SYMBOL = ' ';
    private static final String MESSAGE = "You can't walk here";

    public Boundary(Point position) {
        super(SYMBOL, position, false);
    }

    public static void interact (Actor actor) {
        System.out.println(MESSAGE);
    }

    @Override
    public String toString() {
        return String.valueOf(SYMBOL);
    }

}