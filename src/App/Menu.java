package App;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

enum GameState {
    play, menu, scoreList
}

class PageManager {
    GameState gameState;
    Page playState = new Page();
    Page menuState = new Page();
    Page scoreListState = new Page();
    private int X_BUTTON_COORDINATE = Display.getInstance().width/3;

    public void initMenuState(){
        menuState.addButton(X_BUTTON_COORDINATE, Display.getInstance().height/8 + 280, X_BUTTON_COORDINATE, Display.getInstance().height/8, "Play");
        menuState.addButton(X_BUTTON_COORDINATE, Display.getInstance().height/8 * 2 + 30, X_BUTTON_COORDINATE, Display.getInstance().height/8, "Play");
        menuState.addButton(X_BUTTON_COORDINATE, Display.getInstance().height/8 * 3 + 30, X_BUTTON_COORDINATE, Display.getInstance().height/8, "Play");
    }
}

public class Menu {
    PageManager pageManager = new PageManager();

    public Menu() {
        pageManager.initMenuState();
    }

    public void update() {
        switch (pageManager.gameState) {
            case menu: break;
            case play: break;
            case scoreList: break;
        }
    }
}

class Page {

    List<JComponent> componentList = new ArrayList<>();

    public void addButton(int x, int y, int width, int height, String name) {
        JButton btn = new JButton(name);
       // btn.addActionListener();
        btn.setBounds(x, y, width, height);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setOpaque(false);
        panel.add(btn);
        componentList.add(panel);
    }

    public void addGraphic() {

    }
}
