package App.UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextField {
    JTextField nameField;


    public JPanel setTextField(int x, int y, int width, int height) {
        nameField = new JTextField();
        nameField.setBounds(x, y, width, height);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setOpaque(false);
        panel.add(nameField);
        panel.setVisible(true);
        return panel;
    }

    public void actionPerformed() {
        String nameText = nameField.getText();
        System.out.println(nameText);
        RecordsManager recordsManager = new RecordsManager();
        recordsManager.writeInFile(nameText);
    }
}
