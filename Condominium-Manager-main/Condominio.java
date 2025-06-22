import java.util.Arrays;

public class Condominio {
    private Terreno[] lands;
    private int count;
    private static final int MAX_LANDS = 30;

    // constructor
    public Condominio() {
        this.lands = new Terreno[MAX_LANDS];
        this.count = 0;
    }

    // add a land plot to the array
    public boolean addLand(Terreno land) {
        if (count >= MAX_LANDS || findLandByCode(land.getCode()) != null) {
            return false;
        }
        lands[count++] = land;
        return true;
    }

    // remove a land plot by code
    public boolean removeLand(int code) {
        for (int i = 0; i < count; i++) {
            if (lands[i].getCode() == code) {
                for (int j = i; j < count - 1; j++) {
                    lands[j] = lands[j + 1];
                }
                lands[--count] = null;
                return true;
            }
        }
        return false;
    }

    // find the position of a land plot in the array
    public int findPosition(Terreno land) {
        for (int i = 0; i < count; i++) {
            if (lands[i].equals(land)) {
                return i;
            }
        }
        return -1;
    }

    // find a land plot by owner's name
    public Terreno findLandByOwnerName(String ownerName) {
        for (int i = 0; i < count; i++) {
            if (lands[i].getOwner().getName().equalsIgnoreCase(ownerName)) {
                return lands[i];
            }
        }
        return null;
    }

    // Find a land plot by code
    public Terreno findLandByCode(int code) {
        for (int i = 0; i < count; i++) {
            if (lands[i].getCode() == code) {
                return lands[i];
            }
        }
        return null;
    }

    // find the land with the largest family
    public Terreno findLandWithLargestFamily() {
        if (count == 0) return null;
        Terreno maxLand = lands[0];
        for (int i = 1; i < count; i++) {
            if (lands[i].getOwner().getNumberOfResidents() > maxLand.getOwner().getNumberOfResidents()) {
                maxLand = lands[i];
            }
        }
        return maxLand;
    }

    // change the owner of a land plot
    public boolean changeOwner(int code, Proprietario newOwner) {
        Terreno land = findLandByCode(code);
        if (land != null) {
            land.setOwner(newOwner);
            return true;
        }
        return false;
    }

    // change the construction status of a land plot
    public boolean changeConstructionStatus(int code, boolean newStatus) {
        Terreno land = findLandByCode(code);
        if (land != null) {
            land.setConstruction(newStatus);
            return true;
        }
        return false;
    }

    // calculate the total monthly revenue
    public double monthlyRevenue() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += lands[i].getMonthValue();
        }
        return total;
    }

    // find the land with the smallest area
    public Terreno findSmallestLand() {
        if (count == 0) return null;
        Terreno minLand = lands[0];
        for (int i = 1; i < count; i++) {
            if (lands[i].calcularArea() < minLand.calcularArea()) {
                minLand = lands[i];
            }
        }
        return minLand;
    }

    // show all stored lands
    public void showLands() {
        if (count == 0) {
            System.out.println("No lands registered.");
        } else {
            for (int i = 0; i < count; i++) {
                System.out.println(lands[i]);
            }
        }
    }

    // get the number of lands
    public int getCount() {
        return count;
    }

    // get a copy of the lands array (for iteration)
    public Terreno[] getLands() {
        return Arrays.copyOf(lands, count);
    }
} 