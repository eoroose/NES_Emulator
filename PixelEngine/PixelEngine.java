package PixelEngine;

import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;


public class PixelEngine {

    private final int width, height;
    private final Pixel[] pixels;
    private final float[] RGBs;
    private final ArrayList<Pixel[]> pixelUpdate;

    public PixelEngine(int width, int height) {
        this.width = width;
        this.height = height;
        pixels = new Pixel[width * height];
        RGBs = new float[width * height * 3];
        pixelUpdate = new ArrayList<>();
        initPixels();
    }

    public void tick() {
        Iterator<Pixel[]> updateIterator = pixelUpdate.iterator();
        while(updateIterator.hasNext()) {
            setRGBs(updateIterator.next());
            updateIterator.remove();
        }
    }

    public void render() {
        GL11.glDrawPixels(width, height, GL11.GL_RGB, GL11.GL_FLOAT, RGBs);
    }

    private void initPixels() {
        int x = 0 , y = 0;
        for(int realY = height-1; realY >= 0; realY--) {
            for(int realX = 0; realX < width; realX++) {
                pixels[x + y * width] = new Pixel(x, y, realX, realY, Color.BLACK);
                x++;
            }
            x = 0;
            y++;
        }
        pixelUpdate.add(pixels);
    }

    private void setRGBs(Pixel[] pixels) {
        int index;
        for(Pixel pixel : pixels) {
            index = (pixel.getRealX() + pixel.getRealY() * width) * 3;
            RGBs[index    ] = pixel.getColor().getRed()   / 255.f;
            RGBs[index + 1] = pixel.getColor().getGreen() / 255.f;
            RGBs[index + 2] = pixel.getColor().getBlue()  / 255.f;
        }
    }

    public Pixel[] getPixels(int xCoor, int yCoor, int width, int height) {
        if(xCoor + width > this.width) width = -xCoor + this.width;
        if(yCoor + height > this.height) height = -yCoor + this.height;
        Pixel[] pixels = new Pixel[width * height];
        int index = 0;
        for(int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                pixels[index] = this.pixels[(xCoor + x) + (yCoor + y) * this.width];
                index++;
            }
        }
        return pixels;
    }

    public void setPixels(Pixel[] pixels) {
        int index;
        for(Pixel pixel : pixels) {
            index = pixel.getX() + pixel.getY() * width;
            this.pixels[index] = pixel;
        }
        pixelUpdate.add(pixels);
    }

    public Color[] getColors(int xCoor, int yCoor, int width, int height) {
        if(xCoor + width > this.width) width = -xCoor + this.width;
        if(yCoor + height > this.height) height = -yCoor + this.height;
        Color[] colors = new Color[width * height];
        int index = 0;
        for(int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                colors[index] = pixels[(xCoor + x) + (yCoor + y) * this.width].getColor();
                index++;
            }
        }
        return colors;
    }

    public void setColors(int xCoor ,int yCoor, int width, int height, Color[] colors) {
        if(width * height != colors.length || xCoor >= this.width || yCoor >= this.height) return;
        if(xCoor + width > this.width || yCoor + height > this.height) {
            Color[][] colors2D = new Color[width][height];
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    colors2D[x][y] = colors[x + y * width];
                }
            }
            setColors2D(xCoor, yCoor, width, height, colors2D);
            return;
        }
        Pixel[] newPixels = new Pixel[colors.length];
        int index = 0;
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                pixels[(xCoor + x) + (yCoor + y) * this.width].setColor(colors[index]);
                newPixels[index] = pixels[(xCoor + x) + (yCoor + y) * this.width];
                index++;
            }
        }
        pixelUpdate.add(newPixels);
    }

    public void setColors2D(int xCoor, int yCoor, int width, int height, Color[][] colors2D) {
        if(colors2D.length != width || colors2D[0].length != height || xCoor >= this.width || yCoor >= this.height) return;
        if(xCoor + width > this.width) width = -xCoor + this.width;
        if(yCoor + height > this.height) height = -yCoor + this.height;

        Pixel[] newPixels = new Pixel[width * height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                pixels[(xCoor + x) + (yCoor + y) * this.width].setColor(colors2D[x][y]);
                newPixels[x + y * width] = pixels[(xCoor + x) + (yCoor + y) * this.width];
            }
        }
        pixelUpdate.add(newPixels);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}