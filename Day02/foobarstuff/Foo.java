package foobarstuff;

public class Foo implements Stuff {

    @Override
    public void doStuff() {
        System.out.println("Foo stuff.");
    }

    @Override
    public void doStuff2() {
        System.out.println("Foo stuff 2.");
    }
    
    public void doStuff3() {
        System.out.println("Foo stuff 3.");
    }
}
