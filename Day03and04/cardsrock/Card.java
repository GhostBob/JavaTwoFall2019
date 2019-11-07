package cardsrock;

public class Card implements Comparable<Card>{
    public String suit;
    public int number;
    
    public Card(String suit, int num) {
        //TODO: Check the stuff to see if it's valid
        this.suit = suit;
        this.number = num;
    }
    
    public static String[] getSuits() {
        String[] suits = {"Hearts", "Clubs", "Diamonds", "Spades"};
        return suits;
    }
    
    @Override
    public String toString() {
        String cardString = "";
        if (this.number == 1) {
            cardString += "Ace";
        }
        else if (this.number < 11) {
            cardString += this.number;
        }
        else if (this.number == 11) {
            cardString += "Jack";
        }
        else if (this.number == 12) {
            cardString += "Queen";
        }
        else {
            cardString += "King";
        }
        cardString += " of ";
        cardString += this.suit;
        return cardString;
    }

    @Override
    public int compareTo(Card o) {
        String[] suits = Card.getSuits();
        int mySuit = 0;
        int theirSuit = 0;
        for (int i=0; i<suits.length; ++i) {
            if (suits[i].equals(this.suit))
                mySuit = i;
            if (suits[i].equals(o.suit))
                theirSuit = i;
        }
        if (mySuit == theirSuit) {
            return Integer.compare(this.number, o.number);
        }
        else {
            return Integer.compare(mySuit, theirSuit);
        }
    }
}
