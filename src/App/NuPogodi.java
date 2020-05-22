package App;

import App.ECS.ComponentList;
import App.ECS.Components.AnotherTestComponent;
import App.ECS.Components.TestComponent;
import App.ECS.Entity;

public class NuPogodi {

    Entity player;

    public void init() {
        player = new Entity();
        player.addComponent(new TestComponent());
        player.addComponent(new AnotherTestComponent());

        System.out.println(
                player.<TestComponent>getComponent(ComponentList.TestComponent).getA()
        );
    }

    public void update() {}
}
