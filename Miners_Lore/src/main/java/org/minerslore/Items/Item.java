package org.minerslore.Items;

import org.minerslore.Interact_Objects;

import java.awt.*;

public class Item extends Interact_Objects {
    private String Attributes;
    private boolean isPath;

    public Item(char symbol, Point location, boolean isPath) {


        super(symbol, location);
        this.isPath = isPath;
    }

    public boolean isPath() {
        return isPath;
    }

    public void setPath(boolean path) {
        isPath = path;
    }
}
