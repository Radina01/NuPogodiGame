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
        this.path = path;
        texture = new TextureManager(transform.getPosition().x, transform.getPosition().y, transform.getPosition().width, transform.getPosition().height, path, false, true, 32);
        Display.getInstance().addGraphic(texture);
    }

    @Override
    public void init() {}

    @Override
    public void update() {
        texture.setX(transform.getPosition().x);
        texture.setY(transform.getPosition().y);
    }

    @Override
    public void draw() {
        texture.render();
    }

}