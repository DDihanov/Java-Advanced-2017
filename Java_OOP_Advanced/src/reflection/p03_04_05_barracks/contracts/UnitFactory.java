package reflection.p03_04_05_barracks.contracts;

public interface UnitFactory {

    Unit createUnit(String unitType) throws ReflectiveOperationException;
}