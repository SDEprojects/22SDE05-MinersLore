package org.minerslore;

import org.minerslore.actors.Actor;

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

    public int getX() {
        return this.position.x;
    }

    ;

    public int getY() {
        return this.position.y;
    }

    ;

    public char getSymbol() {
        return this.current_symbol;
    }

    public GameEntity getN() {
        return N;
    }

    public GameEntity getS() {
        return S;
    }

    public GameEntity getE() {
        return E;
    }

    public GameEntity getW() {
        return W;
    }

    public void setN(GameEntity n) {
        N = n;
    }

    public void setS(GameEntity s) {
        S = s;
    }


    public void setE(GameEntity e) {
        E = e;
    }

    public void setW(GameEntity w) {
        W = w;
    }

    public Point getPosition() {
        return position;
    }

    public void setCurrent_symbol(char current_symbol) {
        this.current_symbol = current_symbol;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return String.valueOf(current_symbol);
    }

    public GameEntity getByIndex(int x, int y) {
        GameEntity temp = S;
        while (temp.getY() != y) {
            temp = temp.S;
        }
        while (temp.getX() != x) {
            temp = temp.E;
        }
        return temp;
    }




}


