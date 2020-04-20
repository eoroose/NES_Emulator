package PixelString;

import PixelEngine.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class PixelString {

    private final PixelEngine pixelEngine;
    private final int x, y, size, spacingX = 6;
    private String string;
    private Pixel[] pixels;

    private interface Characters {
        Pixel[] getChar(int x, int y);
    }

    private final Characters[] letters = new Characters[] {
            new Characters() { @Override public Pixel[] getChar(int x, int y) { return PixelChars.A(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(int x, int y) { return PixelChars.B(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(int x, int y) { return PixelChars.C(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(int x, int y) { return PixelChars.D(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(int x, int y) { return PixelChars.E(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(int x, int y) { return PixelChars.F(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(int x, int y) { return PixelChars.G(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(int x, int y) { return PixelChars.H(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(int x, int y) { return PixelChars.I(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(int x, int y) { return PixelChars.J(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(int x, int y) { return PixelChars.K(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(int x, int y) { return PixelChars.L(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(int x, int y) { return PixelChars.M(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(int x, int y) { return PixelChars.N(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(int x, int y) { return PixelChars.O(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(int x, int y) { return PixelChars.P(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(int x, int y) { return PixelChars.Q(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(int x, int y) { return PixelChars.R(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(int x, int y) { return PixelChars.S(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(int x, int y) { return PixelChars.T(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(int x, int y) { return PixelChars.U(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(int x, int y) { return PixelChars.V(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(int x, int y) { return PixelChars.W(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(int x, int y) { return PixelChars.X(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(int x, int y) { return PixelChars.Y(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(int x, int y) { return PixelChars.Z(pixelEngine, x, y, size); } }
    };

    private final Characters[] numbers = new Characters[] {
            new Characters() { @Override public Pixel[] getChar(int x, int y) { return PixelChars.ZERO(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(int x, int y) { return PixelChars.ONE(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(int x, int y) { return PixelChars.TWO(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(int x, int y) { return PixelChars.THREE(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(int x, int y) { return PixelChars.FOUR(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(int x, int y) { return PixelChars.FIVE(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(int x, int y) { return PixelChars.SIX(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(int x, int y) { return PixelChars.SEVEN(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(int x, int y) { return PixelChars.EIGHT(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(int x, int y) { return PixelChars.NINE(pixelEngine, x, y, size); } },
    };

    private final Characters[] punctuations = new Characters[] {
            new Characters() { @Override public Pixel[] getChar(int x, int y) { return PixelChars.COMMA(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(int x, int y) { return PixelChars.DASH(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(int x, int y) { return PixelChars.PERIOD(pixelEngine, x, y, size); } }
    };

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
        ArrayList<Pixel> arrayListPixels = new ArrayList<Pixel>();
        for(int index = 0; index < string.length(); index++) {
            character = string.charAt(index);

            if(character >= 44 && character < 44 + punctuations.length) {
                Collections.addAll(arrayListPixels, punctuations[character-44].getChar(posX, posY));
            }
            else if(character >= 48 && character < 48 + numbers.length) {
                Collections.addAll(arrayListPixels, numbers[character-48].getChar(posX, posY));
            }
            else if(character >= 65 && character < 65 + letters.length) {
                Collections.addAll(arrayListPixels, letters[character-65].getChar(posX, posY));
            }
            else if(character >= 97 && character < 97 + letters.length) {
                Collections.addAll(arrayListPixels, letters[character-97].getChar(posX, posY));
            }
            posX += spacingX * size;
        }
        pixels = arrayListPixels.toArray(new Pixel[ arrayListPixels.size() ] );
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