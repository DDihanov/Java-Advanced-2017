package app.waste_disposal.models.strategies;

import app.waste_disposal.contracts.GarbageDisposalStrategy;
import app.waste_disposal.contracts.ProcessingData;
import app.waste_disposal.contracts.Waste;
import app.waste_disposal.models.processingData.ProcessingDataImpl;
import app.waste_disposal.utils.Constants;

public class RecyclableStrategy implements GarbageDisposalStrategy {
    @Override
    public ProcessingData processGarbage(Waste garbage) {
        double weight = garbage.getWeight();
        double totalGarbageVolume = weight * garbage.getVolumePerKg();
        return new ProcessingDataImpl(-(Constants.RECYCLABLE_ENERGY_USED*totalGarbageVolume), Constants.RECYCLABLE_CAPITAL_EARNED*weight);
    }
}
