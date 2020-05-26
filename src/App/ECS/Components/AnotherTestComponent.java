package App.ECS.Components;

import App.ECS.Component;

public class AnotherTestComponent extends Component {

    TestComponent testComponent;

    public AnotherTestComponent() {
        //System.out.println("anotherTestComponent added");
    }
    public AnotherTestComponent(TestComponent t) {
        testComponent = t;
    }

    public void getA() {
        System.out.println(testComponent.getA());
    }

    @Override
    public void init() {
    }

    @Override
    public void update() {
    }

    @Override
    public void draw() {}
}
