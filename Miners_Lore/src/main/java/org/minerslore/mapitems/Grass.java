package org.minerslore.mapitems;

import org.minerslore.actors.Actor;

import java.awt.*;

public class Grass extends Item implements Interactable {
    public static final String TEXT_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    private static final char SYMBOL = ',';
    private static final String MESSAGE = "This lake is massive! I wonder what's on the other side.";

    public Grass(Point position) {
        super(SYMBOL, position, true);
    }

    public void interact(Actor actor) {

        System.out.println(MESSAGE);
    }

    @Override
    public String toString() {
        return TEXT_GREEN  + super.toString() + ANSI_RESET;
    }


}