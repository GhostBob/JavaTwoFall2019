
package interfacesrock;

public abstract class Mammal {
    
    private final boolean warmblooded;

    public Mammal() {
        this.warmblooded = true;
    }

    public boolean isWarmblooded() {
        return warmblooded;
    }
}
