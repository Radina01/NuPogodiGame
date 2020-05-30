package App.ECS.Components;

import App.Display;
import App.ECS.Component;
import App.TextureManager;

import java.util.Calendar;

public class ScoreComponent extends Component {

    private int score = 0;
    private long time = Calendar.getInstance().getTimeInMillis();
    TextureManager[] texture = new TextureManager[4];

    public ScoreComponent() {
    }

    @Override
    public void init() {
        for (int i = 0; i < 4; i++) {
            texture[i] = new TextureManager();
            Display.getInstance().addGraphic(texture[i]);
        }
    }

    @Override
    public void update() {
        if (Calendar.getInstance().getTimeInMillis() - time >= 1000) {
            score++;
            int graph = score;
            int index = 0;
            int size = Display.getInstance().getWidth() / 15;
            while (graph != 0) {
                texture[index].setX(Display.getInstance().getWidth() - size - size * index - 20);
                texture[index].setY(20);
                texture[index].setWidth(size);
                texture[index].setHeight(size);
                texture[index].setPath("assets\\" + graph % 10 + ".png");
                graph /= 10;
                index++;
            }

            time = Calendar.getInstance().getTimeInMillis();
        }
    }

    @Override
    public void draw() {
        for (int i = 0; i < 4; i++) {
            texture[i].render();
        }
    }

    public int getScore() {
        return score;
    }
}
