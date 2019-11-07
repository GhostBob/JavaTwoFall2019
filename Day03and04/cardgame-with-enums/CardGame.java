
package cardgame;

import java.util.Comparator;
import java.util.TreeSet;

public class CardGame {
    
    public Deck deck;
    public TreeSet<Player> players;
    
    public static String rules = "This is spades.";
    
    public CardGame() {
        deck = new Deck();
        deck.shuffle();
        
        players = new TreeSet();
        for (int i=1; i<=4; ++i) {
            Player p = new Player("Player " + i);
            players.add(p);
        }
    }

    public static void main(String[] args) {
        CardGame game = new CardGame();
        game.deal();
        System.out.println("Player's hand:");
        for (Card pCard : game.players.first().getHand()) {
            System.out.println(pCard);
        }
        System.out.println(game.players);
    }
    
    public void deal() {
        while (deck.peek() != null) {
            for (Player p : this.players) {
                Card c = deck.draw();
                p.getHand().add(c);
            }
        }
        for (Player p : this.players) {
            p.getHand().sort(new Comparator<Card>
            () {
                @Override
                public int compare(Card o1, Card o2) {
                    return o1.compareTo(o2);
                }
            });
        }
    }
    
    public void printRules() {
        System.out.println(rules);
    }
    
    public static void testCrap() {
        Card c = new Card(Suit.CLUBS, 2);
        System.out.println(c);
        Card c2 = new Card(Suit.SPADES, 14);
        System.out.println(c2);
        
        Deck d = new Deck();
        System.out.println(d.count());
        Card c3 = d.draw();
        System.out.println(c3);
        Card c4 = d.draw();
        System.out.println(c4);
        System.out.println(d.count());
        d.shuffle();
        Card c5 = d.draw();
        System.out.println(c5);
    }
}
