package App.ECS.Components;

import App.UI.Display;
import App.ECS.Component;
import App.UI.TextureManager;

public class LiveComponent extends Component {

    private int lives = 3;
    private TextureManager[] textures = new TextureManager[3];

    public LiveComponent() {
    }


    @Override
    public void init() {
        int size = Display.getInstance().getWidth() / 15;
        for (int i = 0; i < lives; i++) {
            textures[i] = new TextureManager();
            textures[i].setX(5000);
            textures[i].setY(20);
            textures[i].setHeight(size);
            textures[i].setWidth(size);
            textures[i].setPath("assets\\heart.png");
            Display.getInstance().addGraphic(textures[i]);

        }
    }

    public void reduceLife() {
        lives-=1;
    }

    public int getLives() {
        return lives;
    }

    @Override
    public void update() {
        int size = Display.getInstance().getWidth() / 15;
        for (int i = 0; i < 3; i++) {
            textures[i].setX(5000);
        }
        for (int i = 0; i < lives; i++) {
            textures[i].setX(20 + size + size * i);
        }
    }

    @Override
    public void draw() {
        for (int i = 0; i < 3; i++) {
            textures[i].render();
        }
    }
}
