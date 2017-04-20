package app.waste_disposal.commands;

import app.waste_disposal.annotations.Inject;
import app.waste_disposal.models.data.RecyclingStation;

public class StatusCommand implements Executable {
    @Inject
    private RecyclingStation recyclingStation;

    public StatusCommand() {
    }

    @Override
    public String execute(String... params) {
        return this.recyclingStation.toString();
    }
}
