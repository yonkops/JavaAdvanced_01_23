package football.entities.player;

public class Women extends BasePlayer{
    private static final double KG = 60.00;
    private static final int STIMULATION_STRENGTH = 115;

    public Women(String name, String nationality, int strength) {
        super(name, nationality, KG, strength);
    }

    @Override
    public void stimulation() {
        int newStrength = getStrength() + STIMULATION_STRENGTH;
        setStrength(newStrength);
    }
}
