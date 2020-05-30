package App.UI;

import javax.swing.*;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class Display {

    private static Display instance;
    private JFrame frame = new JFrame();
    private int width;
    private int height;
    private List<JComponent> mapLayer = new ArrayList<>();
    private List<JComponent> gameLayer = new ArrayList<>();

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

    public void addGraphicToMap(TextureManager t) {
        mapLayer.add(t);
    }

    public void addGraphic(TextureManager t) {
        gameLayer.add(t);
    }

    public void printAllGraphics() {
        for (JComponent component : gameLayer) {
            frame.getContentPane().add(component);
            frame.setVisible(true);
        }
        for (JComponent component : mapLayer) {
            frame.getContentPane().add(component);
            frame.setVisible(true);
        }
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

    public void changePage(Page page) {
        for (int i = 0; i < frame.getContentPane().getComponentCount(); i++) {
            frame.getContentPane().remove(i);
        }
        for (int i = 0; i < page.componentList.size(); i++) {
            frame.getContentPane().add(page.componentList.get(i));
            frame.setVisible(true);
        }
    }
}