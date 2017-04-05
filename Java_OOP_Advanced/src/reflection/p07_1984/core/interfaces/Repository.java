package reflection.p07_1984.core.interfaces;

import reflection.p07_1984.models.interfaces.Entity;
import reflection.p07_1984.models.interfaces.Observer;

public interface Repository {

    void addObserver(Observer observer);

    void addEntity(Entity entity);

    String getAllChangeLogs();

    Entity getEntityById(String id);

    void subscribeEntities(Observer observer);
}
