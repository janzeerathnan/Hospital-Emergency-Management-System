import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    static PatientBST patientBST = new PatientBST();
    static EmergencyQueue emergencyQueue = new EmergencyQueue();

    public static void main(String[] args) {

        int choice;

        do {

            displayMainMenu();

            choice = getIntInput("Enter your choice: ");

            switch (choice) {

                case 1:
                    patientManagement();
                    break;

                case 2:
                    emergencyQueueManagement();
                    break;

                case 3:
                    System.out.println(
                            "Treatment Management will be implemented on Day 2."
                    );
                    break;

                case 4:
                    System.out.println(
                            "Patient Visit History will be implemented on Day 2."
                    );
                    break;

                case 5:
                    System.out.println(
                            "\nThank you for using Mini Hospital Emergency System."
                    );
                    break;

                default:
                    System.out.println(
                            "Invalid choice. Please try again."
                    );
            }

        } while (choice != 5);

        scanner.close();
    }

    // MAIN MENU

  public static void displayMainMenu() {

    System.out.println("\n");
    System.out.println(" ");
    System.out.println("   MINI HOSPITAL EMERGENCY MANAGEMENT");
    System.out.println(" ");
    System.out.println("1. Patient Management");
    System.out.println("2. Emergency Queue");
    System.out.println("3. Treatment Management");
    System.out.println("4. Patient Visit History");
    System.out.println("5. Exit");
    System.out.println(" ");
}


    // PATIENT MANAGEMENT

    public static void patientManagement() {

        int choice;

        do {

            System.out.println("\n------ PATIENT MANAGEMENT ------");
            System.out.println("1. Add New Patient");
            System.out.println("2. Search Patient");
            System.out.println("3. Delete Patient");
            System.out.println("4. Display All Patients");
            System.out.println("5. Back");

            choice = getIntInput("Enter your choice: ");

            switch (choice) {

    case 1:
        patientManagement();
        break;

    case 2:
        emergencyQueueManagement();
        break;

    case 3:
        treatmentManagement();
        break;

    case 4:
        visitHistoryManagement();
        break;

    case 5:
        System.out.println(
                "\nThank you for using Mini Hospital Emergency System."
        );
        break;

    default:
        System.out.println(
                "Invalid choice. Please try again."
        );
}

        } while (choice != 5);
    }

    // ADD PATIENT

    public static void addPatient() {

        System.out.println("\n----- ADD NEW PATIENT -----");

        int id = getIntInput("Enter Patient ID: ");

        scanner.nextLine();

        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();

        int age = getIntInput("Enter Age: ");

        scanner.nextLine();

        System.out.print("Enter Contact Number: ");
        String contact = scanner.nextLine();

        System.out.print("Enter Medical Condition: ");
        String condition = scanner.nextLine();

        Patient patient = new Patient(
                id,
                name,
                age,
                contact,
                condition
        );

        patientBST.insert(patient);
    }

    // SEARCH PATIENT

    public static void searchPatient() {

        System.out.println("\n===== SEARCH PATIENT =====");

        int id = getIntInput("Enter Patient ID: ");

        Patient patient = patientBST.search(id);

        if (patient != null) {

            System.out.println("\nPatient found:");
            patient.displayPatient();

        } else {

            System.out.println("Patient not found.");
        }
    }

    // DELETE PATIENT

    public static void deletePatient() {

        System.out.println("\n===== DELETE PATIENT =====");

        int id = getIntInput("Enter Patient ID: ");

        patientBST.delete(id);
    }

    // EMERGENCY QUEUE MENU

    public static void emergencyQueueManagement() {

        int choice;

        do {

            System.out.println("\n===== EMERGENCY QUEUE =====");
            System.out.println("1. Add Patient to Queue");
            System.out.println("2. Treat Next Patient");
            System.out.println("3. Display Waiting Queue");
            System.out.println("4. Back");

            choice = getIntInput("Enter your choice: ");

            switch (choice) {

                case 1:
                    addPatientToQueue();
                    break;

                case 2:
                    emergencyQueue.dequeue();
                    break;

                case 3:
                    emergencyQueue.displayQueue();
                    break;

                case 4:
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 4);
    }


    // ADD PATIENT TO QUEUE

    public static void addPatientToQueue() {

        System.out.println("\n===== ADD TO EMERGENCY QUEUE =====");

        int id = getIntInput("Enter Patient ID: ");

        Patient patient = patientBST.search(id);

        if (patient == null) {

            System.out.println(
                    "Patient does not exist in the patient records."
            );

            return;
        }

        emergencyQueue.enqueue(patient);
    }

    // INTEGER INPUT

    public static int getIntInput(String message) {

        while (true) {

            System.out.print(message);

            if (scanner.hasNextInt()) {

                int value = scanner.nextInt();

                return value;

            } else {

                System.out.println(
                        "Invalid input. Please enter a number."
                );

                scanner.next();
            }
        }
    }

    
}