package cardsrock;

import java.util.List;

public class CardsRock {

    public static void main(String[] args) {
        Deck cardDeck = new Deck();
        cardDeck.shuffle();
        List<Card> hand = cardDeck.draw(5);
        for (Card c : hand) {
            System.out.println(c);
        }
        cardDeck.order();
        List<Card> hand2 = cardDeck.draw(5);
        for (Card c : hand2) {
            System.out.println(c);
        }
//        Card c = new Card("Spades", 1);
//        cardDeck.add(c);
        for (int i =0; i<52; ++i) {
            Card c2 = cardDeck.draw();
            System.out.println(c2);
        }
    }
}
