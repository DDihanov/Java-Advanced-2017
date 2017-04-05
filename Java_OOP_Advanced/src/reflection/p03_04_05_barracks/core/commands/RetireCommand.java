package reflection.p03_04_05_barracks.core.commands;

import reflection.p03_04_05_barracks.contracts.Repository;
import reflection.p03_04_05_barracks.core.annotations.Inject;

public class RetireCommand extends Command {

    @Inject
    private Repository repository;
    protected RetireCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        String unitType = this.getData()[1];

        return this.repository.removeUnit(unitType);
    }
}
