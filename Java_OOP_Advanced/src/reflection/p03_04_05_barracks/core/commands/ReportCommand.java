package reflection.p03_04_05_barracks.core.commands;

import reflection.p03_04_05_barracks.contracts.Repository;
import reflection.p03_04_05_barracks.core.annotations.Inject;

public class ReportCommand extends Command {

    @Inject
    private Repository repository;

    protected ReportCommand(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        return this.repository.getStatistics();
    }
}
