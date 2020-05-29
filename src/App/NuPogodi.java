package App;

import App.ECS.Components.*;
import App.ECS.Entity;
import App.ECS.Manager;

import java.util.List;

public class NuPogodi {

    public static Manager manager;
    private Map map;
    private Entity[] eggs = new Entity[20];
    Entity player;
    Entity obj;
    public enum groupLabels {
        groupStartPosition,
        groupColliders,
        groupPlayer,
        groupMap
    }

    public void init() {
        Display.initInstance(780, 600, "Nu Pogodi");
        manager = new Manager();
        map = new Map("assets/mapTileSet.png", 1, 64);
        map.loadMap("assets/mapFile.txt", 7, 12);

        System.out.println(manager.getGroup(groupLabels.groupStartPosition.ordinal()).size());
        for (Entity e: manager.getGroup(groupLabels.groupStartPosition.ordinal())) {
            System.out.println(e.getComponent(new TransformComponent()).getPosition().x + " " + e.getComponent(new TransformComponent()).getPosition().y);
        }

        for (int i = 0; i < 20; i++) {
            eggs[i] = manager.addEntity();
            eggs[i].addComponent(new TransformComponent());
            eggs[i].addComponent(new PositionComponent());
            eggs[i].addComponent(new EggComponent(
                    eggs[i].getComponent(new TransformComponent()),
                    eggs[i].getComponent(new PositionComponent())
            ));
            eggs[i].getComponent(new EggComponent()).drop();
            eggs[i].addComponent(new SpriteComponent(
                    eggs[i].getComponent(new TransformComponent()),
                    "assets/sprite1.png"
            ));
        }
/*
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
        player.addComponent(new SpriteComponent(player.getComponent(new TransformComponent()), "assets\\spritean1.png"));
        player.addComponent(new KeyboardManager(player.getComponent(new SpriteComponent())));

*/
    }

    public void update() {
        manager.update();
    }

    public void render() {
        manager.draw();
    }
}
