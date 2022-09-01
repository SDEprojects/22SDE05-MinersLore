package org.minerslore.Items;
import org.minerslore.Actors.Actor;
import org.minerslore.Interact_Objects;
import java.awt.Point;

public class Wall extends Item {
    public static final char SYMBOL = '=';
    public static final String MESSAGE = "This is a rock wall, you can't move here.";

    public Wall(Point position) {
        super(SYMBOL, position);
    }

    public static void interact(Actor actor) {
        System.out.println(MESSAGE);
    }
}

// prev state dirt
// actor holds the tile they're on
// rock