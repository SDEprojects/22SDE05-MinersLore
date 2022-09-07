package org.minerslore.Items;

import java.awt.*;

public class Door extends Item {

    public static final char SYMBOL = '^';
    public static final String MESSAGE = "This is the path into the tunnel. Enter at your peril!";

    public Door(Point position) {
        super(SYMBOL, position, true);
    }

}
