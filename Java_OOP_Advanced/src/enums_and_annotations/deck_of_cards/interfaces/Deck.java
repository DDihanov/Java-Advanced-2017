package enums_and_annotations.deck_of_cards.interfaces;


import enums_and_annotations.deck_of_cards.models.Card;

public interface Deck {

    Card receiveCardFromDeck(String cardName);

}
