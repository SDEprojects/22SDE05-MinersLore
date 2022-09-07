package org.minerslore.Items;

import org.minerslore.Actors.Actor;

import java.awt.*;

public class Wall extends Item {
    private static final char SYMBOL = '=';
    private static final String MESSAGE = "This is a rock wall, you can't move here.";

    public Wall(Point position) {

        super(SYMBOL, position, false);


    }

    public static void interact(Actor actor) {

        System.out.println(MESSAGE);
    }
}

// prev state dirt
// actor holds the tile they're on
// rock