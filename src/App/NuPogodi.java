package App;

import App.ECS.Components.AnotherTestComponent;
import App.ECS.Components.TestComponent;
import App.ECS.Entity;

public class NuPogodi {

    Entity player;
    Entity obj;

    public void init() {
        player = new Entity();
        player.addComponent(new TestComponent());
        System.out.println(player.hasComponent(new AnotherTestComponent()));
        System.out.println(player.hasComponent(new TestComponent()));
        player.addComponent(new TestComponent());
    }

    public void update() {
        obj.getComponent(new AnotherTestComponent()).update();
    }
}
