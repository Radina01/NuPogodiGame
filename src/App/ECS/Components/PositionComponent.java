package App.ECS.Components;

import App.ECS.Component;
import App.Rect;

import java.util.ArrayList;
import java.util.List;

public class PositionComponent extends Component {

    private int position;
    private int lastPosition;
    private List<Rect> positions = new ArrayList<>();
    private TransformComponent transform;

    public PositionComponent() {}
    public PositionComponent(TransformComponent transform) {
        this.transform = transform;
    }

    @Override
    public void init() {

    }

    @Override
    public void update() {
        if(position != lastPosition) {
            transform.setPosition(positions.get(position));
            lastPosition = position;
        }
    }

    @Override
    public void draw() {

    }

    public int getPosition() {
        return position;
    }

    public void addPosition(Rect rect) {
        positions.add(rect);
    }
    public void addPosition(int x, int y, int width, int height) {
        positions.add(new Rect(x, y, width, height));
    }

    public List<Rect> getPositions() {
        return positions;
    }

}
