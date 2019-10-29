package interfacesrock;

public class Cat extends Mammal implements Pet {

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
        System.out.println("Meow meow, I'm a sociopath.");
    }
    
}
