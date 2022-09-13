package org.minerslore.GameEntities;

import java.awt.*;

public abstract class GameEntity {

    private char current_symbol;
    private Point position;
    private GameEntity N;
    private GameEntity S;
    private GameEntity E;
    private GameEntity W;

    public GameEntity(char symbol, Point location) {
        this.current_symbol = symbol;
        this.position = location;
    }

    public final int getX() {
        return this.position.x;
    }

    ;

    public final int getY() {
        return this.position.y;
    }

    ;

    public final char getSymbol() {
        return this.current_symbol;
    }

    public final GameEntity getN() {
        return N;
    }

    public final GameEntity getS() {
        return S;
    }

    public final GameEntity getE() {
        return E;
    }

    public final GameEntity getW() {
        return W;
    }

    public final void setN(GameEntity n) {
        N = n;
    }

    public final void setS(GameEntity s) {
        S = s;
    }


    public final void setE(GameEntity e) {
        E = e;
    }

    public final void setW(GameEntity w) {
        W = w;
    }

    public final Point getPosition() {
        return position;
    }

    public final void setCurrent_symbol(char current_symbol) {
        this.current_symbol = current_symbol;
    }

    public final void setPosition(Point position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return String.valueOf(current_symbol) ;
    }

    public final GameEntity getByIndex(int x, int y) {
        GameEntity temp = this.S;
        while (temp.getY() != y) {
            temp = temp.S;
        }
        while (temp.getX() != x) {
            temp = temp.E;
        }
        return temp;
    }


}


