package App.ECS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Manager {

    private List<Entity> entities = new ArrayList<>();
    private HashMap<Integer, ArrayList<Entity>> groupedEntities = new HashMap<>();

    public void update() {
        for (Entity e: entities) e.update();
    }

    public void draw() {
        for (Entity e: entities) e.draw();
    }
}
