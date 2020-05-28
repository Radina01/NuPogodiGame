package App;

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
                Display.getInstance().changePage(pageManager.menuState);
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
            case "Menu":
                PageManager.gameState = GameState.menu;
                break;
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
