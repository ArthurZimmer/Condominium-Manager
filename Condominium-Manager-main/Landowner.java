public class Landowner {
    // Owner's name
    private String name;
    // Number of residents
    private int numberOfResidents;

    // Constructor
    public Landowner(String name, int numberOfResidents) {
        this.name = name;
        this.numberOfResidents = numberOfResidents;
    }

    // Getter and setter for name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    // Getter and setter for number of residents
    public int getNumberOfResidents() {
        return numberOfResidents;
    }
    public void setNumberOfResidents(int numberOfResidents) {
        this.numberOfResidents = numberOfResidents;
    }

    // toString method
    public String toString() {
        return "Landowner{" + "name='" + name + '\'' + ", numberOfResidents=" + numberOfResidents + '}';
    }
}