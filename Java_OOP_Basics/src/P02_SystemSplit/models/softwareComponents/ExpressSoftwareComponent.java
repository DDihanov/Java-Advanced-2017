package P02_SystemSplit.models.softwareComponents;

public class ExpressSoftwareComponent extends SoftwareComponent {
    private static final String EXPRESS_TYPE = "Express";
    private static final Double EXPRESS_MEMORY = 2d;

    public ExpressSoftwareComponent(String name, int capacity, int memory) {
        super(name, EXPRESS_TYPE, capacity, (int) (memory * EXPRESS_MEMORY));
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
