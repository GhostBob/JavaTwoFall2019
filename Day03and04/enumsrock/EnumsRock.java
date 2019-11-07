
package enumsrock;

public class EnumsRock {

    public static void main(String[] args) {
        Drink myDrink = Drink.COKE;
        Drink drink2 = Drink.valueOf("DRPEPPER");
//        Drink drink3 = Drink.valueOf("sprite");
        System.out.println(myDrink);
    }
    
}
