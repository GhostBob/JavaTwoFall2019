package crayonsrock;

import java.util.Set;
import java.util.TreeSet;

public class CrayonBox {

    private String name;
    private final Set<Crayon> crayons;

    public CrayonBox(String name) {
        this.name = name;
        this.crayons = new TreeSet();
    }
    
    public static CrayonBox createTwelvePack() {
        CrayonBox box = new CrayonBox("Standard 12-Pack");
        for (Color c : Color.values()) {
            Crayon crayon = new Crayon(c);
            try {
                box.addCrayon(crayon);
            } catch (DuplicateCrayonException ex) {
                System.out.println("I should never get here...");
            }
        }
        return box;
    }
    
    public void addCrayon(Crayon c) throws DuplicateCrayonException {
        if (this.crayons.contains(c))
            throw new DuplicateCrayonException();
        this.crayons.add(c);
    }
    
    public Crayon grabCrayon(Color c) {
        for (Crayon crayon : this.crayons) {
            if (crayon.color == c) {
                this.crayons.remove(crayon);
                return crayon;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.name + ": a box of " + this.crayons.size() + " crayons.";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


