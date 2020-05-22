package App.ECS.Components;

import App.ECS.Component;

public class TestComponent extends Component {

    public TestComponent() {
        System.out.println("testComponent added");
    }

    public int a = 15;

    @Override
    public void init() {}

    @Override
    public void update() {
        System.out.println(a);
    }

    @Override
    public void draw() {}

    public int getA() {
        return a;
    }
}
