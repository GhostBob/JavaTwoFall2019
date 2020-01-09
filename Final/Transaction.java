package sacramentorocks;

public class Transaction {

    private String street;
    private String city;
    private int zip;
    private String state;
    private int beds;
    private int baths;
    private int squareFeet;
    private ResidenceType type;
    private Weekday saleDate;
    private int price;
    private double latitude;
    private double longitude;

    public Transaction(String street, String city, int zip, String state, int beds, int baths, int squareFeet, ResidenceType type, Weekday saleDate, int price, double latitude, double longitude) {
        this.street = street;
        this.city = city;
        this.zip = zip;
        this.state = state;
        this.beds = beds;
        this.baths = baths;
        this.squareFeet = squareFeet;
        this.type = type;
        this.saleDate = saleDate;
        this.price = price;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    
    public static Transaction parseTransaction(String line) {
        String[] cols = line.split(",");
        String street = cols[0].trim();
        String city = cols[1].trim();
        int zip = Integer.parseInt(cols[2].trim());
        String state = cols[3].trim();
        int beds = Integer.parseInt(cols[4].trim());
        int baths = Integer.parseInt(cols[5].trim());
        int squareFeet = Integer.parseInt(cols[6].trim());
        String typeStr = cols[7].trim();
        ResidenceType type;
        if (typeStr.equals("Residential"))
            type = ResidenceType.RESIDENTIAL;
        else if (typeStr.equals("Condo"))
            type = ResidenceType.CONDO;
        else if (typeStr.equals("Multi-Family"))
            type = ResidenceType.MULTIFAMILY;
        else
            type = ResidenceType.UNKNOWN;
        String dateStr = cols[8].trim().split(" ")[0];
        Weekday date;
        if (dateStr.equals("Mon"))
            date = Weekday.MONDAY;
        else if (dateStr.equals("Tue"))
            date = Weekday.TUESDAY;
        else if (dateStr.equals("Wed"))
            date = Weekday.WEDNESDAY;
        else if (dateStr.equals("Thu"))
            date = Weekday.THURSDAY;
        else
            date = Weekday.FRIDAY;
        int price = Integer.parseInt(cols[9].trim());
        double latitude = Double.parseDouble(cols[10].trim());
        double longitude = Double.parseDouble(cols[11].trim());
        
        return new Transaction(street, city, zip, state, beds, baths, 
                squareFeet, type, date, price, latitude, longitude);
    }
    
    public double getPpsf() {
        return ((double)this.price) / this.squareFeet;
    }

    
    // ** STANDARD GETTERS AND SETTERS ** 
    
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getBeds() {
        return beds;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }

    public int getBaths() {
        return baths;
    }

    public void setBaths(int baths) {
        this.baths = baths;
    }

    public int getSquareFeet() {
        return squareFeet;
    }

    public void setSquareFeet(int squareFeet) {
        this.squareFeet = squareFeet;
    }

    public ResidenceType getType() {
        return type;
    }

    public void setType(ResidenceType type) {
        this.type = type;
    }

    public Weekday getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Weekday saleDate) {
        this.saleDate = saleDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    
    
}
