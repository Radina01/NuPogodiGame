package App;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

public class TextureManager extends JComponent {

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

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D graph = (Graphics2D) g;

        ImageIcon imageIcon = new ImageIcon(this.path);
        Image image = imageIcon.getImage();

        graph.drawImage(image, this.x, this.y, this.width, this.height, null);
    }

    public void render() {
        Thread animationThread = new Thread(new Runnable() {
            public void run() {
                repaint();
            }
        });

        animationThread.start();
    }

    public void paintRect() {

    }
}