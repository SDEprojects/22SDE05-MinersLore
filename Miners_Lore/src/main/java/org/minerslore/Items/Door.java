package org.minerslore.Items;

import java.awt.*;

public class Door extends Item {

    private static final char SYMBOL = '^';
    private static final String MESSAGE = "This is the path into the tunnel. Enter at your peril!";

    public Door(Point position) {
        super(SYMBOL, position, true);
    }

}
