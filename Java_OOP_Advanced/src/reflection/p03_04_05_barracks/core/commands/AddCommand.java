package reflection.p03_04_05_barracks.core.commands;

import reflection.p03_04_05_barracks.contracts.Repository;
import reflection.p03_04_05_barracks.contracts.Unit;
import reflection.p03_04_05_barracks.contracts.UnitFactory;
import reflection.p03_04_05_barracks.core.annotations.Inject;

public class AddCommand extends Command {

    @Inject
    private UnitFactory unitFactory;
    @Inject
    private Repository repository;

    protected AddCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() throws ReflectiveOperationException {
        String unitType = this.getData()[1];
        Unit unitToAdd = this.unitFactory.createUnit(unitType);
        this.repository.addUnit(unitToAdd);
        return unitType + " added!";
    }
}
