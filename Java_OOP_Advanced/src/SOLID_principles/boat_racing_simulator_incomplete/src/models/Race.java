package models;

import Utility.Constants;
import Utility.Validator;
import contracts.IRace;
import exeptions.DuplicateModelException;
import models.abstract_classes.Boat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Race implements IRace {
    private int distance;
    private int windSpeed;
    private int oseanCurrentSpeed;
    private Boolean allowsBoats;
    private HashMap<String, Boat> registeredBoats;

    public Race(int distance, int windSpeed, int oceanCurrentSpeed, Boolean allowsBoats) {
        this.setDistance(distance);
        this.setWindSpeed(windSpeed);
        this.setOseanCurrentSpeed(oceanCurrentSpeed);
        this.setAllowsBoats(allowsBoats);
        this.registeredBoats = new HashMap<>();
    }

    @Override
    public int getDistance() {
        return distance;
    }

    private void setDistance(int distance) {
        Validator.ValidatePropertyValue(distance, "Distance");
        this.distance = distance;
    }

    @Override
    public int getWindSpeed() {
        return windSpeed;
    }

    private void setWindSpeed(int windSpeed) {
        this.windSpeed = windSpeed;
    }

    public int getOceanCurrentSpeed() {
        return oseanCurrentSpeed;
    }

    private void setOseanCurrentSpeed(int oseanCurrentSpeed) {
        this.oseanCurrentSpeed = oseanCurrentSpeed;
    }

    public Boolean getAllowsMotorboats() {
        return allowsBoats;
    }

    private void setAllowsBoats(Boolean allowsBoats) {
        this.allowsBoats = allowsBoats;
    }

    protected HashMap<String, Boat> getRegisteredBoats() {
        return this.registeredBoats;
    }

    public void AddParticipant(Boat boat) throws DuplicateModelException {
        if (this.getRegisteredBoats().containsKey(boat.getModel())) {
            throw new DuplicateModelException(Constants.DuplicateModelMessage);
        }
        this.registeredBoats.put(boat.getModel(), boat);
    }

    public List<Boat> GetParticipants() {
        return new ArrayList<>(this.registeredBoats.values());
    }
}