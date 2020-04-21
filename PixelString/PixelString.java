package PixelString;

import PixelEngine.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class PixelString {

    private final PixelEngine pixelEngine;
    private final int x, y, size, spacingX = 6, spacingY = 10;
    private String string;
    private Pixel[] pixels;

    public PixelString(PixelEngine pixelEngine, int x, int y, int size, String string) {
        this.pixelEngine = pixelEngine;
        this.x = x;
        this.y = y;
        this.size = size;
        this.string = string;
        makePixelString();
    }

    private void makePixelString() {
        int posX = x;
        int posY = y;
        int character;
        String string = this.string.toUpperCase();
        ArrayList<Pixel> pixels = new ArrayList<Pixel>();
        for(int index = 0; index < string.length(); index++) {
            character = string.charAt(index);

            if(character == '\n') {
                posY += spacingY * size;
                posX = x;
                continue;
            }

            if(character >= '!' && character <= ']') {
                Collections.addAll(pixels, PixelASCII.ASCII[character - '!'].getChar(pixelEngine, posX, posY, size));
            }
            posX += spacingX * size;
        }
        this.pixels = pixels.toArray(new Pixel[pixels.size()]);
    }

    public void setPixelString(String string) {
        this.string = string;
        makePixelString();
    }

    public void setPixelColor(Color color) {
        for(Pixel pixel : pixels) {
            pixel.setColor(color);
        }
    }

    public void showPixelString() {
        pixelEngine.setPixels(pixels);
    }

}