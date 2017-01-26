

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

public class HandsOfCards {
    private static BufferedReader CONSOLE = new BufferedReader(new InputStreamReader(System.in));

    private static final HashMap<String, Integer> POWERS = new HashMap<>();

    private static LinkedHashMap<String, HashSet<String>> PLAYER_DECKS = new LinkedHashMap<>();

    static {
        POWERS.put("2", 2);
        POWERS.put("3", 3);
        POWERS.put("4", 4);
        POWERS.put("5", 5);
        POWERS.put("6", 6);
        POWERS.put("7", 7);
        POWERS.put("8", 8);
        POWERS.put("9", 9);
        POWERS.put("10", 10);
        POWERS.put("J", 11);
        POWERS.put("Q", 12);
        POWERS.put("K", 13);
        POWERS.put("A", 14);

        POWERS.put("S", 4);
        POWERS.put("H", 3);
        POWERS.put("D", 2);
        POWERS.put("C", 1);
    }

    public static void main(String[] args) throws IOException {
        String input;

        while (true) {
            input = CONSOLE.readLine();

            if (input.equals("JOKER"))
                break;

            StringTokenizer playerData = new StringTokenizer(input, ":");

            String name = playerData.nextToken();
            StringTokenizer playerCardData = new StringTokenizer(playerData.nextToken().trim(), ", ");

            if (!PLAYER_DECKS.containsKey(name))
                PLAYER_DECKS.put(name, new HashSet<>());

            while (playerCardData.hasMoreTokens()) {
                String card = playerCardData.nextToken();

                PLAYER_DECKS.get(name).add(card);
            }
        }

        StringBuilder output = new StringBuilder("");
        for (String name : PLAYER_DECKS.keySet()) {
            Integer totalScore = 0;
            for (String card : PLAYER_DECKS.get(name)) {
                Integer power = getCardPower(card);
                totalScore += power;
            }
            String outputLine = String.format("%s: %s", name, totalScore);

            output.append(outputLine).append("\n");
        }

        System.out.println(output);
    }

    private static Integer getCardPower(String card) {
        StringBuilder cardData = new StringBuilder(card);

        String type = "" + cardData.charAt(card.length() - 1);
        Integer mult = POWERS.get(type);

        cardData.deleteCharAt(card.length() - 1);

        return POWERS.get(cardData.toString()) * mult;
    }
}
