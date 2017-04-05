package reflection.p03_04_05_barracks.core.factories;

import reflection.p03_04_05_barracks.contracts.Unit;
import reflection.p03_04_05_barracks.contracts.UnitFactory;
import reflection.p03_04_05_barracks.models.units.AbstractUnit;

import java.lang.reflect.Constructor;

public class UnitFactoryImpl implements UnitFactory {

    private static final String UNITS_PACKAGE_NAME =
            "pr0304Barracks.models.units.";

    @Override
    @SuppressWarnings("unchecked")
    public Unit createUnit(String unitType) throws ReflectiveOperationException {
        Class<AbstractUnit> abstractUnitClass = (Class<AbstractUnit>) Class.forName(UNITS_PACKAGE_NAME + unitType);
        Constructor<AbstractUnit> abstractUnitConstructor = abstractUnitClass.getDeclaredConstructor();
        abstractUnitConstructor.setAccessible(true);
        return abstractUnitConstructor.newInstance();
    }
}
