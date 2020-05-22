package App.ECS;

public abstract class Component {

    Entity entity;

    public abstract void init();
    public abstract void update();
    public abstract void draw();
}
