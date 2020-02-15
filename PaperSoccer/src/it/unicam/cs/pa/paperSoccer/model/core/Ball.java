package it.unicam.cs.pa.paperSoccer.model.core;

public class Ball {

    private int y;
    private int x;


    public Ball(int y, int x) {
        this.x = x;
        this.y = y;
    }


    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

}
