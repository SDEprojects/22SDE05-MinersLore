package org.minerslore.mapitems;

import org.minerslore.actors.Actor;

import java.awt.*;

//\u001B[32m	GREEN_BACKGROUND	\u001B[42m #F3FEED
public class Jewel extends Item implements Interactable  {

    private static final char SYMBOL = '+';
    private static final String MESSAGE = "A priceless jewel!";

    public Jewel(Point position) {

        super(SYMBOL, position, true);
    }

    public void interact(Actor actor) {

        System.out.println(MESSAGE);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
