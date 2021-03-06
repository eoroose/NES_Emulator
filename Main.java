import java.nio.IntBuffer;
import java.util.Objects;

import Emulator.Emulator;
import InputHandler.Keyboard;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;
import org.lwjgl.system.MemoryStack;
import PixelEngine.PixelEngine;

import static org.lwjgl.opengles.GLES20.*;
import static org.lwjgl.system.MemoryStack.*;
import static org.lwjgl.system.MemoryUtil.*;

public class Main {

    private long window;
    private GLFWKeyCallback keyCallback;
    private final int WIDTH, HEIGHT, SIZE;
    private PixelEngine pixelEngine;
    private Emulator emulator;

    public Main(int WIDTH, int HEIGHT, int SIZE) {
        if(WIDTH%SIZE != 0 || HEIGHT%SIZE != 0) System.exit(0);
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        this.SIZE = SIZE;
    }

    public void run() {
        setup();
        loop();
        Callbacks.glfwFreeCallbacks(window);
        GLFW.glfwDestroyWindow(window);

        GLFW.glfwTerminate();
        Objects.requireNonNull(GLFW.glfwSetErrorCallback(null)).free();
    }

    public void setup() {
        GLFWErrorCallback.createPrint(System.err).set();

        if(!GLFW.glfwInit()) {
            throw new IllegalStateException("Unable to initialize GLFW");
        }

        GLFW.glfwDefaultWindowHints();
        GLFW.glfwWindowHint(GLFW.GLFW_VISIBLE, GLFW.GLFW_FALSE);
        GLFW.glfwWindowHint(GLFW.GLFW_RESIZABLE, GLFW.GLFW_FALSE);

        window = GLFW.glfwCreateWindow(WIDTH, HEIGHT, "NES Emulator", NULL, NULL);
        if(window == NULL) {
            throw new IllegalStateException("Unable to create GLFW Window");
        }

        GLFW.glfwSetKeyCallback(window, keyCallback = new Keyboard());

        try(MemoryStack stack = stackPush()){
            IntBuffer pWidth = stack.mallocInt(1);
            IntBuffer pHeight = stack.mallocInt(1);

            GLFW.glfwGetWindowSize(window, pWidth, pHeight);

            GLFWVidMode vidmode = GLFW.glfwGetVideoMode(GLFW.glfwGetPrimaryMonitor());

            assert vidmode != null;
            GLFW.glfwSetWindowPos(window,(vidmode.width() - pWidth.get(0)) / 2,(vidmode.height() - pHeight.get(0)) / 2);

            GLFW.glfwMakeContextCurrent(window);
            GLFW.glfwSwapInterval(1);
            GLFW.glfwShowWindow(window);
        }
    }

    public void loop() {
        GL.createCapabilities();
        init();

        int fps = 60;
        int ticks = 0;
        double delta = 0;
        double timePerTick = 1000000000.0 / fps;
        long now;
        long timer = 0;
        long lastTime = System.nanoTime();

        while(!GLFW.glfwWindowShouldClose(window)) {

            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if (delta >= 1) {
                tick();
                render();
                ticks++;
                delta--;
            }
            if (timer >= 1000000000) {
                System.out.println("fps: " + ticks);
                ticks = 0;
                timer = 0;
            }
        }
    }

    private void init() {
        pixelEngine = new PixelEngine(WIDTH, HEIGHT, SIZE);
        emulator = new Emulator(pixelEngine);
    }

    private void tick() {
        pixelEngine.tick();
        emulator.tick();
    }

    private void render() {
        GL11.glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
        pixelEngine.render();
        GLFW.glfwSwapBuffers(window);
        GLFW.glfwPollEvents();
    }

    public static void main(String[] args) {
        new Main(680, 680, 1).run();
    }
}