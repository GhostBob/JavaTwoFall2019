package foobarstuff;

public class FooBarStuff {

    public static void main(String[] args) {
        Foo foo = new Foo();
        Bar bar = new Bar();
        Stuff stuff1 = new Foo();
        Stuff stuff2 = new Bar();
        System.out.println("foo");
        foo.doStuff();
        foo.doStuff2();
        foo.doStuff3();
        System.out.println("bar");
        bar.doStuff();
        bar.doStuff2();
        bar.doMoreStuff();
        System.out.println("Stuff1");
        stuff1.doStuff();
        stuff1.doStuff2();
        if (stuff1 instanceof Foo) {
            ((Foo)stuff1).doStuff3();
        }
        System.out.println("Stuff2");
        stuff2.doStuff();
        stuff2.doStuff();
        if (stuff2 instanceof Bar) {
            Bar b = (Bar)stuff2;
            b.doMoreStuff();
        }
    }
}
