package app.waste_disposal.models.data;

import app.waste_disposal.contracts.ProcessingData;

public class RecyclingStationImpl implements RecyclingStation {
    private double capitalBalance;
    private double energyBalance;
    private double requiredCapital;
    private double requiredEnergyBalance;
    private String garbageType;

    public RecyclingStationImpl() {
        this.capitalBalance = 0.0;
        this.energyBalance = 0.0;
        this.requiredEnergyBalance = Double.MAX_VALUE;
        this.requiredCapital = Double.MAX_VALUE;
        this.garbageType = "NONE";
    }

    @Override
    public double getEnergyBalance() {
        return this.energyBalance;
    }

    @Override
    public double getCapitalBalance() {
        return this.capitalBalance;
    }

    @Override
    public void processData(ProcessingData processingData) {
        this.capitalBalance += processingData.getCapitalBalance();
        this.energyBalance += processingData.getEnergyBalance();
    }

    @Override
    public boolean meetsRequirements(String garbageType) {
        if(this.garbageType.equals(garbageType)){
            if(this.capitalBalance < this.requiredCapital || this.energyBalance < this.requiredEnergyBalance){
                return false;
            }
        }

        return true;
    }

    @Override
    public void setRequirements(double energyBalance, double capitalBalance, String garbageType) {
        this.requiredEnergyBalance = energyBalance;
        this.requiredCapital = capitalBalance;
        this.garbageType = garbageType;
    }

    @Override
    public String toString() {
        return String.format("Energy: %.2f Capital: %.2f", this.getEnergyBalance(), this.getCapitalBalance());
    }
}
