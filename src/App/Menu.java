package App;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

enum GameState {
    play, menu, scoreList, exit
}

class PageManager {
    static GameState gameState = GameState.menu;
    Page emptyPage = new Page();
    Page playState = new Page();
    Page menuState = new Page();
    Page scoreListState = new Page();

    private int X_BUTTON_COORDINATE = Display.getInstance().width / 3;

    public void initMenuState() {
        menuState.addButton(X_BUTTON_COORDINATE, Display.getInstance().height / 8 + 30, X_BUTTON_COORDINATE, Display.getInstance().height / 8, "Play");
        menuState.addButton(X_BUTTON_COORDINATE, Display.getInstance().height / 8 * 2 + 30, X_BUTTON_COORDINATE, Display.getInstance().height / 8, "Records");
        menuState.addButton(X_BUTTON_COORDINATE, Display.getInstance().height / 8 * 3 + 30, X_BUTTON_COORDINATE, Display.getInstance().height / 8, "Exit");
    }

    public void initPlayState() {
        //Display.initInstance(600, 600, "Nu Pogodi");
        playState.addGraphic(
                new TextureManager(50, 50, 300, 300, "assets\\sprite1.png")
        );
    }

    public void initScoreListState() {
        scoreListState.addRect();
        scoreListState.addRect();
        scoreListState.addRect();
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
        Display.getInstance().changePage(pageManager.emptyPage);
        switch (PageManager.gameState) {
            case menu:
                break;
            case play:
                Display.getInstance().changePage(pageManager.playState);
                break;
            case scoreList:
                Display.getInstance().changePage(pageManager.scoreListState);
                break;
            case exit:
                System.exit(0);
        }
    }

    public void update() {
    }

    public static void buttonFunction(String name) {
        switch (name) {
            case "Play":
                PageManager.gameState = GameState.play;
                break;
            case "Records":
                PageManager.gameState = GameState.scoreList;
                break;
            case "Exit":
                PageManager.gameState = GameState.exit;
                break;
        }
        changePage();
    }
}

class Page {

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
        componentList.add(new Rect());
    }
}

class Rect extends JComponent {
    final int width = 400;
    final int height = 50;
    static int numberOfList = 1;
    final int x = (Display.getInstance().width - width) / 2;
    int y = 100 + height * numberOfList + 15 * numberOfList;

    public Rect() {
        numberOfList++;
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D graph = (Graphics2D) g;
        graph.setColor(Color.LIGHT_GRAY);
        graph.fillRect(x, y, width, height);
        graph.setColor(Color.BLACK);
        graph.drawString("PESHO", (x + width)/2, y + height/2);
    }
}
