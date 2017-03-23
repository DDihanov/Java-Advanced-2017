package interfaces_and_abstraction.p10_mood_3.models;

public class Demon extends GameObject<Double, Integer> {
    private static final int PASSWORD_MODIFIER = 217;
    public Demon(String username, int level, Double specialPoints) {
        super(username, level, specialPoints);
        super.setHashedPassword(this.getUsername().length() * PASSWORD_MODIFIER);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString())
                .append(String.format("%s", this.getSpecialPoints() * this.getLevel()));

        return sb.toString();
    }
}
