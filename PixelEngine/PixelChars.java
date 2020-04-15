package PixelEngine;

/*
      0 1 2 3 4 5
   0 | | | | | | |
   1 | |#|#|#| | |
   2 |#| | | |#| |
   3 |#| | | |#| |
   4 |#|#|#|#|#| |                   y  x
   5 |#| | | |#| |      first #  --> 1, 1 --> (1*size-cols) + 1*size
   6 |#| | | |#| |      second # --> 1, 2 --> (1*size-cols) + 2*size ...
 */
public class PixelChars {

    public static Pixel[] A(PixelEngine pixelEngine, int x, int y, int size) {
        Pixel[] pixels = new Pixel[16*size*size];
        Pixel[] pixelScreen = pixelEngine.getPixels();
        int width = pixelEngine.getWidth();
        int start = x + y * width;
        int index = 0;
        for(int cols = 0; cols < size; cols++) {
            for(int rows= 0; rows < size; rows++) {
                pixels[index++] = pixelScreen[start + width*(  size-cols) +   size + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) + 3*size + rows];
                pixels[index++] = pixelScreen[start + width*(2*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(2*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(4*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(4*size-cols) +   size + rows];
                pixels[index++] = pixelScreen[start + width*(4*size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(4*size-cols) + 3*size + rows];
                pixels[index++] = pixelScreen[start + width*(4*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(5*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(5*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) + 4*size + rows];
            }
        }
        return pixels;
    }

    public static Pixel[] B(PixelEngine pixelEngine, int x, int y, int size) {
        Pixel[] pixels = new Pixel[18*size*size];
        Pixel[] pixelScreen = pixelEngine.getPixels();
        int width = pixelEngine.getWidth();
        int start = x + y * width;
        int index = 0;
        for(int cols = 0; cols < size; cols++) {
            for(int rows= 0; rows < size; rows++) {
                pixels[index++] = pixelScreen[start + width*(  size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) +   size + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) + 3*size + rows];
                pixels[index++] = pixelScreen[start + width*(2*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(2*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols) +   size + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols) + 3*size + rows];
                pixels[index++] = pixelScreen[start + width*(4*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(4*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(5*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(5*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) +   size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) + 3*size + rows];
            }
        }
        return pixels;
    }

    public static Pixel[] C(PixelEngine pixelEngine, int x, int y, int size) {
        Pixel[] pixels = new Pixel[12*size*size];
        Pixel[] pixelScreen = pixelEngine.getPixels();
        int width = pixelEngine.getWidth();
        int start = x + y * width;
        int index = 0;
        for(int cols = 0; cols < size; cols++) {
            for(int rows= 0; rows < size; rows++) {
                pixels[index++] = pixelScreen[start + width*(  size-cols) +   size + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) + 3*size + rows];
                pixels[index++] = pixelScreen[start + width*(2*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(2*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(4*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(5*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(5*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) +   size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) + 3*size + rows];
            }
        }
        return pixels;
    }

    public static Pixel[] D(PixelEngine pixelEngine, int x, int y, int size) {
        Pixel[] pixels = new Pixel[16*size*size];
        Pixel[] pixelScreen = pixelEngine.getPixels();
        int width = pixelEngine.getWidth();
        int start = x + y * width;
        int index = 0;
        for(int cols = 0; cols < size; cols++) {
            for(int rows= 0; rows < size; rows++) {
                pixels[index++] = pixelScreen[start + width*(  size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) +   size + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) + 3*size + rows];
                pixels[index++] = pixelScreen[start + width*(2*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(2*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(4*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(4*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(5*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(5*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) +   size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) + 3*size + rows];
            }
        }
        return pixels;
    }

    public static Pixel[] E(PixelEngine pixelEngine, int x, int y, int size) {
        Pixel[] pixels = new Pixel[17*size*size];
        Pixel[] pixelScreen = pixelEngine.getPixels();
        int width = pixelEngine.getWidth();
        int start = x + y * width;
        int index = 0;
        for(int cols = 0; cols < size; cols++) {
            for(int rows= 0; rows < size; rows++) {
                pixels[index++] = pixelScreen[start + width*(  size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) +   size + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) + 3*size + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(2*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols) +   size + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols) + 3*size + rows];
                pixels[index++] = pixelScreen[start + width*(4*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(5*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) +   size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) + 3*size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) + 4*size + rows];
            }
        }
        return pixels;
    }

    public static Pixel[] F(PixelEngine pixelEngine, int x, int y, int size) {
        Pixel[] pixels = new Pixel[13*size*size];
        Pixel[] pixelScreen = pixelEngine.getPixels();
        int width = pixelEngine.getWidth();
        int start = x + y * width;
        int index = 0;
        for(int cols = 0; cols < size; cols++) {
            for(int rows= 0; rows < size; rows++) {
                pixels[index++] = pixelScreen[start + width*(  size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) +   size + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) + 3*size + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(2*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols) +   size + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols) + 3*size + rows];
                pixels[index++] = pixelScreen[start + width*(4*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(5*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols)          + rows];
            }
        }
        return pixels;
    }

    public static Pixel[] G(PixelEngine pixelEngine, int x, int y, int size) {
        Pixel[] pixels = new Pixel[14*size*size];
        Pixel[] pixelScreen = pixelEngine.getPixels();
        int width = pixelEngine.getWidth();
        int start = x + y * width;
        int index = 0;
        for(int cols = 0; cols < size; cols++) {
            for(int rows= 0; rows < size; rows++) {
                pixels[index++] = pixelScreen[start + width*(  size-cols) +   size + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) + 3*size + rows];
                pixels[index++] = pixelScreen[start + width*(2*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(2*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(4*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(4*size-cols) + 3*size + rows];
                pixels[index++] = pixelScreen[start + width*(4*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(5*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(5*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) +   size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) + 3*size + rows];
            }
        }
        return pixels;
    }

    public static Pixel[] H(PixelEngine pixelEngine, int x, int y, int size) {
        Pixel[] pixels = new Pixel[15*size*size];
        Pixel[] pixelScreen = pixelEngine.getPixels();
        int width = pixelEngine.getWidth();
        int start = x + y * width;
        int index = 0;
        for(int cols = 0; cols < size; cols++) {
            for(int rows= 0; rows < size; rows++) {
                pixels[index++] = pixelScreen[start + width*(  size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(2*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(2*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(4*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(4*size-cols) +   size + rows];
                pixels[index++] = pixelScreen[start + width*(4*size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(4*size-cols) + 3*size + rows];
                pixels[index++] = pixelScreen[start + width*(4*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(5*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(5*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) + 4*size + rows];
            }
        }
        return pixels;
    }

    public static Pixel[] I(PixelEngine pixelEngine, int x, int y, int size) {
        Pixel[] pixels = new Pixel[14*size*size];
        Pixel[] pixelScreen = pixelEngine.getPixels();
        int width = pixelEngine.getWidth();
        int start = x + y * width;
        int index = 0;
        for(int cols = 0; cols < size; cols++) {
            for(int rows= 0; rows < size; rows++) {
                pixels[index++] = pixelScreen[start + width*(  size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) +   size + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) + 3*size + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(2*size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(4*size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(5*size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) +   size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) + 3*size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) + 4*size + rows];
            }
        }
        return pixels;
    }

    public static Pixel[] J(PixelEngine pixelEngine, int x, int y, int size) {
        Pixel[] pixels = new Pixel[12*size*size];
        Pixel[] pixelScreen = pixelEngine.getPixels();
        int width = pixelEngine.getWidth();
        int start = x + y * width;
        int index = 0;
        for(int cols = 0; cols < size; cols++) {
            for(int rows= 0; rows < size; rows++) {
                pixels[index++] = pixelScreen[start + width*(  size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) +   size + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) + 3*size + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(2*size-cols) + 3*size + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols) + 3*size + rows];
                pixels[index++] = pixelScreen[start + width*(4*size-cols) + 3*size + rows];
                pixels[index++] = pixelScreen[start + width*(5*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(5*size-cols) + 3*size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) +   size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) + 2*size + rows];
            }
        }
        return pixels;
    }

    public static Pixel[] K(PixelEngine pixelEngine, int x, int y, int size) {
        Pixel[] pixels = new Pixel[12*size*size];
        Pixel[] pixelScreen = pixelEngine.getPixels();
        int width = pixelEngine.getWidth();
        int start = x + y * width;
        int index = 0;
        for(int cols = 0; cols < size; cols++) {
            for(int rows= 0; rows < size; rows++) {
                pixels[index++] = pixelScreen[start + width*(  size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) + 3*size + rows];
                pixels[index++] = pixelScreen[start + width*(2*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(2*size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols) +   size + rows];
                pixels[index++] = pixelScreen[start + width*(4*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(4*size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(5*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(5*size-cols) + 3*size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) + 4*size + rows];
            }
        }
        return pixels;
    }

    public static Pixel[] L(PixelEngine pixelEngine, int x, int y, int size) {
        Pixel[] pixels = new Pixel[10*size*size];
        Pixel[] pixelScreen = pixelEngine.getPixels();
        int width = pixelEngine.getWidth();
        int start = x + y * width;
        int index = 0;
        for(int cols = 0; cols < size; cols++) {
            for(int rows= 0; rows < size; rows++) {
                pixels[index++] = pixelScreen[start + width*(  size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(2*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(4*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(5*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) +   size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) + 3*size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) + 4*size + rows];
            }
        }
        return pixels;
    }

    public static Pixel[] M(PixelEngine pixelEngine, int x, int y, int size) {
        Pixel[] pixels = new Pixel[15*size*size];
        Pixel[] pixelScreen = pixelEngine.getPixels();
        int width = pixelEngine.getWidth();
        int start = x + y * width;
        int index = 0;
        for(int cols = 0; cols < size; cols++) {
            for(int rows= 0; rows < size; rows++) {
                pixels[index++] = pixelScreen[start + width*(  size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(2*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(2*size-cols) +   size + rows];
                pixels[index++] = pixelScreen[start + width*(2*size-cols) + 3*size + rows];
                pixels[index++] = pixelScreen[start + width*(2*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(4*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(4*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(5*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(5*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) + 4*size + rows];
            }
        }
        return pixels;
    }

    public static Pixel[] N(PixelEngine pixelEngine, int x, int y, int size) {
        Pixel[] pixels = new Pixel[15*size*size];
        Pixel[] pixelScreen = pixelEngine.getPixels();
        int width = pixelEngine.getWidth();
        int start = x + y * width;
        int index = 0;
        for(int cols = 0; cols < size; cols++) {
            for(int rows= 0; rows < size; rows++) {
                pixels[index++] = pixelScreen[start + width*(  size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(2*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(2*size-cols) +   size + rows];
                pixels[index++] = pixelScreen[start + width*(2*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(4*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(4*size-cols) + 3*size + rows];
                pixels[index++] = pixelScreen[start + width*(4*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(5*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(5*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) + 4*size + rows];
            }
        }
        return pixels;
    }

    public static Pixel[] O(PixelEngine pixelEngine, int x, int y, int size) {
        Pixel[] pixels = new Pixel[14*size*size];
        Pixel[] pixelScreen = pixelEngine.getPixels();
        int width = pixelEngine.getWidth();
        int start = x + y * width;
        int index = 0;
        for(int cols = 0; cols < size; cols++) {
            for(int rows= 0; rows < size; rows++) {
                pixels[index++] = pixelScreen[start + width*(  size-cols) +   size + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) + 3*size + rows];
                pixels[index++] = pixelScreen[start + width*(2*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(2*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(4*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(4*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(5*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(5*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) +   size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) + 3*size + rows];
            }
        }
        return pixels;
    }

    public static Pixel[] P(PixelEngine pixelEngine, int x, int y, int size) {
        Pixel[] pixels = new Pixel[13*size*size];
        Pixel[] pixelScreen = pixelEngine.getPixels();
        int width = pixelEngine.getWidth();
        int start = x + y * width;
        int index = 0;
        for(int cols = 0; cols < size; cols++) {
            for(int rows= 0; rows < size; rows++) {
                pixels[index++] = pixelScreen[start + width*(  size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) +   size + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) + 3*size + rows];
                pixels[index++] = pixelScreen[start + width*(2*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(2*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols) +   size + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols) + 3*size + rows];
                pixels[index++] = pixelScreen[start + width*(4*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(5*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols)          + rows];
            }
        }
        return pixels;
    }

    public static Pixel[] Q(PixelEngine pixelEngine, int x, int y, int size) {
        Pixel[] pixels = new Pixel[15*size*size];
        Pixel[] pixelScreen = pixelEngine.getPixels();
        int width = pixelEngine.getWidth();
        int start = x + y * width;
        int index = 0;
        for(int cols = 0; cols < size; cols++) {
            for(int rows= 0; rows < size; rows++) {
                pixels[index++] = pixelScreen[start + width*(  size-cols) +   size + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) + 3*size + rows];
                pixels[index++] = pixelScreen[start + width*(2*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(2*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(4*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(4*size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(4*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(5*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(5*size-cols) + 3*size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) +   size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) + 4*size + rows];
            }
        }
        return pixels;
    }

    public static Pixel[] R(PixelEngine pixelEngine, int x, int y, int size) {
        Pixel[] pixels = new Pixel[16*size*size];
        Pixel[] pixelScreen = pixelEngine.getPixels();
        int width = pixelEngine.getWidth();
        int start = x + y * width;
        int index = 0;
        for(int cols = 0; cols < size; cols++) {
            for(int rows= 0; rows < size; rows++) {
                pixels[index++] = pixelScreen[start + width*(  size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) +   size + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) + 3*size + rows];
                pixels[index++] = pixelScreen[start + width*(2*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(2*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols) +   size + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols) + 3*size + rows];
                pixels[index++] = pixelScreen[start + width*(4*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(4*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(5*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(5*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) + 4*size + rows];
            }
        }
        return pixels;
    }

    public static Pixel[] S(PixelEngine pixelEngine, int x, int y, int size) {
        Pixel[] pixels = new Pixel[14*size*size];
        Pixel[] pixelScreen = pixelEngine.getPixels();
        int width = pixelEngine.getWidth();
        int start = x + y * width;
        int index = 0;
        for(int cols = 0; cols < size; cols++) {
            for(int rows= 0; rows < size; rows++) {
                pixels[index++] = pixelScreen[start + width*(  size-cols) +   size + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) + 3*size + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(2*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols) +   size + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols) + 3*size + rows];
                pixels[index++] = pixelScreen[start + width*(4*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(5*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) +   size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) + 3*size + rows];
            }
        }
        return pixels;
    }

    public static Pixel[] T(PixelEngine pixelEngine, int x, int y, int size) {
        Pixel[] pixels = new Pixel[10*size*size];
        Pixel[] pixelScreen = pixelEngine.getPixels();
        int width = pixelEngine.getWidth();
        int start = x + y * width;
        int index = 0;
        for(int cols = 0; cols < size; cols++) {
            for(int rows= 0; rows < size; rows++) {
                pixels[index++] = pixelScreen[start + width*(  size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) +   size + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) + 3*size + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(2*size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(4*size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(5*size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) + 2*size + rows];
            }
        }
        return pixels;
    }

    public static Pixel[] U(PixelEngine pixelEngine, int x, int y, int size) {
        Pixel[] pixels = new Pixel[13*size*size];
        Pixel[] pixelScreen = pixelEngine.getPixels();
        int width = pixelEngine.getWidth();
        int start = x + y * width;
        int index = 0;
        for(int cols = 0; cols < size; cols++) {
            for(int rows= 0; rows < size; rows++) {
                pixels[index++] = pixelScreen[start + width*(  size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(2*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(2*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(4*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(4*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(5*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(5*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) +   size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) + 3*size + rows];
            }
        }
        return pixels;
    }

    public static Pixel[] V(PixelEngine pixelEngine, int x, int y, int size) {
        Pixel[] pixels = new Pixel[11*size*size];
        Pixel[] pixelScreen = pixelEngine.getPixels();
        int width = pixelEngine.getWidth();
        int start = x + y * width;
        int index = 0;
        for(int cols = 0; cols < size; cols++) {
            for(int rows= 0; rows < size; rows++) {
                pixels[index++] = pixelScreen[start + width*(  size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(2*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(2*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(4*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(4*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(5*size-cols) +   size + rows];
                pixels[index++] = pixelScreen[start + width*(5*size-cols) + 3*size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) + 2*size + rows];
            }
        }
        return pixels;
    }

    public static Pixel[] W(PixelEngine pixelEngine, int x, int y, int size) {
        Pixel[] pixels = new Pixel[15*size*size];
        Pixel[] pixelScreen = pixelEngine.getPixels();
        int width = pixelEngine.getWidth();
        int start = x + y * width;
        int index = 0;
        for(int cols = 0; cols < size; cols++) {
            for(int rows= 0; rows < size; rows++) {
                pixels[index++] = pixelScreen[start + width*(  size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(2*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(2*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(4*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(4*size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(4*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(5*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(5*size-cols) +   size + rows];
                pixels[index++] = pixelScreen[start + width*(5*size-cols) + 3*size + rows];
                pixels[index++] = pixelScreen[start + width*(5*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) + 4*size + rows];
            }
        }
        return pixels;
    }

    public static Pixel[] X(PixelEngine pixelEngine, int x, int y, int size) {
        Pixel[] pixels = new Pixel[11*size*size];
        Pixel[] pixelScreen = pixelEngine.getPixels();
        int width = pixelEngine.getWidth();
        int start = x + y * width;
        int index = 0;
        for(int cols = 0; cols < size; cols++) {
            for(int rows= 0; rows < size; rows++) {
                pixels[index++] = pixelScreen[start + width*(  size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(2*size-cols) +   size + rows];
                pixels[index++] = pixelScreen[start + width*(2*size-cols) + 3*size + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(4*size-cols) +   size + rows];
                pixels[index++] = pixelScreen[start + width*(4*size-cols) + 3*size + rows];
                pixels[index++] = pixelScreen[start + width*(5*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(5*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) + 4*size + rows];
            }
        }
        return pixels;
    }

    public static Pixel[] Y(PixelEngine pixelEngine, int x, int y, int size) {
        Pixel[] pixels = new Pixel[9*size*size];
        Pixel[] pixelScreen = pixelEngine.getPixels();
        int width = pixelEngine.getWidth();
        int start = x + y * width;
        int index = 0;
        for(int cols = 0; cols < size; cols++) {
            for(int rows= 0; rows < size; rows++) {
                pixels[index++] = pixelScreen[start + width*(  size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(2*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(2*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols) +   size + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols) + 3*size + rows];
                pixels[index++] = pixelScreen[start + width*(4*size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(5*size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) + 2*size + rows];
            }
        }
        return pixels;
    }

    public static Pixel[] Z(PixelEngine pixelEngine, int x, int y, int size) {
        Pixel[] pixels = new Pixel[14*size*size];
        Pixel[] pixelScreen = pixelEngine.getPixels();
        int width = pixelEngine.getWidth();
        int start = x + y * width;
        int index = 0;
        for(int cols = 0; cols < size; cols++) {
            for(int rows= 0; rows < size; rows++) {
                pixels[index++] = pixelScreen[start + width*(  size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) +   size + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) + 3*size + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(2*size-cols) + 3*size + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(4*size-cols) +   size + rows];
                pixels[index++] = pixelScreen[start + width*(5*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) +   size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) + 3*size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) + 4*size + rows];
            }
        }
        return pixels;
    }

    public static Pixel[] ZERO(PixelEngine pixelEngine, int x, int y, int size) {
        Pixel[] pixels = new Pixel[18*size*size];
        Pixel[] pixelScreen = pixelEngine.getPixels();
        int width = pixelEngine.getWidth();
        int start = x + y * width;
        int index = 0;
        for(int cols = 0; cols < size; cols++) {
            for(int rows= 0; rows < size; rows++) {
                pixels[index++] = pixelScreen[start + width*(  size-cols) +   size + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) + 3*size + rows];
                pixels[index++] = pixelScreen[start + width*(2*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(2*size-cols) + 3*size + rows];
                pixels[index++] = pixelScreen[start + width*(2*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(4*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(4*size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(4*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(5*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(5*size-cols) +   size + rows];
                pixels[index++] = pixelScreen[start + width*(5*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) +   size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) + 3*size + rows];
            }
        }
        return pixels;
    }

    public static Pixel[] ONE(PixelEngine pixelEngine, int x, int y, int size) {
        Pixel[] pixels = new Pixel[11*size*size];
        Pixel[] pixelScreen = pixelEngine.getPixels();
        int width = pixelEngine.getWidth();
        int start = x + y * width;
        int index = 0;
        for(int cols = 0; cols < size; cols++) {
            for(int rows= 0; rows < size; rows++) {
                pixels[index++] = pixelScreen[start + width*(  size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(2*size-cols) +   size + rows];
                pixels[index++] = pixelScreen[start + width*(2*size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(4*size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(5*size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) +   size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) + 3*size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) + 4*size + rows];
            }
        }
        return pixels;
    }

    public static Pixel[] TWO(PixelEngine pixelEngine, int x, int y, int size) {
        Pixel[] pixels = new Pixel[14*size*size];
        Pixel[] pixelScreen = pixelEngine.getPixels();
        int width = pixelEngine.getWidth();
        int start = x + y * width;
        int index = 0;
        for(int cols = 0; cols < size; cols++) {
            for(int rows= 0; rows < size; rows++) {
                pixels[index++] = pixelScreen[start + width*(  size-cols) +   size + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) + 3*size + rows];
                pixels[index++] = pixelScreen[start + width*(2*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(2*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols) + 3*size + rows];
                pixels[index++] = pixelScreen[start + width*(4*size-cols) +   size + rows];
                pixels[index++] = pixelScreen[start + width*(4*size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(5*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) +   size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) + 3*size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) + 4*size + rows];
            }
        }
        return pixels;
    }

    public static Pixel[] THREE(PixelEngine pixelEngine, int x, int y, int size) {
        Pixel[] pixels = new Pixel[14*size*size];
        Pixel[] pixelScreen = pixelEngine.getPixels();
        int width = pixelEngine.getWidth();
        int start = x + y * width;
        int index = 0;
        for(int cols = 0; cols < size; cols++) {
            for(int rows= 0; rows < size; rows++) {
                pixels[index++] = pixelScreen[start + width*(  size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) +   size + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) + 3*size + rows];
                pixels[index++] = pixelScreen[start + width*(2*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols) +   size + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols) + 3*size + rows];
                pixels[index++] = pixelScreen[start + width*(4*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(5*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) +   size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) + 3*size + rows];
            }
        }
        return pixels;
    }

    public static Pixel[] FOUR(PixelEngine pixelEngine, int x, int y, int size) {
        Pixel[] pixels = new Pixel[13*size*size];
        Pixel[] pixelScreen = pixelEngine.getPixels();
        int width = pixelEngine.getWidth();
        int start = x + y * width;
        int index = 0;
        for(int cols = 0; cols < size; cols++) {
            for(int rows= 0; rows < size; rows++) {
                pixels[index++] = pixelScreen[start + width*(  size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(2*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(2*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(4*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(4*size-cols) +   size + rows];
                pixels[index++] = pixelScreen[start + width*(4*size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(4*size-cols) + 3*size + rows];
                pixels[index++] = pixelScreen[start + width*(4*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(5*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) + 4*size + rows];
            }
        }
        return pixels;
    }

    public static Pixel[] FIVE(PixelEngine pixelEngine, int x, int y, int size) {
        Pixel[] pixels = new Pixel[16*size*size];
        Pixel[] pixelScreen = pixelEngine.getPixels();
        int width = pixelEngine.getWidth();
        int start = x + y * width;
        int index = 0;
        for(int cols = 0; cols < size; cols++) {
            for(int rows= 0; rows < size; rows++) {
                pixels[index++] = pixelScreen[start + width*(  size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) +   size + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) + 3*size + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(2*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols) +   size + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols) + 3*size + rows];
                pixels[index++] = pixelScreen[start + width*(4*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(5*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(5*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) +   size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) + 3*size + rows];
            }
        }
        return pixels;
    }

    public static Pixel[] SIX(PixelEngine pixelEngine, int x, int y, int size) {
        Pixel[] pixels = new Pixel[16*size*size];
        Pixel[] pixelScreen = pixelEngine.getPixels();
        int width = pixelEngine.getWidth();
        int start = x + y * width;
        int index = 0;
        for(int cols = 0; cols < size; cols++) {
            for(int rows= 0; rows < size; rows++) {
                pixels[index++] = pixelScreen[start + width*(  size-cols) +   size + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) + 3*size + rows];
                pixels[index++] = pixelScreen[start + width*(2*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols) +   size + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols) + 3*size + rows];
                pixels[index++] = pixelScreen[start + width*(4*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(4*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(5*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(5*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) +   size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) + 3*size + rows];
            }
        }
        return pixels;
    }

    public static Pixel[] SEVEN(PixelEngine pixelEngine, int x, int y, int size) {
        Pixel[] pixels = new Pixel[10*size*size];
        Pixel[] pixelScreen = pixelEngine.getPixels();
        int width = pixelEngine.getWidth();
        int start = x + y * width;
        int index = 0;
        for(int cols = 0; cols < size; cols++) {
            for(int rows= 0; rows < size; rows++) {
                pixels[index++] = pixelScreen[start + width*(  size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) +   size + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) + 3*size + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(2*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols) + 3*size + rows];
                pixels[index++] = pixelScreen[start + width*(4*size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(5*size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) + 2*size + rows];
            }
        }
        return pixels;
    }

    public static Pixel[] EIGHT(PixelEngine pixelEngine, int x, int y, int size) {
        Pixel[] pixels = new Pixel[15*size*size];
        Pixel[] pixelScreen = pixelEngine.getPixels();
        int width = pixelEngine.getWidth();
        int start = x + y * width;
        int index = 0;
        for(int cols = 0; cols < size; cols++) {
            for(int rows= 0; rows < size; rows++) {
                pixels[index++] = pixelScreen[start + width*(  size-cols) +   size + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) + 3*size + rows];
                pixels[index++] = pixelScreen[start + width*(2*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(2*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols) +   size + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols) + 3*size + rows];
                pixels[index++] = pixelScreen[start + width*(4*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(4*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(5*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(5*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) +   size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) + 3*size + rows];
            }
        }
        return pixels;
    }

    public static Pixel[] NINE(PixelEngine pixelEngine, int x, int y, int size) {
        Pixel[] pixels = new Pixel[15*size*size];
        Pixel[] pixelScreen = pixelEngine.getPixels();
        int width = pixelEngine.getWidth();
        int start = x + y * width;
        int index = 0;
        for(int cols = 0; cols < size; cols++) {
            for(int rows= 0; rows < size; rows++) {
                pixels[index++] = pixelScreen[start + width*(  size-cols) +   size + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(  size-cols) + 3*size + rows];
                pixels[index++] = pixelScreen[start + width*(2*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(2*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols) +   size + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols) + 3*size + rows];
                pixels[index++] = pixelScreen[start + width*(3*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(4*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(5*size-cols)          + rows];
                pixels[index++] = pixelScreen[start + width*(5*size-cols) + 4*size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) +   size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) + 2*size + rows];
                pixels[index++] = pixelScreen[start + width*(6*size-cols) + 3*size + rows];
            }
        }
        return pixels;
    }

}
