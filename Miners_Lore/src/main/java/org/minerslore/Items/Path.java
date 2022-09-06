package org.minerslore.Items;
import org.minerslore.Actors.Actor;
import java.awt.Point;

public class Path extends Item {
    public static final char SYMBOL = ' ';
    public static final String MESSAGE = "Path walkable and can dig";

    public Path(Point position) {
        super(SYMBOL, position, true );
    }

    public static void interact(Actor actor) {
        System.out.println(MESSAGE);
    }
}
