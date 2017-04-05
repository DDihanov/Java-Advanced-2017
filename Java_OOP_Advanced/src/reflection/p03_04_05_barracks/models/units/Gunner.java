package reflection.p03_04_05_barracks.models.units;

public class Gunner extends AbstractUnit {

    private static final int GUNNER_HEALTH = 20;
    private static final int GUNNER_DAMAGE = 20;

    protected Gunner() {
        super(GUNNER_HEALTH, GUNNER_DAMAGE);
    }
}
