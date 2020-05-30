package App;

import javax.swing.*;

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
        RecordsManager recordsManager = new RecordsManager();
        recordsManager.writeInFile(nameText);
    }
}
