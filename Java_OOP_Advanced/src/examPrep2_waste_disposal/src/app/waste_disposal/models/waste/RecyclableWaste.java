package app.waste_disposal.models.waste;

import app.waste_disposal.annotations.Recyclable;

@Recyclable
public class RecyclableWaste extends AbstractWaste {
    public RecyclableWaste(String name, double weight, double volumePerKg) {
        super(name, weight, volumePerKg);
    }
}
