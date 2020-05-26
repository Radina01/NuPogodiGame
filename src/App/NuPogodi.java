package App;

import App.ECS.Components.AnotherTestComponent;
import App.ECS.Components.SpriteComponent;
import App.ECS.Components.TestComponent;
import App.ECS.Components.TransformComponent;
import App.ECS.Entity;
import App.ECS.Manager;

public class NuPogodi {

    private static Manager manager;
    Entity player;
    Entity obj;
    public enum groupLabels {
        groupMap,
        groupColliders,
        groupPlayer,
    }

    public void init() {
        Display.initInstance(600, 600, "Nu Pogodi");
        manager = new Manager();
        player = manager.addEntity();

        player.addComponent(new TransformComponent());
        player.addComponent(new SpriteComponent(player.getComponent(new TransformComponent()), 50, 50, "assets\\sprite1.png"));


    }

    public void update() {
        manager.update();
    }

    public void render() {
        manager.draw();
    }
}
