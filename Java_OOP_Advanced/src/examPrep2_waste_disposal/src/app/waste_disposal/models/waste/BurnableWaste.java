package app.waste_disposal.models.waste;

import app.waste_disposal.annotations.Burnable;

@Burnable
public class BurnableWaste extends AbstractWaste{
    public BurnableWaste(String name, double weight, double volumePerKg) {
        super(name, weight, volumePerKg);
    }
}
