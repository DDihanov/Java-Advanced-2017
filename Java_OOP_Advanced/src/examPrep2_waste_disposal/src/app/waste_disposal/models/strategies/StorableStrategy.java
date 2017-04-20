package app.waste_disposal.models.strategies;

import app.waste_disposal.contracts.GarbageDisposalStrategy;
import app.waste_disposal.contracts.ProcessingData;
import app.waste_disposal.contracts.Waste;
import app.waste_disposal.models.processingData.ProcessingDataImpl;
import app.waste_disposal.utils.Constants;

public class StorableStrategy implements GarbageDisposalStrategy {
    @Override
    public ProcessingData processGarbage(Waste garbage) {
        double weight = garbage.getWeight();
        double totalGarbageVolume = weight * garbage.getVolumePerKg();
        return new ProcessingDataImpl(-(Constants.STORABLE_ENERGY_USED*totalGarbageVolume), -(Constants.STORABLE_CAPITAL_USED*totalGarbageVolume));
    }
}
