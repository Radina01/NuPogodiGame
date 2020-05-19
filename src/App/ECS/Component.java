package App.ECS;

public abstract class Component {

    Entity entity;

    abstract void init();
    abstract void update();
    abstract void draw();
}
