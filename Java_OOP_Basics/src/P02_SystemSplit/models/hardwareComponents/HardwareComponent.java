package P02_SystemSplit.models.hardwareComponents;

import P02_SystemSplit.models.Component;
import P02_SystemSplit.models.softwareComponents.SoftwareComponent;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class HardwareComponent extends Component {
    private Map<String, SoftwareComponent> softwareComponents;
    private int capacity;
    private int memory;
    private int initialCapacity;
    private int initialMemory;

    protected HardwareComponent(String name, String type, int capacity, int memory) {
        super(name, type);
        this.setCapacity(0);
        this.setMemory(0);
        this.initialCapacity = capacity;
        this.initialMemory = memory;
        this.softwareComponents = new LinkedHashMap<>();
    }

    public void registerSoftwareComponent(SoftwareComponent softwareComponent) {
        if (softwareComponent.getCapacity() > this.initialCapacity - this.getCapacity() || softwareComponent.getMemory() > this.initialMemory - this.getMemory()) {
            return;
        }

        this.softwareComponents.put(softwareComponent.getName(), softwareComponent);
        this.setCapacity(this.getCapacity() + softwareComponent.getCapacity());
        this.setMemory(this.getMemory() + softwareComponent.getMemory());
    }

    public void releaseComponent(String name) {
        if (!this.softwareComponents.containsKey(name)) {
            return;
        }
        SoftwareComponent softwareComponent = this.softwareComponents.get(name);

        this.setCapacity(this.getCapacity() - softwareComponent.getCapacity());
        this.setMemory(this.getMemory() - softwareComponent.getMemory());
        this.softwareComponents.remove(name);
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

    public int getInitialCapacity() {
        return initialCapacity;
    }

    public int getInitialMemory() {
        return initialMemory;
    }

    public boolean checkForComponent(String name) {
        if (!this.softwareComponents.containsKey(name)) {
            return false;
        } else {
            return true;
        }
    }

    public List<SoftwareComponent> getComponents(){
        return Collections.unmodifiableList(this.softwareComponents.values().stream().collect(Collectors.toList()));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Hardware Component - %s\n", this.getName()))
                .append(String.format("Express Software Components - %d\n", this.getComponents().stream().filter(c->c.getType().equals("Express")).count()))
                .append(String.format("Light Software Components - %d\n", this.getComponents().stream().filter(c->c.getType().equals("Light")).count()))
                .append(String.format("Memory Usage: %d / %d\n", this.getMemory(), this.getInitialMemory()))
                .append(String.format("Capacity Usage: %d / %d\n", this.getCapacity(), this.getInitialCapacity()))
                .append(String.format("Type: %s\n", this.getType()))
                .append(String.format("Software Components: %s\n",
                        this.getComponents().size() > 0 ?
                                String.join(", ", this.getComponents().stream().map(c->c.getName()).collect(Collectors.toList())) : "None"));

        return sb.toString();
    }


}
