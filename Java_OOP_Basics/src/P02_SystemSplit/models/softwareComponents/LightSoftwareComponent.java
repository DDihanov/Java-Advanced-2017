package P02_SystemSplit.models.softwareComponents;

public class LightSoftwareComponent extends SoftwareComponent {
    private static final String LIGHT_TYPE = "Light";
    private static final Double LIGHT_CAPACITY = 0.5d;
    private static final Double LIGHT_MEMORY = 0.5d;

    public LightSoftwareComponent(String name, int capacity, int memory) {
        super(name, LIGHT_TYPE, (int) (capacity + capacity*LIGHT_CAPACITY), (int) (memory - memory*LIGHT_MEMORY));
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
