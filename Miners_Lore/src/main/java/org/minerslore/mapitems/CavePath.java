package org.minerslore.mapitems;

import org.minerslore.Actors.Actor;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class CavePath extends Item {
    private int gold;
    private boolean isDug;
    private static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";

    private static final char SYMBOL = '.';
    private static final String MESSAGE = "Path walkable. This path can be mined.";

    public CavePath(Point position, boolean isDug) {
        super(SYMBOL, position, true);
        this.isDug = isDug;
    }

    public static void interact(Actor actor) {
        System.out.println("got here");
        Item block = (Item) actor.getOn_Block();
        CavePath tile = (CavePath) block;
        if (tile.getIsDug() == false) {
            System.out.println("tile " + tile.getPosition());
            tile.setIsDug();
            int randomGoldKG = 0;
            double probability = Math.random();
            if (probability <= .25) {
                randomGoldKG = ThreadLocalRandom.current().nextInt(1, 11);
                actor.setGoldKG(randomGoldKG);
                System.out.println("Congrats, you found " + randomGoldKG + "KG of gold!");
                if (actor.getGoldKG() > randomGoldKG) {
                    System.out.println("So far, you have have collected " + actor.getGoldKG() + "KG!");
                }
            } else {
                System.out.println("No gold here. Keep it moving, miner!");
            }
        } else if (tile.getIsDug() == true) {
            System.out.println("tile " + tile.getPosition());
            System.out.println("You've already dug here. Keep it moving, miner!");
        }
    }

    public void setIsDug(){
        this.isDug = true;
    };

    public boolean getIsDug(){
        return isDug;
    }

    @Override
    public String toString() {
        return ANSI_YELLOW + super.toString() + ANSI_RESET;
    }
}
