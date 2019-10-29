package interfacesrock;

public class Fish implements Pet {

    private String vaccinations;
    
    @Override
    public String getVaccinations() {
        return this.vaccinations;
    }

    @Override
    public void setVaccinations(String vaccinations) {
        this.vaccinations = vaccinations;
    }

    @Override
    public void play() {
        System.out.println("Glug glug, the fish is playing...");
    }

}
