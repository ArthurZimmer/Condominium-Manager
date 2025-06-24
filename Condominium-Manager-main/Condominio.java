import java.util.Arrays;

public class Condominium {
    private Lot[] lotDatabase;  
    private int index;
    private static final int MAX_LOTS = 30;

    // Constructor
    public Condominium() {
        this.lotDatabase = new Lot[MAX_LOTS];
        this.index = 0;
    }

    // Add a lot to the database array.
    // If array is maxed out or lot is already in the database, returns false. If registration is successful, returns true.
    public boolean addLot(Lot lot) {
        if (index >= MAX_LOTS || locateLotByCode(lot.getCode()) != null) {
            return false;
        } else {
            this.lotDatabase[index++] = lot;
            return true;
        }
    }

    // Remove a lot from the database by code:
    // If lot exists in the database, it is removed and the array is rearranged, and method returns true. Otherwise, it returns false.
    public boolean removeLot(int code) {
        for (int i = 0; i < index; i++) {
            if (lotDatabase[i].getCode() == code) {
                for (int j = i; j < index - 1; j++) {
                    lotDatabase[j] = lotDatabase[j + 1];
                }
                lotDatabase[--index] = null;
                return true;
            }
        }
        return false;
    }

    // Locate the position of a lot in the database array:
    // Locates position of the lot and returns it. If lot does not exist in the database, returns -1.
    public int locatePosition(Lot lot) {
        for (int i = 0; i < index; i++) {
            if (lotDatabase[i].equals(lot)) {
                return i;
            }
        }
        return -1;
    }

    // Locate a lot in the database by owner name:
    // Locates lot by owner name and returns it. If lot does not exist, returns null.
    public Lot locateLotByOwnerName(String ownerName) {
        for (int i = 0; i < index; i++) {
            if (lotDatabase[i].getOwner().getName().equalsIgnoreCase(ownerName)) {
                return lotDatabase[i];
            }
        }
        return null;
    }

    // Locate a lot in the database by code:
    // Locates lot by code and returns it. If lot does not exist, returns null.
    public Lot locateLotByCode(int code) {
        for (int i = 0; i < index; i++) {
            if (lotDatabase[i].getCode() == code) {
                return lotDatabase[i];
            }
        }
        return null;
    }

    // Locate lot with the most residents:
    // Locates the lot with the largest family and returns it. If no lots have been added to the database, returns null.
    public Lot locateLotWithMostResidents() {
        if (index == 0)
            return null;
        Lot maxPopLot = lotDatabase[0];
        for (int i = 1; i < index; i++) {
            if (lotDatabase[i].getOwner().getNumberOfResidents() > maxPopLot.getOwner().getNumberOfResidents()) {
                maxPopLot = lotDatabase[i];
            }
        }
        return maxPopLot;
    }

    // Change the owner of a lot:
    // Replace the landowner of a lot with a new owner and returns true. If lot code does not exist, returns false.
    public boolean changeOwner(int code, Landowner newOwner) {
        Lot lot = locateLotByCode(code);
        if (lot != null) {
            lot.setOwner(newOwner);
            return true;
        }
        return false;
    }

    // Change occupancy status of a lot:
    // Locates a lot by code and changes it's occupancy status. If lot does not exist, returns false.
    public boolean changeConstructionStatus(int code, boolean newStatus) {
        Lot lot = locateLotByCode(code);
        if (lot != null) {
            lot.setConstruction(newStatus);
            return true;
        }
        return false;
    }

    // Calculate the total monthly revenue:
    public double monthlyRevenue() {
        double total = 0;
        for (int i = 0; i < index; i++) {
            total += lotDatabase[i].getMonthlyFee();
        }
        return total;
    }

    // Locate the lot with the smallest area:
    // If no lots have been added to the database, returns null. Otherwise, returns the smallest lot.
    public Lot locateSmallestLot() {
        if (index == 0)
            return null;
        Lot minAreaLot = lotDatabase[0];
        for (int i = 1; i < index; i++) {
            if (lotDatabase[i].calculateArea() < minAreaLot.calculateArea()) {
                minAreaLot = lotDatabase[i];
            }
        }
        return minAreaLot;
    }

    // Show all lot database:
    public void showLotDatabase() {
        if (index == 0) {
            System.out.println("No lots hace been registered.");
        } else {
            for (int i = 0; i < index; i++) {
                System.out.println(lotDatabase[i]);
            }
        }
    }

    // Get the number of lots in the database.
    public int getIndex() {
        return index;
    }

    // Get a copy of the lotDatabase array (for iteration):
    public Lot[] getLotDatabase() {
        return Arrays.copyOf(lotDatabase, index);
    }
} 