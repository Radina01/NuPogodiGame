package App.ECS.Components;

import App.Display;
import App.ECS.Component;
import App.TextureManager;

import java.util.HashMap;

public class SpriteComponent extends Component {

    private TransformComponent transform;
    private String path;
    private TextureManager texture;
    private int lastPosition;

    public HashMap<String, Animation> animations = new HashMap<>();

    private boolean animated = false;
    private int frames = 0;
    private int speed = 100;
    public int animIndex = 0;

    public SpriteComponent() {}

    public SpriteComponent(TransformComponent transformComponent, final String path, boolean isAnimated) {
        animated = isAnimated;

        Animation one = new Animation(0, 1, 1);
        Animation two = new Animation(1, 1, 1);
        Animation three = new Animation(3, 1, 1);
        Animation four = new Animation(4, 1, 1);

        animations.put("one", one);
        animations.put("two", two);
        animations.put("three", three);
        animations.put("four", four);

        transform = transformComponent;
        this.path = path;
        texture = new TextureManager(transform.getPosition().x, transform.getPosition().y, transform.getPosition().width, transform.getPosition().height, path, false, true, 32);
    }

    @Override
    public void init() {}

    @Override
    public void update() {
    }

    @Override
    public void draw() {
        texture.render();
    }

    public void Play(final String animName) {
        frames = animations.get(animName).frames;
        animIndex = animations.get(animName).index;
        speed = animations.get(animName).speed;

    }
}


class Animation {
    int index;
    int frames;
    int speed;
    Animation() {}
    Animation(int i, int f, int s) {
        index = i;
        frames = f;
        speed = s;
    }
}