package App.ECS.Components;

import App.ECS.Component;
import App.ECS.Entity;
import App.NuPogodi;

import java.util.List;


public class EggComponent extends Component {

    private TransformComponent transform;
    private PositionComponent position;
    private List<Entity> startPositions = NuPogodi.manager.getGroup(NuPogodi.groupLabels.groupStartPosition.ordinal());
    private boolean dropped = false;
    private final int DEFAULT_X = 5000;
    private final int DEFAULT_Y = 5000;

    public EggComponent() {
    }

    public EggComponent(TransformComponent transformComponent, PositionComponent position) {
        transform = transformComponent;
        transform.setWidth(30);
        transform.setHeight(30);
        this.position = position;
    }

    @Override
    public void init() {
        remove();
    }

    public void drop() {
        dropped = true;
        position.setPosition((int)(Math.random() * 4));
        TransformComponent t = startPositions.get(position.getPosition()).getComponent(new TransformComponent());
        switch (position.getPosition()) {
            case 1:
            case 3: {
                transform.setX(t.getPosition().x + t.getPosition().width);
                transform.setY(t.getPosition().y);
                transform.setVelX(-1);
                transform.setVelY(1);
                break;
            }
            case 0:
            case 2: {
                transform.setX(t.getPosition().x);
                transform.setY(t.getPosition().y);
                transform.setVelX(1);
                transform.setVelY(1);
                break;
            }
        }
        //System.out.println(transform.getPosition().x + " " + transform.getPosition().y);
    }

    public void remove() {
        dropped = false;
        transform.setX(DEFAULT_X);
        transform.setY(DEFAULT_Y);
        transform.setVelX(0);
        transform.setVelY(0);
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

    public boolean isDropped() {
        return dropped;
    }
}
