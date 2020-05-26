package App.ECS;

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

    @Test
    public void testIsEntityAddedToGroupIfYesReturnTrue() {

    }
    @Test
    public void testIsEntityAddedToGroupIfNoReturnFalse() {

    }
}
