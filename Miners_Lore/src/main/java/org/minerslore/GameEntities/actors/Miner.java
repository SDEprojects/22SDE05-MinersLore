package org.minerslore.GameEntities.actors;

import java.awt.*;

public class Miner extends Actor implements Encounterable {
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_RESET = "\u001B[0m";
    private static char SYMBOL = 0x00A3;
    private static final String MESSAGE = "Gold stealing creature of lore.";

    public Miner(char symbol, Point location) {
        super(SYMBOL, location);
    }


    public void encounter(Actor actor) {

    }

    @Override
    public String toString() {

        return ANSI_BLUE + super.toString() + ANSI_RESET;
    }


}
