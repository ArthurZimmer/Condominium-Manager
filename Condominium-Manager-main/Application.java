import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Condominium condominium = new Condominium();
        int option;

        do {
            printMenu();
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    addLot(condominium, scanner);
                    break;
                case 2:
                    removeLot(condominium, scanner);
                    break;
                case 3:
                    showAllLots(condominium);
                    break;
                case 4:
                    searchLotByOwner(condominium, scanner);
                    break;
                case 5:
                    showSmallestLot(condominium);
                    break;
                case 6:
                    showMostResidentsLot(condominium);
                    break;
                case 7:
                    changeLotOwner(condominium, scanner);
                    break;
                case 8:
                    changeConstructionStatus(condominium, scanner);
                    break;
                case 9:
                    showMonthlyRevenue(condominium);
                    break;
                case 10:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        } while (option != 10);
    }
    
    // Print main menu:
    private static void printMenu() {
        System.out.println("\n------ Condominium Management ------");
        System.out.println("1 - Add lot");
        System.out.println("2 - Remove lot");
        System.out.println("3 - Show all lots");
        System.out.println("4 - Locate lot by owner's name");
        System.out.println("5 - Show lot with smallest area");
        System.out.println("6 - Show lot with most residents");
        System.out.println("7 - Change lot owner");
        System.out.println("8 - Change lot construction status");
        System.out.println("9 - Show monthly revenue");
        System.out.println("10 - Exit");
        System.out.print("Choose an option: ");
    }
    
    // Create and add a lot:
    private static void addLot(Condominium condominium, Scanner scanner) {
        int residents, occupation;
        double width, depth, monthlyValue;
        String ownerName;
        boolean construction = false;

        System.out.print("Enter lot width: ");
        width = scanner.nextDouble();

        System.out.print("Enter lot depth: ");
        depth = scanner.nextDouble();

        System.out.print("Enter monthly fee: ");
        monthlyValue = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter owner's name: ");
        ownerName = scanner.nextLine();

        System.out.print("Enter number of residents: ");
        residents = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter occupation type (1-construction, 2-empty): ");
        occupation = scanner.nextInt();
        scanner.nextLine();

        if (occupation == 1) {
            construction = true;
        } else if (occupation == 2) {
            construction = false;
        } else {
            System.out.println("Invalid occupation type!");
            return;
        }

        Landowner owner = new Landowner(ownerName, residents);
        Lot land = new Lot(width, depth, monthlyValue, owner, construction);

        if (condominium.addLot(land)) {
            System.out.println("Lot  has been registered successfully!");
        } else {
            System.out.println("Error. Lot could not be registered!");
        }
    }
    
    // Remove a lot from de database:
    private static void removeLot(Condominium condominium, Scanner scanner) {
        int removeCode;

        System.out.print("Enter the code of the lot to be removed: ");
        removeCode = scanner.nextInt();
        scanner.nextLine();

        if (condominium.removeLot(removeCode)) {
            System.out.println("Lot removed successfully!");
        } else {
            System.out.println("Error. Lot could not be removed!");
        }
    }
    
    // Show all currently registered lots in the database:
    private static void showAllLots(Condominium condominium) {
        condominium.showLotDatabase();
    }
    
    // Search and show lot by owner name:
    private static void searchLotByOwner(Condominium condominium, Scanner scanner) {
        String searchOwner;

        System.out.print("Enter owner's name: ");
        searchOwner = scanner.nextLine();

        Lot locatedLot = condominium.locateLotByOwnerName(searchOwner);

        if (locatedLot != null) {
            System.out.println(locatedLot);
        } else {
            System.out.println("No lot has been assigned to this owner.");
        }
    }
    
    // Show lot with the smallest area:
    private static void showSmallestLot(Condominium condominium) {
        Lot smallest = condominium.locateSmallestLot();

        if (smallest != null) {
            System.out.println(smallest);
        } else {
            System.out.println("No lots have been registered.");
        }
    }
    
    // Show lot with the most residents:
    private static void showMostResidentsLot(Condominium condominium) {
        Lot largestFamily = condominium.locateLotWithMostResidents();

        if (largestFamily != null) {
            System.out.println(largestFamily);
        } else {
            System.out.println("No lots have been registered.");
        }
    }
    
    // Change the owner of a lot:
    private static void changeLotOwner(Condominium condominium, Scanner scanner) {
        int changeOwnerCode, newResidents;
        String newOwnerName;

        System.out.print("Enter lot code: ");
        changeOwnerCode = scanner.nextInt();
        scanner.nextLine();

        Lot lotToChangeOwner = condominium.locateLotByCode(changeOwnerCode);

        if (lotToChangeOwner == null) {
            System.out.println("Lot does no exist..");
            return;
        }

        System.out.print("Enter new owner's name: ");
        newOwnerName = scanner.nextLine();

        System.out.print("Enter new number of residents: ");
        newResidents = scanner.nextInt();
        scanner.nextLine();

        Landowner newOwner = new Landowner(newOwnerName, newResidents);

        if (condominium.changeOwner(changeOwnerCode, newOwner)) {
            System.out.println("Owner updated successfully!");
        } else {
            System.out.println("Error. Owner could not be changed!");
        }
    }

    // Change the construction status of a lot:
    private static void changeConstructionStatus(Condominium condominium, Scanner scanner) {
        int changeConstrCode, newConstrStatus;

        System.out.print("Enter the code of the lot to be updated: ");
        changeConstrCode = scanner.nextInt();
        scanner.nextLine();

        Lot lotToChangeConstr = condominium.locateLotByCode(changeConstrCode);

        if (lotToChangeConstr == null) {
            System.out.println("Lot does not exist.");
            return;
        }

        System.out.print("Enter new construction status (1-construction, 2-empty): ");
        newConstrStatus = scanner.nextInt();
        scanner.nextLine();

        boolean newConstrBool;

        if (newConstrStatus == 1) {
            newConstrBool = true;
        } else if (newConstrStatus == 2) {
            newConstrBool = false;
        } else {
            System.out.println("Invalid status!");
            return;
        }

        if (condominium.changeConstructionStatus(changeConstrCode, newConstrBool)) {
            System.out.println("Construction status changed successfully!");
        } else {
            System.out.println("Error. Construction statuts could not be changed!");
        }
    }

    // Show condominium monthly revenue from all lots:
    private static void showMonthlyRevenue(Condominium condominium) {
        System.out.println("\nMonthly revenue: " + condominium.monthlyRevenue());
    }
}