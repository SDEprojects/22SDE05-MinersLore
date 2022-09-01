package org.minerslore.Items;
import org.minerslore.Interact_Objects;
import java.awt.Point;

public class Wall extends Interact_Objects{
    public static final char SYMBOL = '=';
    public Point position;
    public static final String MESSAGE = "This is a rock wall, you can't move here.";

    public Wall(Point position) {
        super(SYMBOL, position);
    }
}

// prev state dirt
// actor
// rock