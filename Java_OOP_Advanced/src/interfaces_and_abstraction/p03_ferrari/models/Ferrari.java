package interfaces_and_abstraction.p03_ferrari.models;

import interfaces_and_abstraction.p03_ferrari.interfaces.Car;

public class Ferrari implements Car {
    public static final String FERRARI_MODEL;
    private String driverName;

    static {
        FERRARI_MODEL = "488-Spider";
    }

    public Ferrari(String driverName) {
        this.driverName = driverName;
    }

    @Override
    public String useBrakes() {
        return "Brakes!";
    }

    @Override
    public String pushGasPedal() {
        return "Zadu6avam sA!";
    }

    @Override
    public String getDriverName() {
        return this.driverName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(FERRARI_MODEL)
                .append("/")
                .append(this.useBrakes())
                .append("/")
                .append(this.pushGasPedal())
                .append("/")
                .append(this.getDriverName());

        return sb.toString();
    }
}
