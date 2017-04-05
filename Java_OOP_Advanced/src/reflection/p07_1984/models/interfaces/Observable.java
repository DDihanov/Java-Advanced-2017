package reflection.p07_1984.models.interfaces;

public interface Observable {

    void fireEvent(ChangeEvent event);

    void addObserver(Observer observer);

    void removeObserver(Observer observer);
}
