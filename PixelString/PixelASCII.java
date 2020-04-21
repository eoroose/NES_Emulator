package PixelString;

import PixelEngine.Pixel;
import PixelEngine.PixelEngine;

public class PixelASCII {

    protected interface Characters {
        Pixel[] getChar(PixelEngine pixelEngine, int x, int y, int size);
    }

    protected static final Characters[] ASCII = new Characters[] {
            new Characters() { @Override public Pixel[] getChar(PixelEngine pixelEngine, int x, int y, int size) { return PixelChars.EXCLAMATION(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(PixelEngine pixelEngine, int x, int y, int size) { return PixelChars.QUOTATION(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(PixelEngine pixelEngine, int x, int y, int size) { return PixelChars.HASHTAG(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(PixelEngine pixelEngine, int x, int y, int size) { return PixelChars.DOLLAR(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(PixelEngine pixelEngine, int x, int y, int size) { return PixelChars.PERCENT(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(PixelEngine pixelEngine, int x, int y, int size) { return PixelChars.AMPERSAND(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(PixelEngine pixelEngine, int x, int y, int size) { return PixelChars.QUOTE(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(PixelEngine pixelEngine, int x, int y, int size) { return PixelChars.OPEN_PARENTHESIS(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(PixelEngine pixelEngine, int x, int y, int size) { return PixelChars.CLOSE_PARENTHESIS(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(PixelEngine pixelEngine, int x, int y, int size) { return PixelChars.ASTERISK(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(PixelEngine pixelEngine, int x, int y, int size) { return PixelChars.PLUS(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(PixelEngine pixelEngine, int x, int y, int size) { return PixelChars.COMMA(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(PixelEngine pixelEngine, int x, int y, int size) { return PixelChars.DASH(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(PixelEngine pixelEngine, int x, int y, int size) { return PixelChars.PERIOD(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(PixelEngine pixelEngine, int x, int y, int size) { return PixelChars.FORWARD_SLASH(pixelEngine, x, y, size); } },

            new Characters() { @Override public Pixel[] getChar(PixelEngine pixelEngine, int x, int y, int size) { return PixelChars.ZERO(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(PixelEngine pixelEngine, int x, int y, int size) { return PixelChars.ONE(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(PixelEngine pixelEngine, int x, int y, int size) { return PixelChars.TWO(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(PixelEngine pixelEngine, int x, int y, int size) { return PixelChars.THREE(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(PixelEngine pixelEngine, int x, int y, int size) { return PixelChars.FOUR(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(PixelEngine pixelEngine, int x, int y, int size) { return PixelChars.FIVE(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(PixelEngine pixelEngine, int x, int y, int size) { return PixelChars.SIX(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(PixelEngine pixelEngine, int x, int y, int size) { return PixelChars.SEVEN(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(PixelEngine pixelEngine, int x, int y, int size) { return PixelChars.EIGHT(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(PixelEngine pixelEngine, int x, int y, int size) { return PixelChars.NINE(pixelEngine, x, y, size); } },

            new Characters() { @Override public Pixel[] getChar(PixelEngine pixelEngine, int x, int y, int size) { return PixelChars.COLON(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(PixelEngine pixelEngine, int x, int y, int size) { return PixelChars.SEMI_COLON(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(PixelEngine pixelEngine, int x, int y, int size) { return PixelChars.LESS(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(PixelEngine pixelEngine, int x, int y, int size) { return PixelChars.EQUAL(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(PixelEngine pixelEngine, int x, int y, int size) { return PixelChars.GREATER(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(PixelEngine pixelEngine, int x, int y, int size) { return PixelChars.QUESTION(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(PixelEngine pixelEngine, int x, int y, int size) { return PixelChars.AT(pixelEngine, x, y, size); } },

            new Characters() { @Override public Pixel[] getChar(PixelEngine pixelEngine, int x, int y, int size) { return PixelChars.A(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(PixelEngine pixelEngine, int x, int y, int size) { return PixelChars.B(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(PixelEngine pixelEngine, int x, int y, int size) { return PixelChars.C(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(PixelEngine pixelEngine, int x, int y, int size) { return PixelChars.D(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(PixelEngine pixelEngine, int x, int y, int size) { return PixelChars.E(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(PixelEngine pixelEngine, int x, int y, int size) { return PixelChars.F(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(PixelEngine pixelEngine, int x, int y, int size) { return PixelChars.G(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(PixelEngine pixelEngine, int x, int y, int size) { return PixelChars.H(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(PixelEngine pixelEngine, int x, int y, int size) { return PixelChars.I(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(PixelEngine pixelEngine, int x, int y, int size) { return PixelChars.J(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(PixelEngine pixelEngine, int x, int y, int size) { return PixelChars.K(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(PixelEngine pixelEngine, int x, int y, int size) { return PixelChars.L(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(PixelEngine pixelEngine, int x, int y, int size) { return PixelChars.M(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(PixelEngine pixelEngine, int x, int y, int size) { return PixelChars.N(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(PixelEngine pixelEngine, int x, int y, int size) { return PixelChars.O(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(PixelEngine pixelEngine, int x, int y, int size) { return PixelChars.P(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(PixelEngine pixelEngine, int x, int y, int size) { return PixelChars.Q(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(PixelEngine pixelEngine, int x, int y, int size) { return PixelChars.R(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(PixelEngine pixelEngine, int x, int y, int size) { return PixelChars.S(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(PixelEngine pixelEngine, int x, int y, int size) { return PixelChars.T(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(PixelEngine pixelEngine, int x, int y, int size) { return PixelChars.U(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(PixelEngine pixelEngine, int x, int y, int size) { return PixelChars.V(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(PixelEngine pixelEngine, int x, int y, int size) { return PixelChars.W(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(PixelEngine pixelEngine, int x, int y, int size) { return PixelChars.X(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(PixelEngine pixelEngine, int x, int y, int size) { return PixelChars.Y(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(PixelEngine pixelEngine, int x, int y, int size) { return PixelChars.Z(pixelEngine, x, y, size); } },

            new Characters() { @Override public Pixel[] getChar(PixelEngine pixelEngine, int x, int y, int size) { return PixelChars.OPEN_BRACKET(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(PixelEngine pixelEngine, int x, int y, int size) { return PixelChars.BACK_SLASH(pixelEngine, x, y, size); } },
            new Characters() { @Override public Pixel[] getChar(PixelEngine pixelEngine, int x, int y, int size) { return PixelChars.CLOSE_BRACKET(pixelEngine, x, y, size); } },
    };
}
