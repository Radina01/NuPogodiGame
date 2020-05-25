package App;

import App.ECS.Components.AnotherTestComponent;
import App.ECS.Components.TestComponent;
import App.ECS.Entity;
import App.ECS.Manager;

public class NuPogodi {

    Manager manager;
    Entity player;
    Entity obj;
    public enum groupLabels {
        groupMap,
        groupColliders,
        groupPlayer,
    }

    public void init() {
        manager = new Manager();
        player = new Entity(manager);

        System.out.println(groupLabels.groupColliders.ordinal());
    }

    public void update() {
        obj.getComponent(new AnotherTestComponent()).update();
    }
}
