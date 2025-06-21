import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Condominio condominium = new Condominio();
        int option;

        do {
            printMenu();
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    addLand(condominium, scanner);
                    break;
                case 2:
                    removeLand(condominium, scanner);
                    break;
                case 3:
                    showAllLands(condominium);
                    break;
                case 4:
                    searchLandByOwner(condominium, scanner);
                    break;
                case 5:
                    showSmallestLand(condominium);
                    break;
                case 6:
                    showLargestFamilyLand(condominium);
                    break;
                case 7:
                    changeLandOwner(condominium, scanner);
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

    private static void printMenu() {
        System.out.println("\n------ Condominium Land Management ------");
        System.out.println("1 - Add land");
        System.out.println("2 - Remove land");
        System.out.println("3 - Show all lands");
        System.out.println("4 - Search and show land by owner's name");
        System.out.println("5 - Show land with smallest area");
        System.out.println("6 - Show land with largest family");
        System.out.println("7 - Change land owner");
        System.out.println("8 - Change construction status");
        System.out.println("9 - Show monthly revenue");
        System.out.println("10 - Exit");
        System.out.print("Choose an option: ");
    }

    private static void addLand(Condominio condominium, Scanner scanner) {
        int code, residents, occupation;
        double base, height, monthlyValue;
        String ownerName;
        boolean construction = false;

        System.out.print("Enter land code: ");
        code = scanner.nextInt();
        scanner.nextLine();

        if (condominium.findLandByCode(code) != null) {
            System.out.println("Land with this code already exists!");
            return;
        }

        System.out.print("Enter base: ");
        base = scanner.nextDouble();

        System.out.print("Enter height: ");
        height = scanner.nextDouble();

        System.out.print("Enter monthly value: ");
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

        Proprietario owner = new Proprietario(ownerName, residents);
        Terreno land = new Terreno(code, base, height, monthlyValue, owner, construction);

        if (condominium.addLand(land)) {
            System.out.println("Land added successfully!");
        } else {
            System.out.println("Could not add land!");
        }
    }

    private static void removeLand(Condominio condominium, Scanner scanner) {
        int removeCode;

        System.out.print("Enter land code to remove: ");
        removeCode = scanner.nextInt();
        scanner.nextLine();

        if (condominium.removeLand(removeCode)) {
            System.out.println("Land removed successfully!");
        } else {
            System.out.println("Could not remove land!");
        }
    }

    private static void showAllLands(Condominio condominium) {
        condominium.showLands();
    }

    private static void searchLandByOwner(Condominio condominium, Scanner scanner) {
        String searchOwner;

        System.out.print("Enter owner's name: ");
        searchOwner = scanner.nextLine();

        Terreno foundLand = condominium.findLandByOwnerName(searchOwner);

        if (foundLand != null) {
            System.out.println(foundLand);
        } else {
            System.out.println("No land found for this owner.");
        }
    }

    private static void showSmallestLand(Condominio condominium) {
        Terreno smallest = condominium.findSmallestLand();

        if (smallest != null) {
            System.out.println(smallest);
        } else {
            System.out.println("No lands registered.");
        }
    }

    private static void showLargestFamilyLand(Condominio condominium) {
        Terreno largestFamily = condominium.findLandWithLargestFamily();

        if (largestFamily != null) {
            System.out.println(largestFamily);
        } else {
            System.out.println("No lands registered.");
        }
    }

    private static void changeLandOwner(Condominio condominium, Scanner scanner) {
        int changeOwnerCode, newResidents;
        String newOwnerName;

        System.out.print("Enter land code: ");
        changeOwnerCode = scanner.nextInt();
        scanner.nextLine();

        Terreno landToChangeOwner = condominium.findLandByCode(changeOwnerCode);

        if (landToChangeOwner == null) {
            System.out.println("Land not found.");
            return;
        }

        System.out.print("Enter new owner's name: ");
        newOwnerName = scanner.nextLine();

        System.out.print("Enter new number of residents: ");
        newResidents = scanner.nextInt();
        scanner.nextLine();

        Proprietario newOwner = new Proprietario(newOwnerName, newResidents);

        if (condominium.changeOwner(changeOwnerCode, newOwner)) {
            System.out.println("Owner changed successfully!");
        } else {
            System.out.println("Could not change owner!");
        }
    }

    private static void changeConstructionStatus(Condominio condominium, Scanner scanner) {
        int changeConstrCode, newConstrStatus;

        System.out.print("Enter land code: ");
        changeConstrCode = scanner.nextInt();
        scanner.nextLine();

        Terreno landToChangeConstr = condominium.findLandByCode(changeConstrCode);

        if (landToChangeConstr == null) {
            System.out.println("Land not found.");
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
            System.out.println("Could not change construction status!");
        }
    }

    private static void showMonthlyRevenue(Condominio condominium) {
        System.out.println("Monthly revenue: " + condominium.monthlyRevenue());
    }
}