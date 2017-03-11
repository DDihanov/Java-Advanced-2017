package P02_SystemSplit.models.hardwareComponents;

public class HeavyHardwareComponent extends HardwareComponent {
    private static final String HEAVY_TYPE = "Heavy";
    private static final Double HEAVY_CAPACITY = 2d;
    private static final Double HEAVY_MEMORY = 0.25d;

    public HeavyHardwareComponent(String name, int capacity, int memory) {
        super(name, HEAVY_TYPE, (int)(capacity*HEAVY_CAPACITY),(int)(memory - memory*HEAVY_MEMORY));
    }

    @Override
    public int getCapacity() {
        return super.getCapacity();
    }

    @Override
    public int getMemory() {
        return super.getMemory();
    }
}
