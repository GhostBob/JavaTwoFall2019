package crayonsrock;

public class Crayon implements Comparable<Crayon> {

    public Color color;
    public int usedPercentage;

    public Crayon(Color color) {
        this.color = color;
        this.usedPercentage = 0;
    }
    
    public void color() {
        if (this.usedPercentage >= 100) {
            System.out.println("This crayon is used up!");
            return;
        }
        System.out.println("Doodle doo!");
        this.usedPercentage++;
        
    }

    @Override
    public int compareTo(Crayon o) {
        return this.color.compareTo(o.color);
    }
}
