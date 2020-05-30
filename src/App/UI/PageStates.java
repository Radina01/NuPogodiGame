package App.UI;

enum GameState {
    play, menu, scoreList, exit
}

class PageManager {
    static GameState gameState = GameState.menu;
    Page emptyPage = new Page();
    Page playState = new Page();
    Page menuState = new Page();
    Page finishGameStage = new Page();
    Page scoreListState = new Page();

    private int X_BUTTON_COORDINATE = Display.getInstance().getWidth() / 3;

    public void initFinishGameStage() {
        playState.addGraphic(new TextureManager(0, 0, Display.getInstance().getWidth(), Display.getInstance().getHeight(), "assets\\background.png", false));
        playState.addJTextArea(100, 100, 100, 50);
        playState.addButton(100, 150, 100, 50, "enter");
    }

    public void initMenuState() {
        menuState.addButton(X_BUTTON_COORDINATE,
                Display.getInstance().getHeight() / 8 + 30,
                X_BUTTON_COORDINATE,
                Display.getInstance().getHeight() / 8,
                "Play");
        menuState.addButton(X_BUTTON_COORDINATE,
                ((Display.getInstance().getHeight() / 8) * 2) + 30,
                X_BUTTON_COORDINATE,
                Display.getInstance().getHeight() / 8,
                "Records");
        menuState.addButton(X_BUTTON_COORDINATE,
                Display.getInstance().getHeight() / 8 * 3 + 30,
                X_BUTTON_COORDINATE,
                Display.getInstance().getHeight() / 8,
                "Exit");
    }

    public void initPlayState() {
        //Display.initInstance(600, 600, "Nu Pogodi");

    }

    public void initScoreListState() {
        scoreListState.addRect();
        scoreListState.addRect();
        scoreListState.addRect();
        scoreListState.addButton(X_BUTTON_COORDINATE * 2 - 20,
                Display.getInstance().getHeight() / 2 + 180,
                X_BUTTON_COORDINATE,
                Display.getInstance().getHeight() / 8,
                "Menu");
    }
}
