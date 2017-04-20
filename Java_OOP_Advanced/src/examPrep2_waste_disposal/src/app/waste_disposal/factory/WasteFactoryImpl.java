package app.waste_disposal.factory;

import app.waste_disposal.contracts.Waste;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class WasteFactoryImpl implements WasteFactory {
    private static final String WASTE_SUFFIX = "Waste";
    private static final String CLASS_PATH = "app.waste_disposal.models.waste.";

    @Override
    public Waste createWaste(String... params) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String name = params[0];
        double weight = Double.parseDouble(params[1]);
        double volumePerKg = Double.parseDouble(params[2]);
        String type = params[3];
        Class wasteClass = Class.forName(CLASS_PATH + type + WASTE_SUFFIX);
        Constructor wasteConstructor = wasteClass.getDeclaredConstructor(String.class, double.class, double.class);
        Waste waste = (Waste) wasteConstructor.newInstance(name, weight, volumePerKg);
        return waste;
    }
}
