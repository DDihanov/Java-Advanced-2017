package enums_and_annotations.deck_of_cards;


import enums_and_annotations.deck_of_cards.interfaces.CardPlayer;
import enums_and_annotations.deck_of_cards.interfaces.Deck;
import enums_and_annotations.deck_of_cards.models.Card;
import enums_and_annotations.deck_of_cards.models.CardPlayerImpl;
import enums_and_annotations.deck_of_cards.models.DeckImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static BufferedReader bufferedReader;
    private static Deck deck;

    static {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        deck = new DeckImpl();
    }

    public static void main(String[] args) throws IOException {

        String playerOneName = bufferedReader.readLine();
        String playerTwoName = bufferedReader.readLine();

        CardPlayer firstPlayer = new CardPlayerImpl(playerOneName);
        CardPlayer secondPlayer = new CardPlayerImpl(playerTwoName);

        addCards(firstPlayer);
        addCards(secondPlayer);

        CardPlayer winner = determineWinner(firstPlayer, secondPlayer);
        System.out.printf("%s wins with %s.", winner.getName(), winner.getHighestCard());

    }

    private static void addCards(CardPlayer player) throws IOException {
        for (int index = 0; index < 5; index++) {
            String cardName = bufferedReader.readLine();
            try {
                Card card = deck.receiveCardFromDeck(cardName);
                player.addCard(card);
            } catch (IllegalArgumentException ex) {
                index--;
                System.out.println(ex.getMessage());
            }
        }
    }

    private static CardPlayer determineWinner(CardPlayer firstPlayer, CardPlayer secondPlayer) {

        Card firstPlayerBestCard = firstPlayer.getHighestCard();
        Card secondPlayerBestCard = secondPlayer.getHighestCard();

        int result = firstPlayerBestCard.compareTo(secondPlayerBestCard);

        return result > 0 ? secondPlayer : firstPlayer;
    }
}
