package app.waste_disposal.commands;

import app.waste_disposal.annotations.Inject;
import app.waste_disposal.models.data.RecyclingStation;

import java.lang.reflect.InvocationTargetException;

public class ChangeManagementRequirementCommand implements Executable {
    @Inject
    private RecyclingStation recyclingStation;

    public ChangeManagementRequirementCommand() {
    }

    @Override
    public String execute(String... params) throws ClassNotFoundException,
            NoSuchMethodException, InvocationTargetException,
            InstantiationException,
            IllegalAccessException {

        this.recyclingStation.setRequirements(Double.parseDouble(params[0]), Double.parseDouble(params[1]), params[2]);

        return "Management requirement changed!";
    }
}
