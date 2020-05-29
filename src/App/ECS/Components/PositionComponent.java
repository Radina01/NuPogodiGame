package App.ECS.Components;

import App.ECS.Component;

public class PositionComponent extends Component {

    private int position;

    public PositionComponent() {}

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
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
