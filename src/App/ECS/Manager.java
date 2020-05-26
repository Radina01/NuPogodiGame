package App.ECS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Manager {

    public List<Entity> entities = new ArrayList<>();
    private HashMap<Integer, ArrayList<Entity>> groupedEntities = new HashMap<>();

    public void update() {
        for (int i = 0; i < entities.size(); i++) entities.get(i).update();
    }

    public void draw() {
        for (int i = 0; i < entities.size(); i++) entities.get(i).draw();
    }

    public void addToGroup(Entity entity, int group) {
        groupedEntities.computeIfAbsent(group, k -> new ArrayList<>());
        groupedEntities.get(group).add(entity);
    }

    public ArrayList<Entity> getGroup(int group) {
        return groupedEntities.get(group);
    }

    public Entity addEntity() {
        Entity entity = new Entity(this);
        entities.add(entity);
        return entity;
    }


}
