package P02_SystemSplit.models;

public abstract class Component {
    private String name;
    private String type;

    protected Component(String name, String type) {
        this.name = name;
        this.type = type;
    }


    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public abstract int getCapacity();

    public abstract int getMemory();

    public abstract void setCapacity(int capacity);

    public abstract void setMemory(int memory);
}
