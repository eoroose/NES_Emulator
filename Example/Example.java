package Example;

import PixelEngine.PixelEngine;
import PixelString.PixelString;

import java.awt.*;

public class Example {

    private final PixelEngine pixelEngine;
    PixelString pixelString1, pixelString2, pixelString3;
    Color[] colors = new Color[300 * 250];

    public Example(PixelEngine pixelEngine) {
        this.pixelEngine = pixelEngine;
        init();
    }

    private void init() {
        pixelString1 = new PixelString(pixelEngine, 0, 0, 3, "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        pixelString1.setPixelColor(Color.RED);

        pixelString2 = new PixelString(pixelEngine, 0, 6*3, 3, "abcdefghijklmnopqrstuvwxyz");
        pixelString2.setPixelColor(Color.GREEN);

        pixelString3 = new PixelString(pixelEngine, 0, 6*3*2, 5, "012-345,678.9 00  0");
    }

    public void tick() {
        pixelString1.showPixelString();
        pixelString2.showPixelString();

        pixelString3.setPixelColor(new Color((float)Math.random(), (float)Math.random(), (float)Math.random()));
        pixelString3.showPixelString();

        for(int x = 0; x < colors.length; x++)
            colors[x] = new Color((float)Math.random(), (float)Math.random(), (float)Math.random());

        pixelEngine.setColors(200, 200, 300, 250, colors);
    }
}