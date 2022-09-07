package org.minerslore.Items;

import org.minerslore.Actors.Actor;

import java.awt.*;

//\u001B[32m	GREEN_BACKGROUND	\u001B[42m #F3FEED
public class Path extends Item {

    private static final char SYMBOL = ' ';
    private static final String MESSAGE = "Path walkable";

    public Path(Point position) {

        super(SYMBOL, position, true);
    }

    public static void interact(Actor actor) {

        System.out.println(MESSAGE);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
