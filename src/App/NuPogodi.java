package App;

import App.ECS.Components.*;
import App.ECS.Entity;
import App.ECS.Manager;
import App.HelpClasses.Collide;
import App.UI.Display;
import App.UI.Menu;

import java.util.Calendar;

public class NuPogodi {

    public static Manager manager;
    private Map map;
    private Menu menu;
    public static boolean GamePlay = true;
    Entity player;
    private long time = Calendar.getInstance().getTimeInMillis();
    private int difficulty = 10000;

    public enum groupLabels {
        groupStartPosition,
        groupCatchPosition,
        groupColliders,
        groupPlayer,
        groupMap
    }

    public void init() {
        Display.initInstance(780, 480, "Nu Pogodi");
        manager = new Manager();
        player = manager.addEntity();
        //menu = new Menu();



        map = new Map("assets/mapTileSet.png", 1, 64);
        map.loadMap("assets/mapFile.txt", 7, 12);

        int size = 256;
        int playerX = (Display.getInstance().getWidth() - size) / 2;
        int playerY = Display.getInstance().getHeight() - size - 64;

        initPlayer(size, playerX, playerY);
        for (int i = 0; i < 20; i++) createEgg();

        Display.getInstance().printAllGraphics();


    }

    private void initPlayer(int size, int x, int y) {
        player.addComponent(new TransformComponent(x, y, size, size));
        player.addComponent(new PositionComponent());
        player.addComponent(new SpriteComponent(
                player.getComponent(new TransformComponent()),
                "assets\\sprite.png", 200
        ));
        player.addComponent(new ColliderComponent());
        player.addComponent(new KeyboardManager(
                player.getComponent(new SpriteComponent()),
                player.getComponent(new PositionComponent()),
                player.getComponent(new ColliderComponent()),
                player.getComponent(new TransformComponent())
        ));
        player.addComponent(new LiveComponent());
        player.addComponent(new ScoreComponent());
        player.addGroup(groupLabels.groupPlayer.ordinal());
    }

    private void createEgg() {
        Entity eggs = manager.addEntity();
        eggs.addComponent(new TransformComponent());
        eggs.addComponent(new PositionComponent());
        eggs.addComponent(new EggComponent(
                eggs.getComponent(new TransformComponent()),
                eggs.getComponent(new PositionComponent())
        ));
        eggs.addComponent(new SpriteComponent(
                eggs.getComponent(new TransformComponent()),
                "assets\\images.png", 300
        ));
        eggs.addComponent(new ColliderComponent(
                eggs.getComponent(new TransformComponent()).getPosition()
        ));
        eggs.addGroup(groupLabels.groupColliders.ordinal());
    }

    public void update() {
        manager.update();

        checkForCollide();

        dropEggs();

        if(player.getComponent(new LiveComponent()).getLives() == 0) GamePlay = false;
    }

    private void dropEggs() {
        if (Calendar.getInstance().getTimeInMillis() - time >= difficulty) {
            if(difficulty == 10000) difficulty = 1000;
            difficulty -= difficulty < 200 ? 0 : 2;
            System.out.println(difficulty);
            for (Entity e : manager.getGroup(groupLabels.groupColliders.ordinal())) {
                if (!e.getComponent(new EggComponent()).isDropped()) {
                    e.getComponent(new EggComponent()).drop();
                    break;
                }
            }
            time = Calendar.getInstance().getTimeInMillis();

        }
    }

    private void checkForCollide() {
        for (Entity e : manager.getGroup(groupLabels.groupColliders.ordinal())) {
            if (Collide.AABB(e.getComponent(new ColliderComponent()), player.getComponent(new ColliderComponent()))) {
                e.getComponent(new EggComponent()).remove();
            }
        }
    }

    public void render() {
        manager.draw();
    }
}
