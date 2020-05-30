package App.ECS.Components;

import App.UI.Display;
import App.ECS.Component;
import App.HelpClasses.Rect;
import App.UI.TextureManager;

public class TileComponent extends Component {

    private TextureManager texture;
    private Rect position = new Rect();

    public TileComponent() {
    }

    public TileComponent(int x, int y, int srcX, int srcY, int size, int tscale, final String path) {
        position = new Rect(x, y, size * tscale, size * tscale);
        texture = new TextureManager(x, y, size * tscale, path, srcX, srcY);
        Display.getInstance().addGraphicToMap(texture);
    }

    @Override
    public void init() {

    }

    @Override
    public void update() {

    }

    @Override
    public void draw() {

    }
}
