package org.minerslore.Items;

import org.minerslore.Interact_Objects;

import java.awt.*;

public class Item extends Interact_Objects {
    int[] Location;
    String Attributes;

    public Item(char symbol, Point location) {


        super(symbol, location);
    }
}
