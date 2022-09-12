package org.minerslore.GameEntities.mapitems;

import org.minerslore.GameEntities.actors.Actor;


public interface Interactable {


    default void interact(Actor actor) {

    }

    default String inspect() {
        return "";
    }
}
