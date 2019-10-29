package interfacesrock;

public class Dog extends Mammal implements ServicePet, Hairy {
    
    private String vaccinations;

    @Override
    public String getVaccinations() {
        return vaccinations;
    }

    @Override
    public void setVaccinations(String vaccinations) {
        this.vaccinations = vaccinations;
    }

    @Override
    public void play() {
        System.out.println("Woof woof, mothaf*****");
    }

    @Override
    public void shed() {
        System.out.println("There's fur all over the damn couch.");
    }

    @Override
    public void assistTheDifferentlyAbled() {
        System.out.println("No human, don't walk in the street!");
    }

}
