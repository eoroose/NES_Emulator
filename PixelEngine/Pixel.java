package PixelEngine;

import java.awt.*;

public class Pixel {
    private final int x, y, realX, realY;
    private Color color;

    public Pixel(int x, int y, int realX, int realY, Color color) {
        this.x = x;
        this.y = y;
        this.realX = realX;
        this.realY = realY;
        this.color = color;
    }

    public  Pixel(int x, int y, int realX, int realY, int r, int g, int b) {
        this(x, y, realX, realY, new Color(r, g, b));
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    protected int getRealX() {
        return realX;
    }

    protected int getRealY() {
        return realY;
    }

    public Color getColor() {
        return color;
    }

    public  void setColor(Color color) {
        this.color = color;
    }
}