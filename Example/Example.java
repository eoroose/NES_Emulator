package Example;

import PixelEngine.PixelEngine;

import java.awt.*;

public class Example {

    private final PixelEngine pixelEngine;

    Color[] colorTest;
    int w = 100, h = 100;

    public Example(PixelEngine pixelEngine) {
        this.pixelEngine = pixelEngine;
        colorTest = new Color[w * h];
    }

    public void tick() {

        for(int x = 0; x < w * h; x++) {
            colorTest[x] = new Color((float)Math.random(), (float)Math.random(), (float)Math.random());
        }
        pixelEngine.setColors(0, 0, w, h, colorTest);
    }


}