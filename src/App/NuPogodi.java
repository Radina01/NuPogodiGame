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
        player = new Entity();

        player.addComponent(new TestComponent());
        player.getComponent(new TestComponent()).a = 20;
        System.out.println(player.getComponent(new TestComponent()).a);


        //System.out.println(groupLabels.groupColliders.ordinal());
    }

    public void update() {
        obj.getComponent(new AnotherTestComponent()).update();
    }
}
