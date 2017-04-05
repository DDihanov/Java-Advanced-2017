package reflection.p03_04_05_barracks.core.commands;

import reflection.p03_04_05_barracks.contracts.Executable;

public abstract class Command implements Executable {

    private String[] data;

    protected Command(String[] data) {
        this.data = data;
    }

    protected String[] getData() {
        return this.data;
    }
}
