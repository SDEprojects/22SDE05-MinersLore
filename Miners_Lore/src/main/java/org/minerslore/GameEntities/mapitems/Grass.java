package org.minerslore.GameEntities.mapitems;

import org.minerslore.GameEntities.actors.Actor;

import java.awt.*;

public class Grass extends Item implements Interactable {

    private static final String TEXT_GREEN = "\u001B[32m";

    private static final String ANSI_RESET = "\u001B[0m";
    private static final char SYMBOL = ',';
    private static final String MESSAGE = "This looks to be a grassy area that is walkable.";

    public Grass(Point position) {
        super(SYMBOL, position, true);
    }

    public void interact(Actor actor) {

        System.out.println(MESSAGE);
    }

    public final String inspect() {
        return MESSAGE;
    }

    @Override
    public String toString() {
        return TEXT_GREEN + super.toString() + ANSI_RESET;
    }


}