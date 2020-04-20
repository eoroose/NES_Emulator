package PixelString;

import PixelEngine.Pixel;
import PixelEngine.PixelEngine;

/*
      0 1 2 3 4
   0 | |#|#|#| |
   1 |#| | | |#|
   2 |#| | | |#|
   3 |#|#|#|#|#|                   x  y
   4 |#| | | |#|      first #  --> 1, 0 --> start + width*cols + rows + 1*size + 0*width*size
   5 |#| | | |#|      second # --> 2, 0 --> start + width*cols + rows + 2*size + 0*width*size ...
 */
public class PixelChars {

    protected static Pixel[] A(PixelEngine pixelEngine, int x, int y, int size) {
        Pixel[] pixels = new Pixel[16*size*size];
        Pixel[] pixelScreen = pixelEngine.getPixels();
        int width = pixelEngine.getWidth();
        int start = x + y * width;
        int index = 0;
        for(int cols = 0; cols < size; cols++) {
            for(int rows= 0; rows < size; rows++) {
                pixels[index++] = pixelScreen[start + width*cols + rows +   size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +            width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size +   width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size + 2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          3*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +   size + 3*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size + 3*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size + 3*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size + 3*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          4*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size + 4*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          5*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size + 5*width*size];
            }
        }
        return pixels;
    }

    protected static Pixel[] B(PixelEngine pixelEngine, int x, int y, int size) {
        Pixel[] pixels = new Pixel[18*size*size];
        Pixel[] pixelScreen = pixelEngine.getPixels();
        int width = pixelEngine.getWidth();
        int start = x + y * width;
        int index = 0;
        for(int cols = 0; cols < size; cols++) {
            for(int rows= 0; rows < size; rows++) {
                pixels[index++] = pixelScreen[start + width*cols + rows];
                pixels[index++] = pixelScreen[start + width*cols + rows +   size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +             width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size +    width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +           2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +   size +  2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size +  2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size +  2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +           3*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size +  3*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +           4*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size +  4*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +           5*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +   size +  5*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size +  5*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size +  5*width*size];
            }
        }
        return pixels;
    }

    protected static Pixel[] C(PixelEngine pixelEngine, int x, int y, int size) {
        Pixel[] pixels = new Pixel[12*size*size];
        Pixel[] pixelScreen = pixelEngine.getPixels();
        int width = pixelEngine.getWidth();
        int start = x + y * width;
        int index = 0;
        for(int cols = 0; cols < size; cols++) {
            for(int rows= 0; rows < size; rows++) {
                pixels[index++] = pixelScreen[start + width*cols + rows +   size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +            width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size +   width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          3*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          4*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size + 4*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +   size + 5*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size + 5*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size + 5*width*size];
            }
        }
        return pixels;
    }

    protected static Pixel[] D(PixelEngine pixelEngine, int x, int y, int size) {
        Pixel[] pixels = new Pixel[16*size*size];
        Pixel[] pixelScreen = pixelEngine.getPixels();
        int width = pixelEngine.getWidth();
        int start = x + y * width;
        int index = 0;
        for(int cols = 0; cols < size; cols++) {
            for(int rows= 0; rows < size; rows++) {
                pixels[index++] = pixelScreen[start + width*cols + rows];
                pixels[index++] = pixelScreen[start + width*cols + rows +   size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size];
                pixels[index++] = pixelScreen[start + width*cols + rows          +   width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size +   width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size + 2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          3*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size + 3*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          4*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size + 4*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          5*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + size +   5*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size + 5*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size + 5*width*size];
            }
        }
        return pixels;
    }

    protected static Pixel[] E(PixelEngine pixelEngine, int x, int y, int size) {
        Pixel[] pixels = new Pixel[17*size*size];
        Pixel[] pixelScreen = pixelEngine.getPixels();
        int width = pixelEngine.getWidth();
        int start = x + y * width;
        int index = 0;
        for(int cols = 0; cols < size; cols++) {
            for(int rows= 0; rows < size; rows++) {
                pixels[index++] = pixelScreen[start + width*cols + rows];
                pixels[index++] = pixelScreen[start + width*cols + rows +   size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +            width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +   size + 2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size + 2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size + 2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          3*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          4*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          5*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +   size + 5*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size + 5*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size + 5*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size + 5*width*size];
            }
        }
        return pixels;
    }

    protected static Pixel[] F(PixelEngine pixelEngine, int x, int y, int size) {
        Pixel[] pixels = new Pixel[13*size*size];
        Pixel[] pixelScreen = pixelEngine.getPixels();
        int width = pixelEngine.getWidth();
        int start = x + y * width;
        int index = 0;
        for(int cols = 0; cols < size; cols++) {
            for(int rows= 0; rows < size; rows++) {
                pixels[index++] = pixelScreen[start + width*cols + rows];
                pixels[index++] = pixelScreen[start + width*cols + rows +  size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +            width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +   size + 2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size + 2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size + 2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          3*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          4*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          5*width*size];
            }
        }
        return pixels;
    }

    protected static Pixel[] G(PixelEngine pixelEngine, int x, int y, int size) {
        Pixel[] pixels = new Pixel[14*size*size];
        Pixel[] pixelScreen = pixelEngine.getPixels();
        int width = pixelEngine.getWidth();
        int start = x + y * width;
        int index = 0;
        for(int cols = 0; cols < size; cols++) {
            for(int rows= 0; rows < size; rows++) {
                pixels[index++] = pixelScreen[start + width*cols + rows +   size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +            width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size +   width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          3*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size + 3*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size + 3*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          4*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size + 4*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +   size + 5*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size + 5*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size + 5*width*size];
            }
        }
        return pixels;
    }

    protected static Pixel[] H(PixelEngine pixelEngine, int x, int y, int size) {
        Pixel[] pixels = new Pixel[15*size*size];
        Pixel[] pixelScreen = pixelEngine.getPixels();
        int width = pixelEngine.getWidth();
        int start = x + y * width;
        int index = 0;
        for(int cols = 0; cols < size; cols++) {
            for(int rows= 0; rows < size; rows++) {
                pixels[index++] = pixelScreen[start + width*cols + rows];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +            width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size +   width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size + 2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          3*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +   size + 3*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size + 3*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size + 3*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size + 3*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          4*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size + 4*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          5*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size + 5*width*size];
            }
        }
        return pixels;
    }

    protected static Pixel[] I(PixelEngine pixelEngine, int x, int y, int size) {
        Pixel[] pixels = new Pixel[14*size*size];
        Pixel[] pixelScreen = pixelEngine.getPixels();
        int width = pixelEngine.getWidth();
        int start = x + y * width;
        int index = 0;
        for(int cols = 0; cols < size; cols++) {
            for(int rows= 0; rows < size; rows++) {
                pixels[index++] = pixelScreen[start + width*cols + rows];
                pixels[index++] = pixelScreen[start + width*cols + rows +   size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size +   width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size + 2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size + 3*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size + 4*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          5*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +   size + 5*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size + 5*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size + 5*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size + 5*width*size];
            }
        }
        return pixels;
    }

    protected static Pixel[] J(PixelEngine pixelEngine, int x, int y, int size) {
        Pixel[] pixels = new Pixel[12*size*size];
        Pixel[] pixelScreen = pixelEngine.getPixels();
        int width = pixelEngine.getWidth();
        int start = x + y * width;
        int index = 0;
        for(int cols = 0; cols < size; cols++) {
            for(int rows= 0; rows < size; rows++) {
                pixels[index++] = pixelScreen[start + width*cols + rows];
                pixels[index++] = pixelScreen[start + width*cols + rows +   size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size +   width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size + 2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size + 3*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          4*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size + 4*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +   size + 5*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size + 5*width*size];
            }
        }
        return pixels;
    }

    protected static Pixel[] K(PixelEngine pixelEngine, int x, int y, int size) {
        Pixel[] pixels = new Pixel[12*size*size];
        Pixel[] pixelScreen = pixelEngine.getPixels();
        int width = pixelEngine.getWidth();
        int start = x + y * width;
        int index = 0;
        for(int cols = 0; cols < size; cols++) {
            for(int rows= 0; rows < size; rows++) {
                pixels[index++] = pixelScreen[start + width*cols + rows];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +            width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size +   width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +   size + 2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          3*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size + 3*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          4*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size + 4*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          5*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size + 5*width*size];
            }
        }
        return pixels;
    }

    protected static Pixel[] L(PixelEngine pixelEngine, int x, int y, int size) {
        Pixel[] pixels = new Pixel[10*size*size];
        Pixel[] pixelScreen = pixelEngine.getPixels();
        int width = pixelEngine.getWidth();
        int start = x + y * width;
        int index = 0;
        for(int cols = 0; cols < size; cols++) {
            for(int rows= 0; rows < size; rows++) {
                pixels[index++] = pixelScreen[start + width*cols + rows];
                pixels[index++] = pixelScreen[start + width*cols + rows +            width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          3*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          4*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          5*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +   size + 5*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size + 5*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size + 5*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size + 5*width*size];
            }
        }
        return pixels;
    }

    protected static Pixel[] M(PixelEngine pixelEngine, int x, int y, int size) {
        Pixel[] pixels = new Pixel[15*size*size];
        Pixel[] pixelScreen = pixelEngine.getPixels();
        int width = pixelEngine.getWidth();
        int start = x + y * width;
        int index = 0;
        for(int cols = 0; cols < size; cols++) {
            for(int rows= 0; rows < size; rows++) {
                pixels[index++] = pixelScreen[start + width*cols + rows];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +            width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +   size +   width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size +   width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size +   width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size + 2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size + 2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          3*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size + 3*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          4*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size + 4*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          5*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size + 5*width*size];
            }
        }
        return pixels;
    }

    protected static Pixel[] N(PixelEngine pixelEngine, int x, int y, int size) {
        Pixel[] pixels = new Pixel[15*size*size];
        Pixel[] pixelScreen = pixelEngine.getPixels();
        int width = pixelEngine.getWidth();
        int start = x + y * width;
        int index = 0;
        for(int cols = 0; cols < size; cols++) {
            for(int rows= 0; rows < size; rows++) {
                pixels[index++] = pixelScreen[start + width*cols + rows];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +            width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +   size +   width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size +   width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size + 2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size + 2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          3*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size + 3*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size + 3*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          4*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size + 4*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          5*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size + 5*width*size];
            }
        }
        return pixels;
    }

    protected static Pixel[] O(PixelEngine pixelEngine, int x, int y, int size) {
        Pixel[] pixels = new Pixel[14*size*size];
        Pixel[] pixelScreen = pixelEngine.getPixels();
        int width = pixelEngine.getWidth();
        int start = x + y * width;
        int index = 0;
        for(int cols = 0; cols < size; cols++) {
            for(int rows= 0; rows < size; rows++) {
                pixels[index++] = pixelScreen[start + width*cols + rows +   size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +            width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size +   width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size + 2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          3*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size + 3*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          4*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size + 4*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +   size + 5*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size + 5*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size + 5*width*size];
            }
        }
        return pixels;
    }

    protected static Pixel[] P(PixelEngine pixelEngine, int x, int y, int size) {
        Pixel[] pixels = new Pixel[13*size*size];
        Pixel[] pixelScreen = pixelEngine.getPixels();
        int width = pixelEngine.getWidth();
        int start = x + y * width;
        int index = 0;
        for(int cols = 0; cols < size; cols++) {
            for(int rows= 0; rows < size; rows++) {
                pixels[index++] = pixelScreen[start + width*cols + rows];
                pixels[index++] = pixelScreen[start + width*cols + rows +   size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +            width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size +   width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +   size + 2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size + 2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size + 2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          3*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          4*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          5*width*size];
            }
        }
        return pixels;
    }

    protected static Pixel[] Q(PixelEngine pixelEngine, int x, int y, int size) {
        Pixel[] pixels = new Pixel[15*size*size];
        Pixel[] pixelScreen = pixelEngine.getPixels();
        int width = pixelEngine.getWidth();
        int start = x + y * width;
        int index = 0;
        for(int cols = 0; cols < size; cols++) {
            for(int rows= 0; rows < size; rows++) {
                pixels[index++] = pixelScreen[start + width*cols + rows +   size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +            width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size +   width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size + 2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          3*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size + 3*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size + 3*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          4*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size + 4*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +   size + 5*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size + 5*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size + 5*width*size];
            }
        }
        return pixels;
    }

    protected static Pixel[] R(PixelEngine pixelEngine, int x, int y, int size) {
        Pixel[] pixels = new Pixel[16*size*size];
        Pixel[] pixelScreen = pixelEngine.getPixels();
        int width = pixelEngine.getWidth();
        int start = x + y * width;
        int index = 0;
        for(int cols = 0; cols < size; cols++) {
            for(int rows= 0; rows < size; rows++) {
                pixels[index++] = pixelScreen[start + width*cols + rows];
                pixels[index++] = pixelScreen[start + width*cols + rows +   size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +            width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size +   width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +   size + 2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size + 2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size + 2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          3*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size + 3*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          4*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size + 4*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          5*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size + 5*width*size];
            }
        }
        return pixels;
    }

    protected static Pixel[] S(PixelEngine pixelEngine, int x, int y, int size) {
        Pixel[] pixels = new Pixel[14*size*size];
        Pixel[] pixelScreen = pixelEngine.getPixels();
        int width = pixelEngine.getWidth();
        int start = x + y * width;
        int index = 0;
        for(int cols = 0; cols < size; cols++) {
            for(int rows= 0; rows < size; rows++) {
                pixels[index++] = pixelScreen[start + width*cols + rows +   size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +            width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +   size + 2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size + 2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size + 2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size + 3*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size + 4*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          5*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +   size + 5*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size + 5*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size + 5*width*size];
            }
        }
        return pixels;
    }

    protected static Pixel[] T(PixelEngine pixelEngine, int x, int y, int size) {
        Pixel[] pixels = new Pixel[10*size*size];
        Pixel[] pixelScreen = pixelEngine.getPixels();
        int width = pixelEngine.getWidth();
        int start = x + y * width;
        int index = 0;
        for(int cols = 0; cols < size; cols++) {
            for(int rows= 0; rows < size; rows++) {
                pixels[index++] = pixelScreen[start + width*cols + rows];
                pixels[index++] = pixelScreen[start + width*cols + rows +   size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size +   width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size + 2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size + 3*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size + 4*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size + 5*width*size];
            }
        }
        return pixels;
    }

    protected static Pixel[] U(PixelEngine pixelEngine, int x, int y, int size) {
        Pixel[] pixels = new Pixel[13*size*size];
        Pixel[] pixelScreen = pixelEngine.getPixels();
        int width = pixelEngine.getWidth();
        int start = x + y * width;
        int index = 0;
        for(int cols = 0; cols < size; cols++) {
            for(int rows= 0; rows < size; rows++) {
                pixels[index++] = pixelScreen[start + width*cols + rows];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +            width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size +   width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size + 2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          3*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size + 3*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          4*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size + 4*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +   size + 5*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size + 5*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size + 5*width*size];
            }
        }
        return pixels;
    }

    protected static Pixel[] V(PixelEngine pixelEngine, int x, int y, int size) {
        Pixel[] pixels = new Pixel[11*size*size];
        Pixel[] pixelScreen = pixelEngine.getPixels();
        int width = pixelEngine.getWidth();
        int start = x + y * width;
        int index = 0;
        for(int cols = 0; cols < size; cols++) {
            for(int rows= 0; rows < size; rows++) {
                pixels[index++] = pixelScreen[start + width*cols + rows];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +            width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size +   width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size + 2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          3*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size + 3*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +   size + 4*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size + 4*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size + 5*width*size];
            }
        }
        return pixels;
    }

    protected static Pixel[] W(PixelEngine pixelEngine, int x, int y, int size) {
        Pixel[] pixels = new Pixel[15*size*size];
        Pixel[] pixelScreen = pixelEngine.getPixels();
        int width = pixelEngine.getWidth();
        int start = x + y * width;
        int index = 0;
        for(int cols = 0; cols < size; cols++) {
            for(int rows= 0; rows < size; rows++) {
                pixels[index++] = pixelScreen[start + width*cols + rows];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +            width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size +   width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size + 2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          3*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size + 3*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size + 3*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          4*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +   size + 4*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size + 4*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size + 4*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          5*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size + 5*width*size];
            }
        }
        return pixels;
    }

    protected static Pixel[] X(PixelEngine pixelEngine, int x, int y, int size) {
        Pixel[] pixels = new Pixel[11*size*size];
        Pixel[] pixelScreen = pixelEngine.getPixels();
        int width = pixelEngine.getWidth();
        int start = x + y * width;
        int index = 0;
        for(int cols = 0; cols < size; cols++) {
            for(int rows= 0; rows < size; rows++) {
                pixels[index++] = pixelScreen[start + width*cols + rows];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +   size +   width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size +   width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size + 2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +   size + 3*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size + 3*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          4*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size + 4*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          5*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size + 5*width*size];
            }
        }
        return pixels;
    }

    protected static Pixel[] Y(PixelEngine pixelEngine, int x, int y, int size) {
        Pixel[] pixels = new Pixel[9*size*size];
        Pixel[] pixelScreen = pixelEngine.getPixels();
        int width = pixelEngine.getWidth();
        int start = x + y * width;
        int index = 0;
        for(int cols = 0; cols < size; cols++) {
            for(int rows= 0; rows < size; rows++) {
                pixels[index++] = pixelScreen[start + width*cols + rows];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +            width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size +   width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +   size + 2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size + 2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size + 3*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size + 4*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size + 5*width*size];
            }
        }
        return pixels;
    }

    protected static Pixel[] Z(PixelEngine pixelEngine, int x, int y, int size) {
        Pixel[] pixels = new Pixel[14*size*size];
        Pixel[] pixelScreen = pixelEngine.getPixels();
        int width = pixelEngine.getWidth();
        int start = x + y * width;
        int index = 0;
        for(int cols = 0; cols < size; cols++) {
            for(int rows= 0; rows < size; rows++) {
                pixels[index++] = pixelScreen[start + width*cols + rows];
                pixels[index++] = pixelScreen[start + width*cols + rows +   size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size +   width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size + 2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +   size + 3*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          4*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          5*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +   size + 5*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size + 5*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size + 5*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size + 5*width*size];
            }
        }
        return pixels;
    }

    protected static Pixel[] ZERO(PixelEngine pixelEngine, int x, int y, int size) {
        Pixel[] pixels = new Pixel[18*size*size];
        Pixel[] pixelScreen = pixelEngine.getPixels();
        int width = pixelEngine.getWidth();
        int start = x + y * width;
        int index = 0;
        for(int cols = 0; cols < size; cols++) {
            for(int rows= 0; rows < size; rows++) {
                pixels[index++] = pixelScreen[start + width*cols + rows +   size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +            width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size +   width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size +   width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size + 2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size + 2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          3*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size + 3*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size + 3*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          4*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +   size + 4*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size + 4*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +   size + 5*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size + 5*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size + 5*width*size];
            }
        }
        return pixels;
    }

    protected static Pixel[] ONE(PixelEngine pixelEngine, int x, int y, int size) {
        Pixel[] pixels = new Pixel[11*size*size];
        Pixel[] pixelScreen = pixelEngine.getPixels();
        int width = pixelEngine.getWidth();
        int start = x + y * width;
        int index = 0;
        for(int cols = 0; cols < size; cols++) {
            for(int rows= 0; rows < size; rows++) {
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +   size +   width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size +   width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size + 2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size + 3*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size + 4*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          5*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +   size + 5*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size + 5*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size + 5*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size + 5*width*size];
            }
        }
        return pixels;
    }

    protected static Pixel[] TWO(PixelEngine pixelEngine, int x, int y, int size) {
        Pixel[] pixels = new Pixel[14*size*size];
        Pixel[] pixelScreen = pixelEngine.getPixels();
        int width = pixelEngine.getWidth();
        int start = x + y * width;
        int index = 0;
        for(int cols = 0; cols < size; cols++) {
            for(int rows= 0; rows < size; rows++) {
                pixels[index++] = pixelScreen[start + width*cols + rows +   size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +            width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size +   width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size + 2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +   size + 3*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size + 3*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          4*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          5*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +   size + 5*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size + 5*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size + 5*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size + 5*width*size];
            }
        }
        return pixels;
    }

    protected static Pixel[] THREE(PixelEngine pixelEngine, int x, int y, int size) {
        Pixel[] pixels = new Pixel[14*size*size];
        Pixel[] pixelScreen = pixelEngine.getPixels();
        int width = pixelEngine.getWidth();
        int start = x + y * width;
        int index = 0;
        for(int cols = 0; cols < size; cols++) {
            for(int rows= 0; rows < size; rows++) {
                pixels[index++] = pixelScreen[start + width*cols + rows];
                pixels[index++] = pixelScreen[start + width*cols + rows +   size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size +   width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +   size + 2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size + 2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size + 2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size + 3*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size + 4*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          5*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +   size + 5*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size + 5*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size + 5*width*size];
            }
        }
        return pixels;
    }

    protected static Pixel[] FOUR(PixelEngine pixelEngine, int x, int y, int size) {
        Pixel[] pixels = new Pixel[13*size*size];
        Pixel[] pixelScreen = pixelEngine.getPixels();
        int width = pixelEngine.getWidth();
        int start = x + y * width;
        int index = 0;
        for(int cols = 0; cols < size; cols++) {
            for(int rows= 0; rows < size; rows++) {
                pixels[index++] = pixelScreen[start + width*cols + rows];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +            width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size +   width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size + 2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          3*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +   size + 3*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size + 3*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size + 3*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size + 3*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size + 4*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size + 5*width*size];
            }
        }
        return pixels;
    }

    protected static Pixel[] FIVE(PixelEngine pixelEngine, int x, int y, int size) {
        Pixel[] pixels = new Pixel[16*size*size];
        Pixel[] pixelScreen = pixelEngine.getPixels();
        int width = pixelEngine.getWidth();
        int start = x + y * width;
        int index = 0;
        for(int cols = 0; cols < size; cols++) {
            for(int rows= 0; rows < size; rows++) {
                pixels[index++] = pixelScreen[start + width*cols + rows];
                pixels[index++] = pixelScreen[start + width*cols + rows +   size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +            width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +   size + 2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size + 2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size + 2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size + 3*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          4*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size + 4*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +   size + 5*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size + 5*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size + 5*width*size];
            }
        }
        return pixels;
    }

    protected static Pixel[] SIX(PixelEngine pixelEngine, int x, int y, int size) {
        Pixel[] pixels = new Pixel[15*size*size];
        Pixel[] pixelScreen = pixelEngine.getPixels();
        int width = pixelEngine.getWidth();
        int start = x + y * width;
        int index = 0;
        for(int cols = 0; cols < size; cols++) {
            for(int rows= 0; rows < size; rows++) {
                pixels[index++] = pixelScreen[start + width*cols + rows +   size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +            width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +   size + 2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size + 2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size + 2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          3*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size + 3*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          4*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size + 4*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +   size + 5*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size + 5*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size + 5*width*size];
            }
        }
        return pixels;
    }

    protected static Pixel[] SEVEN(PixelEngine pixelEngine, int x, int y, int size) {
        Pixel[] pixels = new Pixel[10*size*size];
        Pixel[] pixelScreen = pixelEngine.getPixels();
        int width = pixelEngine.getWidth();
        int start = x + y * width;
        int index = 0;
        for(int cols = 0; cols < size; cols++) {
            for(int rows= 0; rows < size; rows++) {
                pixels[index++] = pixelScreen[start + width*cols + rows];
                pixels[index++] = pixelScreen[start + width*cols + rows +   size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size +   width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size + 2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size + 3*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size + 4*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size + 5*width*size];
            }
        }
        return pixels;
    }

    protected static Pixel[] EIGHT(PixelEngine pixelEngine, int x, int y, int size) {
        Pixel[] pixels = new Pixel[15*size*size];
        Pixel[] pixelScreen = pixelEngine.getPixels();
        int width = pixelEngine.getWidth();
        int start = x + y * width;
        int index = 0;
        for(int cols = 0; cols < size; cols++) {
            for(int rows= 0; rows < size; rows++) {
                pixels[index++] = pixelScreen[start + width*cols + rows +   size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +            width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size +   width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +   size + 2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size + 2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size + 2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          3*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size + 3*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          4*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size + 4*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +   size + 5*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size + 5*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size + 5*width*size];
            }
        }
        return pixels;
    }

    protected static Pixel[] NINE(PixelEngine pixelEngine, int x, int y, int size) {
        Pixel[] pixels = new Pixel[15*size*size];
        Pixel[] pixelScreen = pixelEngine.getPixels();
        int width = pixelEngine.getWidth();
        int start = x + y * width;
        int index = 0;
        for(int cols = 0; cols < size; cols++) {
            for(int rows= 0; rows < size; rows++) {
                pixels[index++] = pixelScreen[start + width*cols + rows +   size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +            width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size +   width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +   size + 2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size + 2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size + 2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size + 2*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size + 3*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          4*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 4*size + 4*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +   size + 5*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size + 5*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size + 5*width*size];
            }
        }
        return pixels;
    }

    protected static Pixel[] COMMA(PixelEngine pixelEngine, int x, int y, int size) {
        Pixel[] pixels = new Pixel[3*size*size];
        Pixel[] pixelScreen = pixelEngine.getPixels();
        int width = pixelEngine.getWidth();
        int start = x + y * width;
        int index = 0;
        for(int cols = 0; cols < size; cols++) {
            for(int rows= 0; rows < size; rows++) {
                pixels[index++] = pixelScreen[start + width*cols + rows +          4*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +   size + 4*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +   size + 5*width*size];

            }
        }
        return pixels;
    }

    protected static Pixel[] DASH(PixelEngine pixelEngine, int x, int y, int size) {
        Pixel[] pixels = new Pixel[3*size*size];
        Pixel[] pixelScreen = pixelEngine.getPixels();
        int width = pixelEngine.getWidth();
        int start = x + y * width;
        int index = 0;
        for(int cols = 0; cols < size; cols++) {
            for(int rows= 0; rows < size; rows++) {
                pixels[index++] = pixelScreen[start + width*cols + rows +   size + 3*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 2*size + 3*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows + 3*size + 3*width*size];

            }
        }
        return pixels;
    }

    protected static Pixel[] PERIOD(PixelEngine pixelEngine, int x, int y, int size) {
        Pixel[] pixels = new Pixel[4*size*size];
        Pixel[] pixelScreen = pixelEngine.getPixels();
        int width = pixelEngine.getWidth();
        int start = x + y * width;
        int index = 0;
        for(int cols = 0; cols < size; cols++) {
            for(int rows= 0; rows < size; rows++) {
                pixels[index++] = pixelScreen[start + width*cols + rows +          4*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +   size + 4*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +          5*width*size];
                pixels[index++] = pixelScreen[start + width*cols + rows +   size + 5*width*size];

            }
        }
        return pixels;
    }

}
