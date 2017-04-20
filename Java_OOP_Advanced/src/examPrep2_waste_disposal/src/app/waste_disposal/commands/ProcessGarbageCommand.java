package app.waste_disposal.commands;

import app.waste_disposal.annotations.Inject;
import app.waste_disposal.contracts.GarbageProcessor;
import app.waste_disposal.contracts.ProcessingData;
import app.waste_disposal.contracts.Waste;
import app.waste_disposal.factory.WasteFactory;
import app.waste_disposal.models.data.RecyclingStation;

import java.lang.reflect.InvocationTargetException;

public class ProcessGarbageCommand implements Executable {
    @Inject
    private WasteFactory wasteFactory;
    @Inject
    private GarbageProcessor garbageProcessor;
    @Inject
    private RecyclingStation recyclingStation;

    public ProcessGarbageCommand() {
    }

    @Override
    public String execute(String... params) throws ClassNotFoundException,
            NoSuchMethodException, InvocationTargetException,
            InstantiationException,
            IllegalAccessException {
        Waste waste = this.wasteFactory.createWaste(params);
        ProcessingData processingData = this.garbageProcessor.processWaste(waste);
//        String garbageType = waste.getClass().getAnnotations()[0].annotationType().getSimpleName();
        String garbageType = params[3];
        if(!this.recyclingStation.meetsRequirements(garbageType)){
            return "Processing Denied!";
        }
        this.recyclingStation.processData(processingData);

        return String.format("%.2f kg of %s successfully processed!", waste.getWeight(), waste.getName());
    }
}
