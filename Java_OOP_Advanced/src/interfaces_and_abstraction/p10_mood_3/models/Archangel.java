package interfaces_and_abstraction.p10_mood_3.models;

public class Archangel extends GameObject<Integer, String> {
    private static final int PASSWORD_MODIFIER = 21;
    public Archangel(String username, int level, Integer specialPoints) {
        super(username, level, specialPoints);
        StringBuilder sb = new StringBuilder(this.getUsername()).reverse()
                .append(this.getUsername().length() * PASSWORD_MODIFIER);
        super.setHashedPassword(sb.toString());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString())
                .append(String.format("%s", this.getSpecialPoints() * this.getLevel()));

        return sb.toString();
    }
}
