package org.minerslore.GameEntities.mapitems;

import org.minerslore.GameEntities.actors.Actor;

import java.awt.*;

public class Jewel extends Item implements Interactable {
    private static final char SYMBOL = '+';
    private static final String MESSAGE = "A priceless jewel!";

    public Jewel(Point position) {

        super(SYMBOL, position, true);
    }

    public final void interact(Actor actor) {

        System.out.println(MESSAGE);
    }

    public final String inspect() {
        return MESSAGE;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
