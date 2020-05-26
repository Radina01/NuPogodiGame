package App;

import App.ECS.Components.AnotherTestComponent;
import App.ECS.Components.TestComponent;
import App.ECS.Entity;
import App.ECS.Manager;

public class NuPogodi {

    public static Manager manager;
    Entity player;
    Entity obj;
    public enum groupLabels {
        groupMap,
        groupColliders,
        groupPlayer,
    }

    public void init() {
        manager = new Manager();
        player = manager.addEntity();
        obj = manager.addEntity();

    }

    public void update() {
        obj.update();
    }
}
