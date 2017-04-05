package enums_and_annotations.deck_of_cards.interfaces;


import enums_and_annotations.deck_of_cards.models.Card;

public interface CardPlayer extends Player {

    void addCard(Card card);

    Card getHighestCard();
}
