package foobarstuff;

public class Bar implements Stuff {

    @Override
    public void doStuff() {
        System.out.println("Bar stuff.");
    }

    @Override
    public void doStuff2() {
        System.out.println("Bar stuff 2.");
    }
    
    public void doMoreStuff() {
        System.out.println("Bar more stuff.");
    }
}
