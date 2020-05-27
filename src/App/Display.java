package App;

import javax.swing.*;
import java.awt.event.KeyListener;

public class Display {

    private static Display instance;
    private JFrame frame = new JFrame();
    private int width;
    private int height;

    public static void initInstance(int widthSize, int heightSize, String name) {
        if(instance == null) {
            instance = new Display(widthSize, heightSize, name);
        }
    }

    public static Display getInstance() {
        return instance;
    }

    private Display(int widthSize, int heightSize, String name) {
        this.width = widthSize;
        this.height = heightSize;

        frame.setSize(widthSize, heightSize);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setTitle(name);
        frame.setResizable(true);
        frame.setVisible(true);

    }

    public void addGraphic(TextureManager t) {
        frame.getContentPane().add(t);
        frame.setVisible(true);
    }

    public void addComponent(JComponent component) {
        frame.getContentPane().add(component);
        frame.setVisible(true);
    }

    public void addKeyListener(KeyListener listener) {
        frame.getContentPane().addKeyListener(listener);
    }

    public void removeGraphic(int index) {
        frame.getContentPane().remove(index);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}