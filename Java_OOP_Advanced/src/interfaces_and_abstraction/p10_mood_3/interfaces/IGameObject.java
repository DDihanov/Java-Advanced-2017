package interfaces_and_abstraction.p10_mood_3.interfaces;

public interface IGameObject<T, P> {
    String getUsername();

    P getHashedPassword();

    int getLevel();

    T getSpecialPoints();
}
