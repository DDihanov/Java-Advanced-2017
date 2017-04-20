package controllers;

import Utility.Constants;
import contracts.IBoatSimulatorController;
import contracts.IRace;
import database.BoatSimulatorDatabase;
import enumeration.EngineType;
import exeptions.*;
import models.Race;
import models.abstract_classes.Boat;
import models.abstract_classes.BoatEngine;
import models.boats.PowerBoat;
import models.boats.RowBoat;
import models.boats.SailBoat;
import models.boats.Yacht;
import models.engines.JetEngine;
import models.engines.SterndriveEngine;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;
import java.util.stream.Collectors;

public class BoatSimulatorController implements IBoatSimulatorController {
    private Map<Double, Boat> winners;
    private BoatSimulatorDatabase database;
    private IRace currentRace;

    public BoatSimulatorController() {
        this.setDatabase(new BoatSimulatorDatabase());
        this.setCurrentRace(null);
        this.winners = new LinkedHashMap<>();
    }

    @Override
    public BoatSimulatorDatabase getDatabase() {
        return this.database;
    }

    private void setDatabase(BoatSimulatorDatabase database) {
        this.database = database;
    }

    @Override
    public IRace getCurrentRace() {
        return this.currentRace;
    }

    private void setCurrentRace(IRace currentRace) {
        this.currentRace = currentRace;
    }

    @Override
    public String CreateBoatEngine(String model, int horsepower, int displacement, EngineType engineType) throws DuplicateModelException {
        BoatEngine engine;
        switch (engineType) {
            case Jet:
                engine = new JetEngine(model, horsepower, displacement);
                break;
            case Sterndrive:
                engine = new SterndriveEngine(model, horsepower, displacement);
                break;
            default:
                throw new NotImplementedException();
        }

        this.database.getEngines().Add(engine);
        return String.format(
                "BoatEngine model %s with %s HP and displacement %s cm3 created successfully.",
                model,
                horsepower,
                displacement);
    }

    public String CreateRowBoat(String model, int weight, int oars) throws DuplicateModelException {
        Boat boat = new RowBoat(model, weight, oars);
        this.database.getBoats().Add(boat);
        return String.format("Row boat with model %s registered successfully.", model);
    }

    public String CreateSailBoat(String model, int weight, int sailEfficiency) throws DuplicateModelException {
        Boat boat = new SailBoat(model, weight, sailEfficiency);
        this.database.getBoats().Add(boat);
        return String.format("Sail boat with model %s registered successfully.", model);
    }

    public String CreatePowerBoat(String model, int weight, String firstEngineModel, String secondEngineModel) throws NonExistantModelException, DuplicateModelException {
        BoatEngine firstEngine = this.database.getEngines().GetItem(firstEngineModel);
        BoatEngine secondEngine = this.database.getEngines().GetItem(secondEngineModel);
        Boat boat = new PowerBoat(model, weight, Arrays.asList(firstEngine, secondEngine));
        this.database.getBoats().Add(boat);
        return String.format("Power boat with model %s registered successfully.", model);
    }

    public String CreateYacht(String model, int weight, String engineModel, int cargoWeight) throws NonExistantModelException, DuplicateModelException {
        BoatEngine engine = this.database.getEngines().GetItem(engineModel);
        Boat boat = new Yacht(model, weight, engine, cargoWeight);
        this.database.getBoats().Add(boat);
        return String.format("Yacht with model %s registered successfully.", model);
    }

    public String OpenRace(int distance, int windSpeed, int oceanCurrentSpeed, Boolean allowsMotorboats) throws RaceAlreadyExistsException {
        IRace race = new Race(distance, windSpeed, oceanCurrentSpeed, allowsMotorboats);
        this.ValidateRaceIsEmpty();
        this.currentRace = race;
        return
                String.format(
                        "A new race with distance %s meters, wind speed %sm/s and ocean current speed %s m/s has been set.",
                        distance, windSpeed, oceanCurrentSpeed);
    }

    public String SignUpBoat(String model) throws NonExistantModelException, DuplicateModelException, NoSetRaceException {
        Boat boat = this.database.getBoats().GetItem(model);
        this.ValidateRaceIsSet();
        if (!this.currentRace.getAllowsMotorboats() && boat instanceof PowerBoat) {
            throw new IllegalArgumentException(Constants.IncorrectBoatTypeMessage);
        }
        this.currentRace.AddParticipant(boat);
        return String.format("Boat with model %s has signed up for the current Race.", model);
    }

    public String StartRace() throws InsufficientContestantsException, NoSetRaceException {
        this.ValidateRaceIsSet();
        List<Boat> participants = this.currentRace.GetParticipants();
        if (participants.size() < 3) {
            throw new InsufficientContestantsException(Constants.InsufficientContestantsMessage);
        }


//        StringBuilder result = new StringBuilder();
//        for (int i = 0; i < 3; i++) {
//            this.FindFastest(participants);
//        }
//
//        Iterator<Map.Entry<Double, Boat>> iterator = this.winners.entrySet().stream().sorted((o1, o2) -> {
//            if(o1.getKey() < 0){
//                return 0;
//            }
//            return Double.compare(o1.getKey(), o2.getKey());
//        }).iterator();
//
//        Map.Entry<Double, Boat> boat = iterator.next();
//        result.append(String.format("First place: %s Model: %s Time: %s\n",
//                boat.getValue().getClass().getSimpleName().toString(),
//                boat.getValue().getModel(),
//                isFinished(boat.getKey())));
//        boat = iterator.next();
//        result.append(String.format("Second place: %s Model: %s Time: %s\n",
//                boat.getValue().getClass().getSimpleName().toString(),
//                boat.getValue().getModel(),
//                isFinished(boat.getKey())));
//        boat = iterator.next();
//        result.append(String.format("Third place: %s Model: %s Time: %s\n",
//                boat.getValue().getClass().getSimpleName().toString(),
//                boat.getValue().getModel(),
//                isFinished(boat.getKey())));
        for (int i = 0; i < 3; i++) {
            FindFastest(participants);
        }

        StringBuilder result = new StringBuilder();
        for (Map.Entry<Double, Boat> doubleMotorBoatEntry : winners.entrySet().stream().sorted((x1,x2)->Double.compare(x1.getKey(),x2.getKey())).collect(Collectors.toList())) {
            String place = "";
            switch(winners.size()){
                case(3):
                    place = "First";
                    break;
                case(2):
                    place = "Second";
                    break;
                case(1):
                    place = "Third";
                    break;
            }
            result.append(String.format("%s place: %s Model: %s Time: %s\n",
                    place,
                    doubleMotorBoatEntry.getValue().getClass().getSimpleName().toString(),
                    doubleMotorBoatEntry.getValue().getModel(),
                    isFinished(doubleMotorBoatEntry.getKey())));
        }

        this.currentRace = null;

        return result.toString();
    }

    private String isFinished(Double key) {
        if (key <= -1.0) {
            return "Did not finish!";
        }
        return String.format("%f.2 sec", key);
    }

    @Override
    public String GetStatistic() {
        return null;
    }

    public String getStatistic() {
        //TODO Bonus Task Implement me
        throw new NotImplementedException();
    }

    private void FindFastest(List<Boat> participants) {
        Double bestTime = (double) Integer.MAX_VALUE;
        Boat winner = null;
        for (Boat participant : participants) {
            Double speed = participant.calculateRaceSpeed(this.currentRace);
            Double time = this.currentRace.getDistance() / speed;
            if(speed <= 0){
                this.winners.put((double)Integer.MAX_VALUE, winner);
                participants.remove(winner);
                return;
            }
            if (time < bestTime) {
                bestTime = time;
                winner = participant;
            }
        }

        this.winners.put(bestTime, winner);
        participants.remove(winner);
    }

    private void ValidateRaceIsSet() throws NoSetRaceException {
        if (this.currentRace == null) {
            throw new NoSetRaceException(Constants.NoSetRaceMessage);
        }
    }

    private void ValidateRaceIsEmpty() throws RaceAlreadyExistsException {
        if (this.currentRace != null) {
            throw new RaceAlreadyExistsException(Constants.RaceAlreadyExistsMessage);
        }
    }
}
