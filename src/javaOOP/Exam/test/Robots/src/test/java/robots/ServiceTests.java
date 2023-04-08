package robots;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class ServiceTests {
    private static final int CAPACITY = 2;
    private static final String SERVICE_NAME = "Service";
    private static final String NAME1 = "R2D2";
    private static final String NAME2 = "beta6";
    private static final String NAME3 = "Gama8";
    private Service baseService;

    @Before
    public void setUp() {
        baseService = new Service(SERVICE_NAME, CAPACITY);
    }

    @Test(expected = NullPointerException.class)
    public void testNullName() {
        Service service = new Service(null, CAPACITY);

    }
    @Test(expected = NullPointerException.class)
    public void testEmptyName() {
        Service service = new Service("   ", CAPACITY);
    }

    @Test
    public void testValidName() {
        assertEquals(SERVICE_NAME, baseService.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testForZeroCapacity() {
        Service service = new Service(NAME1, -1);
    }
    @Test
    public void testValidCapacity() {
        assertEquals(CAPACITY, baseService.getCapacity());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddRobotToFullCapacity() {
        Robot robot1 = new Robot(NAME1);
        Robot robot2 = new Robot(NAME2);
        Robot robot3 = new Robot(NAME3);
        baseService.add(robot1);
        baseService.add(robot2);
        baseService.add(robot3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemovingNotExistingRobot() {
        Robot robot1 = new Robot(NAME1);
        Robot robot2 = new Robot(NAME2);
        baseService.add(robot1);
        baseService.add(robot2);
        baseService.remove(NAME3);
    }
    @Test
    public void testRobotSale() {
        Robot robot1 = new Robot(NAME1);
        Robot robot2 = new Robot(NAME2);
        baseService.add(robot1);
        baseService.add(robot2);
        baseService.forSale(NAME1);
        assertEquals(false, robot1.isReadyForSale());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testNotExistingRobot() {
        Robot robot1 = new Robot(NAME1);
        Robot robot2 = new Robot(NAME2);
        baseService.add(robot1);
        baseService.add(robot2);
        baseService.forSale(NAME3);
    }

}
