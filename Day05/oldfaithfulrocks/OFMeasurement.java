package oldfaithfulrocks;

public class OFMeasurement {
    public int id;
    public double duration;
    public int waitTime;

    public OFMeasurement(int measurementNumber, double duration, int waitTime) {
        this.id = measurementNumber;
        this.duration = duration;
        this.waitTime = waitTime;
    }

    @Override
    public String toString() {
        return this.id + ": " + this.duration + ", " + this.waitTime;
    }
    
    
}
