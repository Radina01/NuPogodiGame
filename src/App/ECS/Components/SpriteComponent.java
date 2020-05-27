package App.ECS.Components;

import App.Display;
import App.ECS.Component;
import App.TextureManager;

public class SpriteComponent extends Component {

    private TransformComponent transform;
    private String path;
    private TextureManager texture;

    public SpriteComponent() {}

    public SpriteComponent(TransformComponent transformComponent, final String path) {
        transform = transformComponent;
        transform.setWidth(Display.getInstance().getWidth()/3);
        transform.setHeight(Display.getInstance().getHeight()/3);
        transform.setX(Display.getInstance().getWidth() / 2 - transform.getWidth() / 2);
        transform.setY(Display.getInstance().getHeight() - 50 - transform.getHeight());
        this.path = path;
        texture = new TextureManager(transform.getX(), transform.getY(), transform.getWidth(), transform.getHeight(), path);
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
