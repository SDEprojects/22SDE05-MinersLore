package org.minerslore.GameEntities.actors;

import java.io.IOException;

public interface Encounterable {

    default void encounter(Actor actor) throws IOException {

    }
}
