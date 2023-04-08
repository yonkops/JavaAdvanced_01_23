package robotService.entities.robot;

public class MaleRobot extends BaseRobot{

    // Can only live in MainService!
    private static final int KILOGRAMS = 8;
    public MaleRobot(String name, String kind, double price) {
        super(name, kind, KILOGRAMS, price);
    }

    @Override
    public void eating() {
        // The method increases the robot’s kilograms by 3.
        setKilograms(getKilograms() + 3);
    }
}
