package App.ECS.Components;

import App.Display;
import App.ECS.Component;

public class TransformComponent extends Component {

    private int x;
    private int y;
    private int width;
    private int height;
    private float velX = 0;
    private float velY = 0;
    private float speed = 0.5f;
    private int position = 0;

    public TransformComponent() {
    }

    public TransformComponent(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public void init() {

    }

    @Override
    public void update() {
        x += velX * speed;
        y += velY * speed;
    }

    @Override
    public void draw() {
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
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

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public float getVelX() {
        return velX;
    }

    public float getVelY() {
        return velY;
    }
}
