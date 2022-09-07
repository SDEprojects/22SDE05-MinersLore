package org.minerslore.Items;

import org.minerslore.Actors.Actor;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class CavePath extends Item {
    private int gold;
    private static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";

    private static final char SYMBOL = '.';
    private static final String MESSAGE = "Path walkable. This path can be mined.";

    public CavePath(Point position) {
        super(SYMBOL, position, true);
    }

    public static void interact(Actor actor) {
        int randomGoldKG = 0;
        double probability = Math.random();
        if (probability <= .25) {
            randomGoldKG = ThreadLocalRandom.current().nextInt(1, 11);
        }
        actor.setGoldKG(randomGoldKG);
    }


    @Override
    public String toString() {
        return ANSI_YELLOW + super.toString() + ANSI_RESET;
    }
}
