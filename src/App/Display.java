package App;

import javax.swing.JFrame;

public class Display {

    private static Display instance;
    JFrame frame = new JFrame();
    int width;
    int height;

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

    public void removeGraphic(int index) {
        frame.getContentPane().remove(index);
    }


}