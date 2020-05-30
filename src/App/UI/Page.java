package App.UI;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Page {
    List<JComponent> componentList = new ArrayList<>();

    public void addButton(int x, int y, int width, int height, String name) {
        JButton btn = new JButton(name);
        btn.addActionListener(e -> Menu.buttonFunction(name));
        btn.setBounds(x, y, width, height);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setOpaque(false);
        panel.add(btn);
        panel.setVisible(true);
        componentList.add(panel);
    }

    public void addGraphic(TextureManager t) {
        componentList.add(t);
    }

    public void addRect() {
        componentList.add(new Rectangle());
    }

    public void addJTextArea(int x, int y, int width, int height) {
        TextField textField = new TextField();
        componentList.add(textField.setTextField(x, y, width, height));
        textField.actionPerformed();
    }
}
