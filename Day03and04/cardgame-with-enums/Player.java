
package cardgame;

import java.util.ArrayList;
import java.util.List;

public class Player implements Comparable<Object> {
    private List<Card> hand;
    private String name;
    
    public Player(String name) {
        this.name = name;
        hand = new ArrayList(13);
    }

    public List<Card> getHand() {
        return hand;
    }

    public void setHand(List<Card> hand) {
        this.hand = hand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
    
    @Override
    public int compareTo(Object o) {
        Player p = (Player)o;
        return this.name.compareTo(p.name);
    }
    
    
}
