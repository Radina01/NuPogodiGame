package App.ECS.Components;

import App.Display;
import App.ECS.Component;
import App.TextureManager;

public class SpriteComponent extends Component {

    private TransformComponent transform;
    private String path;
    private TextureManager texture;
    private int position;
    private int lastPosition;

    public SpriteComponent() {}

    public SpriteComponent(TransformComponent transformComponent, final String path) {
        transform = transformComponent;
        transform.setWidth(Display.getInstance().getWidth()/3);
        transform.setHeight(Display.getInstance().getHeight()/3);
        transform.setX(Display.getInstance().getWidth() / 2 - transform.getWidth() / 2);
        transform.setY(Display.getInstance().getHeight() - 50 - transform.getHeight());
        this.path = path;
        texture = new TextureManager(transform.getX(), transform.getY(), transform.getWidth(), transform.getHeight(), path, false, true, 32);
        Display.getInstance().addGraphic(texture);
        position = 0;
    }

    @Override
    public void init() {}

    @Override
    public void update() {
        if(position != lastPosition) {
            System.out.println(position);
            switch (position) {
                case 0: {
                    texture.setFlip(false);
                    texture.setAnimationXPosition(1);
                    break;
                }
                case 1: {
                    texture.setFlip(true);
                    texture.setAnimationXPosition(1);
                    break;
                }
                case 2: {
                    texture.setFlip(true);
                    texture.setAnimationXPosition(0);
                    break;
                }
                case 3: {
                    texture.setFlip(false);
                    texture.setAnimationXPosition(0);
                    break;
                }
            }
            lastPosition = position;
        }
    }

    @Override
    public void draw() {
        texture.render();
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
