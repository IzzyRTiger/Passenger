import java.util.Scanner;

public class PassengerManifest {
    public static void main(String[] args) {
        Passenger[] manifest = new Passenger[12];
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an action:");
            System.out.println("1. Insert passenger");
            System.out.println("2. Remove passenger");
            System.out.println("3. Switch seats");
            System.out.println("4. Rename passenger");
            System.out.println("5. Count passengers");
            System.out.println("6. Print passenger manifest");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    insertPassenger(manifest, scanner);
                    break;
                case 2:
                    removePassenger(manifest, scanner);
                    break;
                case 3:
                    switchSeats(manifest, scanner);
                    break;
                case 4:
                    renamePassenger(manifest, scanner);
                    break;
                case 5:
                    countPassengers(manifest);
                    break;
                case 6:
                    printPassengerManifest(manifest);
                    break;
                case 7:
                    System.out.println("Exiting the program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    public static void insertPassenger(Passenger[] manifest, Scanner scanner) {
        System.out.print("Enter passenger name: ");
        String name = scanner.nextLine();
        System.out.print("Enter passenger age: ");
        int age = scanner.nextInt();

        for (int i = 0; i < manifest.length; i++) {
            if (manifest[i] == null) {
                manifest[i] = new Passenger(name, age);
                System.out.println("Passenger inserted into seat " + (i + 1) + ".");
                return;
            
            }
        }

        System.out.println("Manifest is full. Cannot insert more passengers.");
    }

    public static void removePassenger(Passenger[] manifest, Scanner scanner) {
        System.out.print("Enter the seat number to remove the passenger: ");
        int seatNumber = scanner.nextInt();

        if (seatNumber >= 1 && seatNumber <= manifest.length && manifest[seatNumber - 1] != null) {
            manifest[seatNumber - 1] = null;
            System.out.println("Passenger removed from seat " + seatNumber + ".");
        } else {
            System.out.println("Invalid seat number or the seat is empty.");
        }
    }

    public static void switchSeats(Passenger[] manifest, Scanner scanner) {
        System.out.print("Enter the first seat number to switch: ");
        int seat1 = scanner.nextInt();
        System.out.print("Enter the second seat number to switch: ");
        int seat2 = scanner.nextInt();

        if (seat1 >= 1 && seat1 <= manifest.length && seat2 >= 1 && seat2 <= manifest.length) {
            Passenger temp = manifest[seat1 - 1];
            manifest[seat1 - 1] = manifest[seat2 - 1];
            manifest[seat2 - 1] = temp;
            System.out.println("Seats " + seat1 + " and " + seat2 + " switched.");
        } else {
            System.out.println("Invalid seat numbers.");
        } 
    }

    public static void renamePassenger(Passenger[] manifest, Scanner scanner) {
        System.out.print("Enter the seat number to rename the passenger: ");
        int seatNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter the new passenger name: ");
        String newName = scanner.nextLine();

        if (seatNumber >= 1 && seatNumber <= manifest.length && manifest[seatNumber - 1] != null) {
            manifest[seatNumber - 1].setName(newName);
            System.out.println("Passenger in seat " + seatNumber + " has been renamed to " + newName + ".");
        } else {
            System.out.println("Invalid seat number or the seat is empty.");
        }
    }

    public static void countPassengers(Passenger[] manifest) {
        int count = 0;
        for (Passenger passenger : manifest) {
            if (passenger != null) {
                count++;
            }
        }
        System.out.println("Current number of passengers: " + count);
    }
    
    public static void printPassengerManifest(Passenger[] manifest) {
        System.out.println("####PASSENGER MANIFEST####");
        System.out.println("SkyBox Ltd.");
        System.out.println("Seat"    + "\t" + "Name"  + "\t" +  "Age");
        for (int i = 0; i < manifest.length; i++) {
            System.out.print((i + 1) + "\t");
           if (manifest[i] != null) {
        System.out.print(manifest[i].getName() + "\t");
        System.out.println(manifest[i].getAge());
            
            } else {
                System.out.println("Empty");
            }
        }
        System.out.println("#### #### #### #### #### ##");
    }
}