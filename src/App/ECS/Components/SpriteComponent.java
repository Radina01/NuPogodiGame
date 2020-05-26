package App.ECS.Components;

import App.Display;
import App.ECS.Component;
import App.TextureManager;

public class SpriteComponent extends Component {

    private TransformComponent transform;
    private int width;
    private int height;
    private String path;
    private TextureManager texture;

    public SpriteComponent() {}

    public SpriteComponent(TransformComponent transformComponent, int width, int height, final String path) {
        transform = transformComponent;
        this.width = width;
        this.height = height;
        this.path = path;
        texture = new TextureManager(transform.getX(), transform.getY(), width, height, path);
        Display.getInstance().addGraphic(texture);
    }

    @Override
    public void init() {}

    @Override
    public void update() {
        texture.setX(transform.getX());
        texture.setY(transform.getY());
    }

    @Override
    public void draw() {
        texture.render();
    }
}
