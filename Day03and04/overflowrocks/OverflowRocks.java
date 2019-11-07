package overflowrocks;

public class OverflowRocks {

    public static void main(String[] args) {
        try {
            validateZip("1234");
            System.out.println("This might be important!");
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
        System.out.println("Hi");
        
//        System.out.println("A");
//        try {
//            System.out.println("B");
//            int x = 3 / 0;
//            System.out.println("C");
//            foo();
//        } catch (IndexOutOfBoundsException e) {
//            System.out.println("D");
//            System.out.println(e);
//        } catch (ArithmeticException e) {
//            System.out.println("E");
//            System.out.println(e);
//        } catch (Exception e) {
//            System.out.println("I gobble them all!");
//        }
//        
//        int y = 3 / 0;
//        System.out.println("F");
    }
    
    public static void foo() throws Exception {
        System.out.println("foo!");
        throw new Exception("Hahah, I break you!");
    }
    
    public static void validateZip(String zip) {
        char[] chars = zip.toCharArray();
        if (chars.length != 5) {
            throw new ZipCodeSuxException("Zip codes are 5 digits!");
        }
        for (char c : chars) {
            if (! Character.isDigit(c)) {
                throw new IllegalArgumentException("Invalid Zip Code");
            }
        }
        System.out.println("Looks ok to me.");
    }

}
