package App;

import App.ECS.Components.*;
import App.ECS.Entity;
import App.ECS.Manager;

public class NuPogodi {

    private static Manager manager;
    Entity player;
    Entity obj;
    public enum groupLabels {
        groupMap,
        groupColliders,
        groupPlayer,
    }

    public void init() {
        Display.initInstance(600, 600, "Nu Pogodi");
        manager = new Manager();

        int width = Display.getInstance().getWidth()/3;
        int height = Display.getInstance().getHeight()/3;
        int x = Display.getInstance().getWidth() / 2 - width / 2;
        int y = Display.getInstance().getHeight() - 50 - height;
        player = manager.addEntity();

        for (int i = 0; i < 4; i++) {
            Entity e = manager.addEntity();
            e.addComponent(new TransformComponent());
            e.addComponent(new EggComponent(e.getComponent(new TransformComponent())));

        }

        player.addComponent(new TransformComponent(x, y, width, height));
        player.addComponent(new SpriteComponent(player.getComponent(new TransformComponent()), "assets\\spritean1.png", true));
        player.addComponent(new KeyboardManager(player.getComponent(new SpriteComponent())));


    }

    public void update() {
        manager.update();
    }

    public void render() {
        manager.draw();
    }
}
