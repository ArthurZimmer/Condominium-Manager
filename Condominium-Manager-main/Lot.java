public class Lot {
    
    // Lot code and lot creation tracker (static):
    private int code;
    static private int tracker = 1;
    
    // Lot frontage (width) and depth:
    private double frontage;
    private double depth;
    
    // Condominium maintenance monthly fee:
    private double monthlyFee;
    
    // Landowner:
    private Landowner owner;
    
    // Flag if the lot has been built on:
    private boolean construction;
    
    // Constructor:
    public Lot(double frontage, double depth, double monthlyFee, Landowner owner, boolean construction) {
        this.code = tracker + 100;
        this.frontage = frontage;
        this.depth = depth;
        this.monthlyFee = monthlyFee;
        this.owner = owner;
        this.construction = construction;
        
        tracker++;
    }
    
    // Getter and setter for the lot code:
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    
    // Getter for tracker (there is no setter for this variable, seeing as how changing it would disrupt class functionality).
    public int getTracker(){
        return this.tracker;
    }
    
    // Getter and setter for the lot frontage: 
    public double getFrontage() {
        return frontage;
    }
    public void setFrontage(double frontage) {
        this.frontage = frontage;
    }
    
    // Getter and setter for the lot depth:
    public double getDepth() {
        return depth;
    }
    public void setDepth(double depth) {
        this.depth = depth;
    }
    
    // Getter and setter for the fee:
    public double getMonthlyFee() {
        return monthlyFee;
    }
    public void setMonthlyFee(double monthlyFee) {
        this.monthlyFee = monthlyFee;
    }

    // Getter and setter for the owner:
    public Landowner getOwner() {
        return owner;
    }
    public void setOwner(Landowner owner) {
        this.owner = owner;
    }

    // Getter and setter for construction flag:
    public boolean getConstruction() {
        return construction;
    }
    public void setConstruction(boolean construction) {
        this.construction = construction;
    }

    // Method for calculating the lot area:
    public double calculateArea() {
        return frontage*depth;
    }

    // toString method:
    public String toString() {
        return "Lot{" + "code=" + code +
                ", frontage=" + frontage
                + ", depth=" + depth
                + ", monthlyFee=" + monthlyFee
                + ", owner=" + owner
                + ", construction=" + construction + '}';
    }
}
