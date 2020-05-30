package App.ECS.Components;

import App.Display;
import App.ECS.Component;
import App.TextureManager;

import java.util.Calendar;

public class LiveComponent extends Component {

    private int lives = 3;
    private TextureManager[] textures = new TextureManager[3];

    public LiveComponent() {
    }


    @Override
    public void init() {
        for (int i = 0; i < lives; i++) {
            textures[i] = new TextureManager();
        }
    }

    public void reduceLife() {
        lives-=1;
    }

    @Override
    public void update() {
        int size = Display.getInstance().getWidth() / 15;
        for (int i = 0; i < 3; i++) {
            textures[0].setX(5000);
        }
        for (int i = 0; i < lives; i++) {
            textures[i].setHeight(size);
            textures[i].setWidth(size);
            textures[i].setX(20 + size + size * i);
            textures[i].setPath("assets\\sprite1.png");
            Display.getInstance().addGraphic(textures[i]);
        }
    }

    @Override
    public void draw() {
        for (int i = 0; i < 3; i++) {
            textures[i].render();
        }
    }
}
