package App.ECS;

import App.ECS.Components.TestComponent;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ManagerTest {

    Manager manager;
    Entity entity;

    @Before
    public void init() {
        manager = new Manager();
        entity = manager.addEntity();
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void testAddEntity() {
        int number = manager.getEntities().size();
        Assert.assertEquals("no entity was added", number, manager.getEntities().size());
    }

    @Test
    public void testIsEntityLinkedWithEntityListInManager() {
        entity.addComponent(new TestComponent());
        manager.getEntities().get(0).getComponent(new TestComponent()).a = 50;
        Assert.assertEquals("Entity is not linked with manager", 50, entity.getComponent(new TestComponent()).getA());
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void testIfEntityAddedToGroup() {
        entity.addGroup(1);
        Assert.assertEquals("Entity was not added to group list in manager", 1, manager.getGroup(1).size());
    }
    @Test
    public void testIfMoreEntitiesAreAddedToGroup() {
        entity.addGroup(1);
        Entity en = manager.addEntity();
        en.addGroup(1);
        Assert.assertEquals("Entity was not added to group list in manager",2 , manager.getGroup(1).size());
    }
    @Test
    public void testIfOneEntityIsAddedToGroupMoreThanOnce() {
        entity.addGroup(1);
        entity.addGroup(1);
        Assert.assertEquals("Entity couldn't be added more than once in one group",1 , manager.getGroup(1).size());
    }
    @Test
    public void testAreEntitiesFromGroupsLinkedTestByChangingEntitiesFromManager(){
        entity.addGroup(1);
        Entity obj = manager.addEntity();
        obj.addGroup(1);

        for (Entity e: manager.getGroup(1)) {
            e.addComponent(new TestComponent());
        }

        Assert.assertTrue("Entites are not linked", entity.hasComponent(new TestComponent()));
        Assert.assertTrue("Entites are not linked", obj.hasComponent(new TestComponent()));
    }
    @Test
    public void testAreEntitiesFromGroupsLinkedTestByChangingEntitiesFromEntityObject(){
        entity.addGroup(1);
        Entity obj = manager.addEntity();
        obj.addGroup(1);

        entity.addComponent(new TestComponent());
        obj.addComponent(new TestComponent());

        Assert.assertTrue("Entities are not linked", manager.getGroup(1).get(0).hasComponent(new TestComponent()));
        Assert.assertTrue("Entities are not linked", manager.getGroup(1).get(1).hasComponent(new TestComponent()));
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////
}
