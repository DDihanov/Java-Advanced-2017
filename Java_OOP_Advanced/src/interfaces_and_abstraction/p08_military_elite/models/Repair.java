package interfaces_and_abstraction.p08_military_elite.models;

import interfaces_and_abstraction.p08_military_elite.interfaces.IRepair;

public class Repair implements IRepair {
    private int hoursWorked;
    private String partName;

    public Repair(int hoursWorked, String partName) {
        this.hoursWorked = hoursWorked;
        this.partName = partName;
    }

    @Override
    public int getHoursWorked() {
        return this.hoursWorked;
    }

    @Override
    public String getPartName() {
        return this.partName;
    }

    @Override
    public String toString() {
        return String.format("  Part Name: %s Hours Worked: %d\n", this.getPartName(), this.getHoursWorked());
    }
}
