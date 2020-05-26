package App.ECS;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.List;

public class Entity {

    private Manager manager;
    private final byte MAX_COMPONENTS = 32;
    private final byte MAX_GROUPS = 32;
    private List<Component> components = new ArrayList<>(MAX_COMPONENTS);
    private BitSet groupBitSet = new BitSet(MAX_GROUPS);
    private BitSet componentBitSet = new BitSet(MAX_COMPONENTS);
    private HashMap<String, Integer> componentID = new HashMap<String, Integer>();
    private void initBitSets() {
        for (int i = 0; i < MAX_COMPONENTS; i++) {
            componentBitSet.set(i, false);
            groupBitSet.set(i,false);
        }
    }

    public Entity(Manager manager) {
        this.manager = manager;
        initBitSets();;
    }

    public void update() {
        for (int i = 0; i < components.size(); i++) components.get(i).update();
    }

    public void draw() {
        for (int i = 0; i < components.size(); i++) components.get(i).draw();
    }

    public boolean hasGroup(int mGroup) {
        return groupBitSet.get(mGroup);
    }

    public void addGroup(int mGroup) {
        groupBitSet.set(mGroup, true);
        manager.addToGroup(this, mGroup);
    }
    public void delGroup(int mGroup) {
        groupBitSet.set(mGroup, false);
    }

    public boolean hasComponent(Component component) {

        if(componentID.get(component.getClass().getName()) != null)
            return componentBitSet.get(componentID.get(component.getClass().getName()));
        return false;
    }

    public void addComponent(Component component) {
        if(!hasComponent(component)) {
            components.add(component);
            componentID.put(component.getClass().getName(), components.size() - 1);
            componentBitSet.set(components.size() - 1, true);
            //components.get(components.size() - 1).init();
        }
    }

    public  <T extends Component>T getComponent(T component) {
        if(hasComponent(component)) return (T) components.get(componentID.get(component.getClass().getName()));
        return null;
    }


}
