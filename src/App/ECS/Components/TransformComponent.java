package App.ECS.Components;

import App.ECS.Component;
import App.Rect;

public class TransformComponent extends Component {

    private Rect position = new Rect();
    private float velX = 0;
    private float velY = 0;
    private float speed = 1f;

    public TransformComponent() {
    }

    public TransformComponent(int x, int y, int width, int height) {
        position = new Rect(x, y, width, height);
    }

    @Override
    public void init() {

    }

    @Override
    public void update() {
        position.x += velX * speed;
        position.y += velY * speed;
    }

    @Override
    public void draw() {
    }

    public Rect getPosition() {
        return position;
    }

    public void setPosition(Rect position) {
        this.position = position;
    }

    public void setX(int x) {
        position.x = x;
    }

    public void setY(int y) {
        position.y = y;
    }

    public void setWidth(int width) {
        position.width = width;
    }

    public void setHeight(int height) {
        position.height = height;
    }

    public void setVelX(float velX) {
        this.velX = velX;
    }

    public void setVelY(float velY) {
        this.velY = velY;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getSpeed() {
        return speed;
    }

    public float getVelX() {
        return velX;
    }

    public float getVelY() {
        return velY;
    }
}
