package P02_SystemSplit.models.hardwareComponents;

public class PowerHardwareComponent extends HardwareComponent {
    private static final String POWER_TYPE = "Power";
    private static final Double POWER_CAPACITY = 0.75d;
    private static final Double POWER_MEMORY = 0.75d;

    public PowerHardwareComponent(String name, int capacity, int memory) {
        super(name, POWER_TYPE, (int)(capacity - capacity*POWER_CAPACITY), (int)(memory + memory*POWER_MEMORY));
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
