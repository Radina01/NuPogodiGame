package App;

import javax.swing.*;
import java.awt.*;

public class Rectangle extends JComponent {
    final int width = 400;
    final int height = 50;
    static int numberOfList = 1;
    final int x = (Display.getInstance().width - width) / 2;
    int y = 100 + height * numberOfList + 15 * numberOfList;

    public Rectangle() {
        numberOfList++;
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D graph = (Graphics2D) g;
        graph.setColor(Color.LIGHT_GRAY);
        graph.fillRect(x, y, width, height);
        graph.setColor(Color.BLACK);
        graph.drawString("PESHO", (x + width) / 2 - 50, y + height / 2);
        graph.drawString("GOSHO", (x + width) - 100, (y + height / 2));

    }
}
