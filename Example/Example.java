package Example;

import PixelEngine.*;

import java.awt.*;

public class Example {

    private final PixelEngine pixelEngine;
    private Pixel[] pixels;

    public Example(PixelEngine pixelEngine) {
        this.pixelEngine = pixelEngine;
        init();
    }

    private void init() {
        pixels = PixelChars.ZERO(pixelEngine, 0, 0, 50);
    }

    public void tick() {
        for(Pixel pixel : pixels) {
            pixel.setColor(new Color( (float)Math.random(),(float)Math.random(), (float)Math.random()  ));
        }
        pixelEngine.setPixels(pixels);
    }
}