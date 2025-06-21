public class Proprietario {
    // Owner's name
    private String name;
    // Number of residents
    private int numberOfResidents;

    // Constructor
    public Proprietario(String name, int numberOfResidents) {
        this.name = name;
        this.numberOfResidents = numberOfResidents;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for number of residents
    public int getNumberOfResidents() {
        return numberOfResidents;
    }

    // Setter for number of residents
    public void setNumberOfResidents(int numberOfResidents) {
        this.numberOfResidents = numberOfResidents;
    }

    // toString method
    public String toString() {
        return "Owner{" + "name='" + name + '\'' + ", numberOfResidents=" + numberOfResidents + '}';
    }
}