
package cardgame;

public class Card implements Comparable<Object> {
    
    public static final int MIN_RANK = 2;
    public static final int MAX_RANK = 14;
    
    private int rank;
    private Suit suit;
    
    public Card(Suit suit, int rank) {
        super();
        
        this.suit = suit;
        
        if (rank < MIN_RANK || rank > MAX_RANK) {
            this.rank = MIN_RANK;
        }
        else {
            this.rank = rank;
        }
    }

    @Override
    public String toString() {
        return this.rankName() + " of " + this.suit;
    }
    
    public String rankName() {
        if (this.rank <= 10)
            return "" + this.rank;
        else if (this.rank == 11)
            return "JACK";
        else if (this.rank == 12)
            return "QUEEN";
        else if (this.rank == 13)
            return "KING";
        return "ACE";
    }

    @Override
    public int compareTo(Object o) {
        Card c = (Card)o;
        if (this.suit == c.suit) {
            return Integer.compare(this.rank, c.rank);
        }
        else {
            return this.suit.compareTo(c.suit);
        }
        /*
        if (this.suit == Suit.SPADES && c.suit != Suit.SPADES) {
            return 1;
        }
        else if (this.suit != Suit.SPADES && c.suit == Suit.SPADES) {
            return -1;
        }
        else if (this.suit == c.suit) {
            return Integer.compare(this.rank, c.rank);
        }
        else {
            return 0;
        }
*/
    }
}
