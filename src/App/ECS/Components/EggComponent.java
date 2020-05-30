package App.ECS.Components;

import App.UI.Display;
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
        position.setPosition((int) (Math.random() * 4));
        TransformComponent t = startPositions.get(position.getPosition()).getComponent(new TransformComponent());
        switch (position.getPosition()) {
            case 1:
            case 3: {
                transform.setX(t.getPosition().x + t.getPosition().width);
                transform.setY(t.getPosition().y);
                transform.setVelX(-1.25f);
                transform.setVelY(1);
                break;
            }
            case 0:
            case 2: {
                transform.setX(t.getPosition().x);
                transform.setY(t.getPosition().y);
                transform.setVelX(1.25f);
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
    public void update() {
        if(transform.getPosition().y > Display.getInstance().getHeight()) {
            remove();
            //NuPogodi.manager.getGroup(NuPogodi.groupLabels.groupPlayer.ordinal()).get(0).getComponent(new LiveComponent()).reduceLife();
        }
    }

    @Override
    public void draw() {
    }

    public boolean isDropped() {
        return dropped;
    }
}
