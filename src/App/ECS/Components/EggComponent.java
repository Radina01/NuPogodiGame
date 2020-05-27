package App.ECS.Components;

import App.Display;
import App.ECS.Component;
import App.TextureManager;

public class EggComponent extends Component {

    private TransformComponent transform;
    private TextureManager texture;

    public EggComponent() {
    }

    public EggComponent(TransformComponent transformComponent) {
        transform = transformComponent;
    }

    @Override
    public void init() {
        int width = Display.getInstance().getWidth() / 3;
        int height = Display.getInstance().getHeight() / 3;
        transform.setWidth(width / 10);
        transform.setHeight(height / 10);
        switch (transform.getPosition()) {
            case 0: {
                transform.setX(Display.getInstance().getWidth() / 2 + width / 2 + ((width * 2) / 3));
                transform.setY(Display.getInstance().getHeight() - 50 - 2 * height);
                transform.setVelX(-1);
                transform.setVelY(1);
                break;
            }
            case 1: {
                transform.setX(Display.getInstance().getWidth() / 2 - width / 2 - ((width * 2) / 3));
                transform.setY(Display.getInstance().getHeight() - 50 - 2 * height);
                transform.setVelX(1);
                transform.setVelY(1);
                break;
            }
            case 2: {
                transform.setX(Display.getInstance().getWidth() / 2 - width / 2 - ((width * 2) / 3));
                transform.setY(Display.getInstance().getHeight() - 50 - ((height)));
                transform.setVelX(1);
                transform.setVelY(1);
                break;
            }
            case 3: {
                transform.setX(Display.getInstance().getWidth() / 2 + width / 2 + ((width * 2) / 3));
                transform.setY(Display.getInstance().getHeight() - 50 - ((height)));
                transform.setVelX(-1);
                transform.setVelY(1);
                break;
            }
        }
        texture = new TextureManager(transform.getX(), transform.getY(), transform.getWidth(), transform.getHeight(), "assets\\sprite2.png", false);
        System.out.println(transform.getPosition() + " " + transform.getX() + " " + transform.getY());
    }

    @Override
    public void update() {
        texture.setX(transform.getX());
        texture.setY(transform.getY());

        if (transform.getX() >= Display.getInstance().getWidth() / 2 - ((Display.getInstance().getWidth() / 3) / 2)
                && transform.getX() <= Display.getInstance().getWidth() / 2 + ((Display.getInstance().getWidth() / 3) / 2)
                && transform.getVelX() != 0){
            transform.setVelX(transform.getVelX() - 0.1f);
        }

        transform.setVelY(transform.getVelY() + (transform.getVelX() == 0 ? 0.2f : 0.1f));


    }

    @Override
    public void draw() {
        texture.render();
    }
}
