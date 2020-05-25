package App.ECS;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.List;

public class Entity {

    private final byte MAX_COMPONENTS = 32;
    private final byte MAX_GROUPS = 32;
    private List<Component> components = new ArrayList<>(MAX_COMPONENTS);
    private BitSet groupBitSet = new BitSet(MAX_GROUPS);
    private BitSet componentBitSet = new BitSet(MAX_COMPONENTS);
    private int componentIndex = 0;
    private HashMap<String, Integer> componentID = new HashMap<String, Integer>();
    private void initBitSets() {
        for (int i = 0; i < MAX_COMPONENTS; i++) {
            componentBitSet.set(i, false);
            groupBitSet.set(i,false);
        }
    }

    public Entity() {
        initBitSets();
    }

    public void update() {
        for (Component c : components) c.update();
    }

    public void draw() {
        for (Component c : components) c.draw();
    }

    public boolean hasGroup(int mGroup) {
        return groupBitSet.get(mGroup);
    }

    public void addGroup(int mGroup) {
        groupBitSet.set(mGroup, true);
    }
    public void delGroup(int mGroup) {
        groupBitSet.set(mGroup, false);
    }

    public <T extends Component> boolean hasComponent(T component) {

        if(componentID.get(component.getClass().getName()) != null)
            return componentBitSet.get(componentID.get(component.getClass().getName()));
        return false;
    }

    public void addComponent(Component component) {
        if(!hasComponent(component)) {
            components.add(component);
            componentID.put(component.getClass().getName(), componentIndex);
            componentBitSet.set(componentIndex, true);
            componentIndex++;
            components.get(components.size() - 1).init();
        }
    }

    public  <T extends Component>T getComponent(T component) {

        if(hasComponent(component)) return (T) components.get(componentID.get(component.getClass().getName()));
        return null;
    }


}
