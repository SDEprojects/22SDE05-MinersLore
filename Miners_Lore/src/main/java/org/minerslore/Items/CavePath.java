package org.minerslore.Items;
import org.minerslore.Actors.Actor;
import java.awt.Point;
import java.io.*;
public class CavePath extends Item {
    int gold;
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static final char SYMBOL = '.';
    public static final String MESSAGE = "Path walkable. This path can be mined.";
    public CavePath(Point position) {
        super(SYMBOL, position, true );
    }

    public static void interact(Actor actor) {
        System.out.println(MESSAGE);
    }


    @Override
    public String toString() {
        return ANSI_YELLOW + super.toString() + ANSI_RESET;
    }
}
