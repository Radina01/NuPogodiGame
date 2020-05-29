package App.ECS.Components;

import App.ECS.Component;
import App.Rect;


public class ColliderComponent extends Component {

    private Rect rect = new Rect();
    TransformComponent transform;


    public ColliderComponent() {}

    public ColliderComponent(TransformComponent transform) {

    }



    @Override
    public void init() {

    }

    @Override
    public void update() {

    }

    @Override
    public void draw() {

    }
}
