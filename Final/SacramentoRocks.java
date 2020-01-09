package sacramentorocks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import jdk.nashorn.internal.objects.Global;

public class SacramentoRocks {

    public static void main(String[] args) {
        List<Transaction> transactions = new ArrayList();
        Path filePath = Paths.get("sacramento-realestate.csv"); //Reading from a file
        try {
            List<String> readLines = Files.readAllLines(filePath);
            readLines.remove(0); //Ignore the header line.
            for (String line : readLines) {
                Transaction t = Transaction.parseTransaction(line);
                transactions.add(t);
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
        
        System.out.println("Avg PPSF: " + 
                getAvgPricePerSquareFoot(transactions));
        System.out.println("Sacramento Avg Price: " + 
                getAvgSalePriceInSacramento(transactions));
        System.out.println("Most common bedroom count: " + 
                getMostCommonNumberOfBedrooms(transactions));
        System.out.println("Number of 5 bedroom houses sold: " + 
                getBedroomCountSums(transactions)[5]);
        System.out.println("Number of Unknown Type sold: " + 
                getTypeCount(transactions, ResidenceType.UNKNOWN));
        System.out.println("Number of Residential Type sold: " + 
                getTypeCount(transactions, ResidenceType.RESIDENTIAL));
        System.out.println("Avg Bed to Bath ratio: " + 
                getBedToBathRatio(transactions));
    }
    
    public static double getBedToBathRatio(List<Transaction> ts) {
        int count = 0;
        double ratioSum = 0;
        for (Transaction t : ts) {
            if (t.getBeds() == 0 || t.getBaths() == 0)
                continue;
            double ratio = ((double)t.getBeds()) / t.getBaths();
            ratioSum += ratio;
            count++;
        }
        return ratioSum/count;
    }
    
    public static int getTypeCount(List<Transaction> ts, ResidenceType type) {
        int count = 0;
        for (Transaction t : ts) {
            if (t.getType() == type)
                ++count;
        }
        return count;
    }
    
    public static int[] getBedroomCountSums(List<Transaction> ts) {
        int[] beds = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (Transaction t : ts) {
            beds[t.getBeds()]++;
        }
        return beds;
    }
    
    public static int getMostCommonNumberOfBedrooms(List<Transaction> ts) {
        int[] beds = getBedroomCountSums(ts);
        int max = -1;
        int maxLoc = -1;
        for (int i=0; i<10; ++i) {
            if (max < beds[i]) {
                max = beds[i];
                maxLoc = i;
            }
        }
        return maxLoc;
    }
    
    public static double getAvgSalePriceInSacramento(List<Transaction> ts) {
        double sum = 0;
        double count = 0;
        for (Transaction t : ts) {
            if (!t.getCity().equalsIgnoreCase("SACRAMENTO"))
                continue;
            sum += t.getPrice();
            ++count;
        }
        return sum/count;
    }
    
    public static double getAvgPricePerSquareFoot(List<Transaction> ts) {
        double sum = 0;
        int count = 0;
        for (Transaction t : ts) {
            double price = t.getPpsf();
            if (price == Global.Infinity)
                continue;
            sum += price;
            ++count;
        }
        return sum / count;
    }
}
