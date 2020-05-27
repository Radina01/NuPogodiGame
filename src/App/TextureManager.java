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
    private boolean flip;
    private boolean animated;
    private int spriteSize;
    private int animationXPosition = 0;
    private int animationYPosition = 0;

    TextureManager() {
    }

    public TextureManager(int x, int y, int width, int height, String path, boolean flip) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.path = path;
        this.flip = flip;
        this.animated = false;
    }

    public TextureManager(int x, int y, int width, int height, String path, boolean flip, boolean isAnimated, int size) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.path = path;
        this.flip = flip;
        this.animated = isAnimated;
        spriteSize = size;
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D graph = (Graphics2D) g;

        ImageIcon imageIcon = new ImageIcon(this.path);
        Image image = imageIcon.getImage();

        int animationX = animationXPosition * spriteSize;
        int animationY = animationYPosition * spriteSize;

        if(animated) {
            if(!flip) graph.drawImage(image, this.x, this.y, width + this.x, this.height + this.y, animationX, animationY, animationX + spriteSize, animationY + spriteSize, null);
            else graph.drawImage(image, this.x + this.width, this.y, this.x, this.height + this.y, animationX, animationY, animationX + spriteSize, animationY + spriteSize, null);
        } else {
            if(!flip) graph.drawImage(image, this.x, this.y, this.width, this.height, null);
            else graph.drawImage(image, this.x + width, this.y, -this.width, this.height, null);
        }

    }

    public void render() {
        Thread animationThread = new Thread(new Runnable() {
            public void run() {
                repaint();
            }
        });

        animationThread.start();
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setFlip(boolean flip) {
        this.flip = flip;
    }

    public void setAnimationXPosition(int animationXPosition) {
        this.animationXPosition = animationXPosition;
        System.out.println(animationXPosition);
    }

    public void setAnimationYPosition(int animationYPosition) {
        this.animationYPosition = animationYPosition;
    }
}