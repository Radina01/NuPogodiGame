package App.ECS;

import App.ECS.Components.TestComponent;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.BitSet;

public class EntityTest {

    Entity entity;

    @Before
    public void init() {
        entity = new Entity(new Manager());
    }

    ////////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void testInitBitSets() {
        Assert.assertFalse("component bitset is not the right length", entity.getComponentBitSet().get(entity.getMAX_COMPONENTS() - 1));
        Assert.assertFalse("group bitset is not the right length", entity.getGroupBitSet().get(entity.getMAX_GROUPS() - 1));
    }

    /////////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void testAddToGroupIfWorkReturnTrue() {
        entity.addGroup(1);
        boolean condition = entity.getGroupBitSet().get(1);
        Assert.assertTrue("add to group method don't add groups", condition);
    }

    @Test
    public void testAddToGroupIfDoNotWorkReturnFalse() {
        entity.addGroup(1);
        boolean condition = !entity.getGroupBitSet().get(1);
        Assert.assertFalse("add to group method don't add groups", condition);
    }

    /////////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void testIfComponentIsAdded() {
        entity.addComponent(new TestComponent());
        Assert.assertEquals("Component is not added", 1, entity.getComponents().size());
    }

    @Test
    public void testAddComponentIfAddingTwoSameComponents() {
        entity.addComponent(new TestComponent());
        entity.addComponent(new TestComponent());
        Assert.assertEquals("You can add components of same type more than once", 1, entity.getComponents().size());
    }

    @Test
    public void testIfAddedComponentHaveID() {
        Component component = new TestComponent();
        entity.addComponent(component);
        Assert.assertEquals("new component doesn't have id", (Integer) 0, entity.getComponentID().get(component.getClass().getName()));
    }

    @Test
    public void testIfComponentIsAddedToBitSetListReturnTrue() {
        Component component = new TestComponent();
        entity.addComponent(component);
        Assert.assertTrue("new component is not added to bitset list", entity.getComponentBitSet().get(0));
    }
    @Test
    public void testIfComponentIsNotAddedToBitSetListReturnFalse() {
        Assert.assertFalse("new component is not added to bitset list", entity.getComponentBitSet().get(0));
    }

    ///////////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void testIsGetComponentReturnRightComponent() {
        entity.addComponent(new TestComponent());
        Assert.assertEquals("return type is no as expected", TestComponent.class.getName(), entity.getComponent(new TestComponent()).getClass().getName());
    }

    @Test
    public void testChangeContentOfComponent() {
        entity.addComponent(new TestComponent());
        entity.getComponent(new TestComponent()).a = 20;
        Assert.assertEquals("you can't change content of copmponent", 20, entity.getComponent(new TestComponent()).getA());
    }

    @Test
    public void testToGetUnaddedComponent() {
        Assert.assertNull("invalid return", entity.getComponent(new TestComponent()));
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void testIfHasComponentWorkReturnTrue() {
        entity.addComponent(new TestComponent());
        Assert.assertTrue("this component have be added", entity.hasComponent(new TestComponent()));
    }

    @Test
    public void testIfHasComponentDoNotWorkReturnFalse() {
        Assert.assertFalse("this component have not be added", entity.hasComponent(new TestComponent()));
    }

}
