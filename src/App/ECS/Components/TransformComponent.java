package App.ECS.Components;

import App.ECS.Component;

public class TransformComponent extends Component {

    private int x;
    private int y;/*
    private int width;
    private int height;*/

    public TransformComponent() {}

    public TransformComponent(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void init() {}

    @Override
    public void update() {
        x++;
        y++;
    }

    @Override
    public void draw() {}

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
