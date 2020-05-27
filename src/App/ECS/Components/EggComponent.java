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

        //texture = new TextureManager(transform.getX(), transform.getY(), transform.getWidth(), transform.getHeight(), "assets\\sprite2.png", false);
    }

    private void setUpTransformComponent(int xPos, int yPos) {

    }

    @Override
    public void update() {/*
        texture.setX(transform.getX());
        texture.setY(transform.getY());


        if (transform.getX() >= Display.getInstance().getWidth() / 2 - ((Display.getInstance().getWidth() / 3) / 2)
                && transform.getX() <= Display.getInstance().getWidth() / 2 + ((Display.getInstance().getWidth() / 3) / 2)
                && transform.getVelX() != 0) {
            transform.setVelX(transform.getVelX() - 0.1f);
        }

        transform.setVelY(transform.getVelY() + (transform.getVelX() == 0 ? 0.2f : 0.1f));

        if(transform.getY() > Display.getInstance().getHeight()) {
            System.gc();
        }*/
    }

    @Override
    public void draw() {
    }
}
