package app.waste_disposal.models.data;

import app.waste_disposal.contracts.ProcessingData;

public interface RecyclingStation {
    double getEnergyBalance();
    double getCapitalBalance();
    void processData(ProcessingData processingData);
    boolean meetsRequirements(String garbageType);
    void setRequirements(double energyBalance, double capitalBalance, String garbageType);
}
