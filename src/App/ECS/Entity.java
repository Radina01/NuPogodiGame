package App.ECS;

import App.ECS.Components.AnotherTestComponent;
import App.ECS.Components.TestComponent;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class Entity {

    private final byte MAX_COMPONENTS = 32;
    private final byte MAX_GROUPS = 32;

    List<Component> components = new ArrayList<>(MAX_COMPONENTS);
    BitSet groupBitSet = new BitSet(MAX_GROUPS);

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

    public void addComponent(Component component) {
        for (Component c: components) {
            if(c.getClass().getName().equals(component.getClass().getName())) return;
        }
        components.add(component);
    }

    public void showAllComponentTypes() {
        for (Component c: components) {
            System.out.println(c.getClass().getName());
        }
    }

    public  <T extends Component>T getComponent(ComponentList component) {
        switch (component) {
            case TestComponent: return (T) getTypeFromComponentsArray(new TestComponent());
            case AnotherTestComponent: return (T) getTypeFromComponentsArray(new AnotherTestComponent());
        }
        return null;
    }

    private Component getTypeFromComponentsArray(Component component) {
        for (Component c: components) {
            if(c.getClass().getName().equals(component.getClass().getName())) return c;
        }
        return null;
    }


}
