package interfacesrock;

public class InterfacesRock {

    public static void main(String[] args) {
        Person bob = new Person();
        bob.addPet(new Cat());
        bob.addPet(new Dog());
        bob.addPet(new Fish());
        
        for (Pet p : bob.getPets()) {
            p.play();
            
            if (p instanceof ServicePet) {
                System.out.println("  --- It's a service animal, too!");
            }
        }
    }
    
}
