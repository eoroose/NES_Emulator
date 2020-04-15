package Example;

import PixelEngine.*;

import java.awt.*;

public class Example {

    private final PixelEngine pixelEngine;
    private Pixel[] pixels1, pixels2, pixels3, pixels4, pixels5;

    public Example(PixelEngine pixelEngine) {
        this.pixelEngine = pixelEngine;
        init();
    }

    private void init() {
        pixels1 = PixelChars.ZERO(pixelEngine, 0, 0, 10);
        pixels2 = PixelChars.PERIOD(pixelEngine, 60, 0, 10);
        pixels3 = PixelChars.ONE(pixelEngine, 120, 0, 10);
        pixels4 = PixelChars.TWO(pixelEngine, 180, 0, 10);
        pixels5 = PixelChars.THREE(pixelEngine, 240, 0, 10);
    }

    public void tick() {
        for(Pixel pixel : pixels1) {
            pixel.setColor(new Color( (float)Math.random(), (float)Math.random(), (float)Math.random()  ));
        }
        pixelEngine.setPixels(pixels1);

        for(Pixel pixel : pixels2) {
            pixel.setColor(new Color( (float)Math.random(), (float)Math.random(), (float)Math.random()  ));
        }
        pixelEngine.setPixels(pixels2);

        for(Pixel pixel : pixels3) {
            pixel.setColor(new Color( (float)Math.random(), (float)Math.random(), (float)Math.random()  ));
        }
        pixelEngine.setPixels(pixels3);

        for(Pixel pixel : pixels4) {
            pixel.setColor(new Color( (float)Math.random(), (float)Math.random(), (float)Math.random()  ));
        }
        pixelEngine.setPixels(pixels4);

        for(Pixel pixel : pixels5) {
            pixel.setColor(new Color( (float)Math.random(), (float)Math.random(), (float)Math.random()  ));
        }
        pixelEngine.setPixels(pixels5);
    }
}