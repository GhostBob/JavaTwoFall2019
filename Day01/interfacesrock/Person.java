
package interfacesrock;

import java.util.ArrayList;

public class Person extends Mammal implements Hairy {

    private ArrayList<Pet> pets;
    
    public Person() {
        this.pets = new ArrayList();
    }

    public ArrayList<Pet> getPets() {
        return (ArrayList<Pet>)pets.clone();
    }
    
    public void addPet(Pet p) {
        this.pets.add(p);
    }

    @Override
    public void shed() {
        System.out.println("There's hair all up in the shower drain.");
    }
}
