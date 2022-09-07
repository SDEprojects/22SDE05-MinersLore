package org.minerslore;

import java.awt.*;

public abstract class Interact_Objects {
    private char current_symbol;
    private Point position;
    private Interact_Objects N;
    private Interact_Objects S;
    private Interact_Objects E;
    private Interact_Objects W;

    public Interact_Objects(char symbol, Point location) {
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

    public Interact_Objects getN() {
        return N;
    }

    public Interact_Objects getS() {
        return S;
    }

    public Interact_Objects getE() {
        return E;
    }

    public Interact_Objects getW() {
        return W;
    }

    public void setN(Interact_Objects n) {
        N = n;
    }

    public void setS(Interact_Objects s) {
        S = s;
    }


    public void setE(Interact_Objects e) {
        E = e;
    }

    public void setW(Interact_Objects w) {
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

    public Interact_Objects getByIndex(int x, int y) {
        Interact_Objects temp = S;
        while (temp.getY() != y) {
            temp = temp.S;
        }
        while (temp.getX() != x) {
            temp = temp.E;
        }
        return temp;
    }


}


