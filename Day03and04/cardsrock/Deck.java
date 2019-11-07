package cardsrock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Deck {
    private LinkedList<Card> cards;
    
    public Deck() {
        this.cards = new LinkedList();
        for (String s : Card.getSuits()) {
            for (int i=1; i<14; ++i) {
                Card c = new Card(s, i);
                this.cards.add(c);
            }
        }
    }
    
    public void shuffle() {
        Collections.shuffle(cards);
    }
    
    public void order() {
        Collections.sort(cards);
    }
    
    public void add(Card c) {
        this.cards.add(c);
    }
    
    public void add(List<Card> cards) {
        for (Card c : cards) {
            this.cards.add(c);
        }
    }
    
    public Card draw() {
        if (this.cards.size() > 0)
            return this.cards.pop();
        return null;
    }
    
    public List<Card> draw(int num) {
        ArrayList<Card> drawn = new ArrayList();
        for (int i=0; i<num; ++i) {
            drawn.add(this.draw());
        }
        return drawn;
    }
}
