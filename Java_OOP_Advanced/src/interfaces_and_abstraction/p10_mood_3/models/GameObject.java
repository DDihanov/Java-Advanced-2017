package interfaces_and_abstraction.p10_mood_3.models;

import interfaces_and_abstraction.p10_mood_3.interfaces.IGameObject;

public abstract class GameObject<T extends Number, P> implements IGameObject {
    private String username;
    private P hashedPassword;
    private int level;
    private T specialPoints;

    protected GameObject(String username, int level, T specialPoints) {
        this.username = username;
        this.level = level;
        this.specialPoints = specialPoints;
    }

    protected void setHashedPassword(P hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public P getHashedPassword() {
        return this.hashedPassword;
    }

    @Override
    public int getLevel() {
        return this.level;
    }

    @Override
    public T getSpecialPoints() {
        return this.specialPoints;
    }

    @Override
    public String toString() {
        //<”username”> | <”hashed password”> -> <character type>
        //<special points * level>
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("\"%s\" | \"%s\" -> %s",
                this.getUsername(),
                this.getHashedPassword(),
                this.getClass().getSimpleName()))
                .append(System.lineSeparator());

        return stringBuilder.toString();
    }
}
