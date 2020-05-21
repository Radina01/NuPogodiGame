package App;

import javax.swing.*;

enum GameState {
    play, menu, scoreList
}
public class Menu {
    GameState gameState;

    public Menu() {
        
    }

    public void update() {
        switch (gameState) {
            case menu: break;
            case play: break;
            case scoreList: break;
        }
    }
}
