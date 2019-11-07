package enumsrock;

public enum Drink {
    COKE("Coca-Cola"), PEPSI("Pepsi"), SPRITE("Sprite"), DRPEPPER("Dr Pepper");
    
    private String brandname;
    
    private Drink(String brand) {
        this.brandname = brand;
    }

    @Override
    public String toString() {
        return this.brandname;
    }
}
