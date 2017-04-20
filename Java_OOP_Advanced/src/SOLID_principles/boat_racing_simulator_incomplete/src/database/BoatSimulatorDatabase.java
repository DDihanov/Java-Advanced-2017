package database;

import contracts.IRepository;
import models.abstract_classes.Boat;
import models.abstract_classes.BoatEngine;
import models.boats.PowerBoat;

public class BoatSimulatorDatabase {
    private IRepository<Boat> boats;
    private IRepository<BoatEngine> engines;

    public BoatSimulatorDatabase()
    {
        this.setBoats(new Repository<PowerBoat>());
        this.setEngines(new Repository<BoatEngine>());
    }

    public IRepository<Boat> getBoats() {
        return this.boats;
    }

    private void setBoats(IRepository<Boat> boats) {
        this.boats = boats;
    }

    public IRepository<BoatEngine> getEngines() {
        return this.engines;
    }

    private void setEngines(IRepository<BoatEngine> engines) {
        this.engines = engines;
    }
}
