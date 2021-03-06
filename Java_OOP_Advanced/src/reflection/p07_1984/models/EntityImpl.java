package reflection.p07_1984.models;

import reflection.p07_1984.annotations.Inject;
import reflection.p07_1984.annotations.Monitored;
import reflection.p07_1984.models.interfaces.ChangeEvent;
import reflection.p07_1984.models.interfaces.Entity;
import reflection.p07_1984.models.interfaces.Observer;

import java.util.LinkedList;
import java.util.List;

public abstract class EntityImpl implements Entity {

    @Inject
    private String id;
    @Inject
    private String name;

    private List<Observer> observers;

    public EntityImpl() {
        this.observers = new LinkedList<>();
    }

    @Monitored("name")
    private void setName(String name) throws NoSuchFieldException {
        String oldName = this.getName();
        this.name = name;
        this.fireEvent(new ChangeEventImpl<>(
                this,
                this.getClass().getSuperclass().getDeclaredField("name"),
                oldName,
                this.name));
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void fireEvent(ChangeEvent event) {
        for (Observer observer : this.observers) {
            observer.update(event);
        }
    }

    @Override
    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }
}
