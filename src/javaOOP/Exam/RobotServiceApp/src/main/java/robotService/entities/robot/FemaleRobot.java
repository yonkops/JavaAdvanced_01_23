package robotService.entities.robot;

public class FemaleRobot extends BaseRobot{

    // Can only live in SecondaryService!

    private static final int KILOGRAMS = 7;
    private static final String SUITABLE_SERVICE = "SecondaryService";
    public FemaleRobot(String name, String kind, double price) {
        super(name, kind, KILOGRAMS, price);
    }

    @Override
    public void eating() {
        // The method increases the robot’s kilograms by 1.
        setKilograms(getKilograms() + 1);
    }
     public String getService() {
        return SUITABLE_SERVICE;
     }
}
