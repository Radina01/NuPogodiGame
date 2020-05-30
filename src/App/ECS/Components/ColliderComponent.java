package App.ECS.Components;

import App.ECS.Component;
import App.HelpClasses.Rect;


public class ColliderComponent extends Component {

    private Rect rect = new Rect();



    public ColliderComponent() {}

    public ColliderComponent(Rect rect){
        this.rect = rect;
    }

    public Rect getCollider() {
        return rect;
    }

    public void setCollider(Rect rect) {
        this.rect = rect;
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
