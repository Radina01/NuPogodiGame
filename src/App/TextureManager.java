package App;

import javax.swing.*;

public class TextureManager {

    private int x;
    private int y;
    private int width;
    private int height;
    private String path;

    TextureManager() {
    }

    public TextureManager(int x, int y, int width, int height, String path) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.path = path;
    }
}