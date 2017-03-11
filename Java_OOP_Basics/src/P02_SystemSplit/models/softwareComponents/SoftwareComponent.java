package P02_SystemSplit.models.softwareComponents;

import P02_SystemSplit.models.Component;

public abstract class SoftwareComponent extends Component{
    private int capacity;
    private int memory;

    protected SoftwareComponent(String name, String type, int capacity, int memory) {
        super(name, type);
        this.setCapacity(capacity);
        this.setMemory(memory);
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public int getMemory() {
        return this.memory;
    }

    @Override
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public void setMemory(int memory) {
        this.memory = memory;
    }
}
