package reflection.p07_1984.core;

import reflection.p07_1984.core.interfaces.Repository;
import reflection.p07_1984.models.interfaces.Entity;
import reflection.p07_1984.models.interfaces.Observer;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class RepositoryImpl implements Repository {

    private Map<String, Entity> entitiesById;
    private List<Observer> observers;

    public RepositoryImpl() {
        this.entitiesById = new LinkedHashMap<>();
        this.observers = new LinkedList<>();
    }

    @Override
    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void addEntity(Entity entity) {
        String id = entity.getId();
        this.entitiesById.put(id, entity);
    }

    @Override
    public String getAllChangeLogs() {
        StringBuilder changeLogBuilder = new StringBuilder();
        for (Observer observer : this.observers) {
            changeLogBuilder.append(observer.toString()).append(System.lineSeparator());
            changeLogBuilder.append(observer.getChangeLog());
        }
        return changeLogBuilder.toString();
    }

    @Override
    public Entity getEntityById(String id) {
        return this.entitiesById.get(id);
    }

    @Override
    public void subscribeEntities(Observer observer) {
        for (Entity entity : this.entitiesById.values()) {
            entity.addObserver(observer);
        }
    }
}
