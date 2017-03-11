package P02_SystemSplit.models;

import P02_SystemSplit.models.hardwareComponents.HardwareComponent;
import P02_SystemSplit.models.hardwareComponents.HeavyHardwareComponent;
import P02_SystemSplit.models.hardwareComponents.PowerHardwareComponent;
import P02_SystemSplit.models.softwareComponents.ExpressSoftwareComponent;
import P02_SystemSplit.models.softwareComponents.LightSoftwareComponent;
import P02_SystemSplit.models.softwareComponents.SoftwareComponent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TheSystem {
    private Map<String, HardwareComponent> hardwareComponents;
    private int totalMemory;
    private int totalCapacity;


    public TheSystem() {
        this.hardwareComponents = new HashMap<>();
    }

    public void registerPowerHardware(String name, int capacity, int memory) {
        HardwareComponent hardwareComponent = new PowerHardwareComponent(name, capacity, memory);
        this.totalCapacity += hardwareComponent.getInitialCapacity();
        this.totalMemory += hardwareComponent.getInitialMemory();

        this.hardwareComponents.putIfAbsent(name, hardwareComponent);
    }

    public void registerHeavyHardware(String name, int capacity, int memory) {
        HardwareComponent hardwareComponent = new HeavyHardwareComponent(name, capacity, memory);
        this.totalCapacity += hardwareComponent.getInitialCapacity();
        this.totalMemory += hardwareComponent.getInitialMemory();

        this.hardwareComponents.putIfAbsent(name, hardwareComponent);
    }

    public void registerExpressSoftware(String hardwareComponentName, String name, int capacity, int memory) {
        SoftwareComponent softwareComponent = new ExpressSoftwareComponent(name, capacity, memory);

        if (!this.hardwareComponents.containsKey(hardwareComponentName)) {
            return;
        }

        this.hardwareComponents.get(hardwareComponentName).registerSoftwareComponent(softwareComponent);
    }

    public void registerLightSoftware(String hardwareComponentName, String name, int capacity, int memory) {
        SoftwareComponent softwareComponent = new LightSoftwareComponent(name, capacity, memory);

        if (!this.hardwareComponents.containsKey(hardwareComponentName)) {
            return;
        }

        this.hardwareComponents.get(hardwareComponentName).registerSoftwareComponent(softwareComponent);
    }

    public void releaseSoftwareComponent(String hardwareComponentName, String softwareComponentName) {
        if (!this.hardwareComponents.containsKey(hardwareComponentName)) {
            return;
        }

        HardwareComponent hardwareComponent = this.hardwareComponents.get(hardwareComponentName);

        if (!hardwareComponent.checkForComponent(softwareComponentName)) {
            return;
        }

        hardwareComponent.releaseComponent(softwareComponentName);
    }

    public String analyze() {
        StringBuilder sb = new StringBuilder();
        List<SoftwareComponent> components = this.hardwareComponents.values().stream().flatMap(c->c.getComponents().stream()).collect(Collectors.toList());
        int takenMemory = components.stream().mapToInt(c -> c.getMemory()).sum();
        int takenCapacity = components.stream().mapToInt(c -> c.getCapacity()).sum();

        sb.append("System Analysis\n")
                .append(String.format("Hardware Components: %d\n", this.hardwareComponents.size()))
                .append(String.format("Software Components: %d\n", components.size()))
                .append(String.format("Total Operational Memory: %d / %d\n", takenMemory, this.totalMemory))
                .append(String.format("Total Capacity Taken: %d / %d\n", takenCapacity, this.totalCapacity));

        return sb.toString();
    }

    public String split() {
        StringBuilder sb = new StringBuilder();

        this.hardwareComponents.values()
                .stream()
                .filter(c->c.getType().equals("Power"))
                .forEach(c->sb.append(c.toString()));

        this.hardwareComponents.values()
                .stream()
                .filter(c->c.getType().equals("Heavy"))
                .forEach(c->sb.append(c.toString()));

        return sb.toString();
    }


    @Override
    public String toString() {
        return this.split();
    }
}
