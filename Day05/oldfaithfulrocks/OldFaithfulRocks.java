package oldfaithfulrocks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class OldFaithfulRocks {

    public static void main(String[] args) {
        List<OFMeasurement> measures = getMeasurements();
        
        int waitSum = 0;
        double durationSum = 0;
        int minWait = Integer.MAX_VALUE;
        int maxWait = Integer.MIN_VALUE;
        double minDuration = Double.MAX_VALUE;
        double maxDuration = Double.MIN_VALUE;
        
        for (OFMeasurement measure : measures) {
            waitSum += measure.waitTime;
            durationSum += measure.duration;
            
            if(measure.waitTime < minWait)
                minWait = measure.waitTime;
            if(measure.waitTime > maxWait)
                maxWait = measure.waitTime;
            if(measure.duration < minDuration)
                minDuration = measure.duration;
            if(measure.duration > maxDuration)
                maxDuration = measure.duration;
        }
        
        int numMeasurements = measures.size();
        double avgWait = ((double)waitSum / numMeasurements);
        double avgDuration = ((double)durationSum / numMeasurements);
        
        double waitDeviation = calcDeviation(measures, avgWait, true);
        double durationDeviation = calcDeviation(measures, avgDuration, false);
        
        System.out.println("\n\n");
        System.out.println("Avg wait: " + avgWait);
        System.out.println("Min wait: " + minWait);
        System.out.println("Max wait: " + maxWait);
        System.out.println("Std dev:  " + waitDeviation);
        System.out.println("");
        
        System.out.println("Avg duration:  " + avgDuration);
        System.out.println("Min duration:  " + minDuration);
        System.out.println("Max duration:  " + maxDuration);
        System.out.println("Std deviation: " + durationDeviation);
    }
    
    public static double calcDeviation(List<OFMeasurement> measures, double avg, 
            boolean isWait) {
        
        double sdSum = 0;
        for (OFMeasurement m : measures) {
            double temp;
            if (isWait)
                 temp = Math.pow(m.waitTime - avg, 2);
            else
                temp = Math.pow(m.duration - avg, 2);
            sdSum += temp;
        }
        double sdAvg = sdSum / (measures.size()-1);
        double standardDeviation = Math.sqrt(sdAvg);
        return standardDeviation;
    }
    
    public static List<OFMeasurement> getMeasurements() {
        List<OFMeasurement> measures = new ArrayList();
        Path filePath = Paths.get("old-faithful.csv"); //Reading from a file
        try {
            List<String> readLines = Files.readAllLines(filePath);
            readLines.remove(0); //Ignore the header line.
            for (String line : readLines) {
                String[] sections = line.split(",");
                int id = Integer.parseInt(sections[0].trim());
                double duration = Double.parseDouble(sections[1].trim());
                int wait = Integer.parseInt(sections[2].trim());
                OFMeasurement measure = new OFMeasurement(id, duration, wait);
                measures.add(measure);
                System.out.println(measure);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return measures;
    }
}
