package App;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

enum GameState {
    play, menu, scoreList, exit
}

class PageManager {
    static GameState gameState = GameState.menu;
    Page playState = new Page();
    Page menuState = new Page();
    Page scoreListState = new Page();

    private int X_BUTTON_COORDINATE = Display.getInstance().width/3;

    public void initMenuState(){
        menuState.addButton(X_BUTTON_COORDINATE, Display.getInstance().height/8 + 280, X_BUTTON_COORDINATE, Display.getInstance().height/8, "Play");
        menuState.addButton(X_BUTTON_COORDINATE, Display.getInstance().height/8 * 2 + 30, X_BUTTON_COORDINATE, Display.getInstance().height/8, "Records");
        menuState.addButton(X_BUTTON_COORDINATE, Display.getInstance().height/8 * 3 + 30, X_BUTTON_COORDINATE, Display.getInstance().height/8, "Exit");
    }

    public void initPlayState() {
        //Display.initInstance(600, 600, "Nu Pogodi");
        playState.addGraphic(
                new TextureManager(50, 50, 300, 300, "assets\\sprite1.png")
        );
    }

    public void initScoreListState() {
        //Display.initInstance(600, 600, "Nu Pogodi");
        scoreListState.addGraphic(
                new TextureManager(50, 50, 300, 300, "assets\\sprite1.png")
        );
    }
}

public class Menu {
    static PageManager pageManager = new PageManager();

    public Menu() {
        pageManager.initMenuState();
        pageManager.initPlayState();
        pageManager.initScoreListState();
        Display.getInstance().changePage(pageManager.menuState);
    }

    public static void changePage() {
        switch (PageManager.gameState) {
            case menu: break;
            case play: Display.getInstance().changePage(pageManager.playState);
            case scoreList: break;
            case exit: System.exit(0);
        }
    }

    public void update() {
    }

    public static void buttonFunction(String name){
        switch (name) {
            case "Play": PageManager.gameState = GameState.play;break;
            case "Records": PageManager.gameState = GameState.scoreList;break;
            case "Exit": PageManager.gameState = GameState.exit;break;
        }
        changePage();
    }
}

class Page {

    List<JComponent> componentList = new ArrayList<>();

    public void addButton(int x, int y, int width, int height, String name) {
        JButton btn = new JButton(name);
        btn.addActionListener(e -> Menu.buttonFunction(name)) ;
        btn.setBounds(x, y, width, height);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setOpaque(false);
        panel.add(btn);
        panel.setVisible(true);
        componentList.add(panel);
    }

    public void addGraphic(TextureManager t){
        componentList.add(t);
    }

}
