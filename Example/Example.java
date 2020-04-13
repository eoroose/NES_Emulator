package Example;

import PixelEngine.Pixel;
import PixelEngine.PixelEngine;

import java.awt.*;

public class Example {

    private final PixelEngine pixelEngine;

    Pixel[] pixelTest;
    Color[] colorTest;
    int w = 300, h = 200;

    public Example(PixelEngine pixelEngine) {
        this.pixelEngine = pixelEngine;
        colorTest = new Color[w * h];
        pixelTest = pixelEngine.getPixels(100, 100, 100, 100);
    }

    public void tick() {
        for(Pixel pixel : pixelTest) {
            pixel.setColor(new Color((float)Math.random(), (float)Math.random(), (float)Math.random()));
        }
        pixelEngine.setPixels(pixelTest);

        for(int x = 0; x < w * h; x++) {
            colorTest[x] = new Color((float)Math.random(), (float)Math.random(), (float)Math.random());
        }
        pixelEngine.setColors(200, 200, w, h, colorTest);

    }


}