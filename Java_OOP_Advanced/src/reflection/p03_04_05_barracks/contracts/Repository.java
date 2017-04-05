package reflection.p03_04_05_barracks.contracts;

public interface Repository {

	void addUnit(Unit unit);

	String getStatistics();

	String removeUnit(String unitType);
}
