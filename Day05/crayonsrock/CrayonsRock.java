package crayonsrock;

public class CrayonsRock {

    public static void main(String[] args) {
        CrayonBox box = new CrayonBox("My Crayons");
        CrayonBox box2 = CrayonBox.createTwelvePack();
        
        try {
            box.addCrayon(new Crayon(Color.RED));
            Crayon violet = box2.grabCrayon(Color.VIOLET);
            violet.color();
            violet.usedPercentage = 99;
            violet.color();
            violet.color();
            System.out.println("Violet percentage: " + violet.usedPercentage);
            System.out.println(box2);
            box.addCrayon(box2.grabCrayon(Color.RED));
        }
        catch (DuplicateCrayonException e) {
            System.out.println("Oopsie! There's a crayon of that color" + 
                    " already there!");
        }
    }
}
