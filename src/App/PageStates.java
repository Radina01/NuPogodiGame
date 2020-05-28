package App;

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
        menuState.addButton(X_BUTTON_COORDINATE,
                Display.getInstance().height / 8 + 30,
                X_BUTTON_COORDINATE,
                Display.getInstance().height / 8,
                "Play");
        menuState.addButton(X_BUTTON_COORDINATE,
                ((Display.getInstance().height / 8) * 2) + 30,
                X_BUTTON_COORDINATE,
                Display.getInstance().height / 8,
                "Records");
        menuState.addButton(X_BUTTON_COORDINATE,
                Display.getInstance().height / 8 * 3 + 30,
                X_BUTTON_COORDINATE,
                Display.getInstance().height / 8,
                "Exit");
    }

    public void initPlayState() {
        //Display.initInstance(600, 600, "Nu Pogodi");
        playState.addGraphic(
                new TextureManager(50, 50, 300, 300, "assets\\sprite1.png")
        );
        playState.addJTextArea(100, 100, 100, 50);
    }

    public void initScoreListState() {
        scoreListState.addRect();
        scoreListState.addRect();
        scoreListState.addRect();
        scoreListState.addButton(X_BUTTON_COORDINATE * 2 - 20,
                Display.getInstance().height / 2 + 180,
                X_BUTTON_COORDINATE,
                Display.getInstance().height / 8,
                "Menu");
    }
}
