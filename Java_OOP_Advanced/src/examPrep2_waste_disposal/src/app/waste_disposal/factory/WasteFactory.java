package app.waste_disposal.factory;

import app.waste_disposal.contracts.Waste;

import java.lang.reflect.InvocationTargetException;

public interface WasteFactory {
    Waste createWaste(String... params) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;
}
