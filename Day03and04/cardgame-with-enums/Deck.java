
package cardgame;

import java.util.Collections;
import java.util.LinkedList;

public class Deck {
    private LinkedList<Card> cards;
    
    public Deck() {
        this.cards = new LinkedList();
        for (Suit s : Suit.values()) {
            for (int i = Card.MIN_RANK; i<= Card.MAX_RANK; ++i) {
                Card c = new Card(s, i);
                cards.add(c);
            }
        }
    }
    
    public int count() {
        return cards.size();
    }
    
    public Card draw() {
        return cards.pop();
    }
    
    public void shuffle() {
        Collections.shuffle(cards);
    }
    
    public Card peek() {
        return cards.peek();
    }
}
