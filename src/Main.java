import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final PatientBST patientBST = new PatientBST();
    private static final EmergencyQueue emergencyQueue = new EmergencyQueue();
    private static final TreatmentStack treatmentStack = new TreatmentStack();

    public static void main(String[] args) {
        int choice;
        do {
            displayMainMenu();
            choice = getIntInput("Enter your choice: ");
            switch (choice) {
                case 1: patientManagement(); break;
                case 2: emergencyQueueManagement(); break;
                case 3: treatmentManagement(); break;
                case 4: visitHistoryManagement(); break;
                case 5: System.out.println("\nThank you for using the Mini Hospital Emergency Management System."); break;
                default: System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
        scanner.close();
    }

    private static void displayMainMenu() {
        System.out.println("\n    MINI HOSPITAL EMERGENCY MANAGEMENT   ");
        System.out.println("1. Patient Management (BST)");
        System.out.println("2. Emergency Queue");
        System.out.println("3. Treatment History (Stack)");
        System.out.println("4. Patient Visit History (Linked List)");
        System.out.println("5. Exit");
    }

    private static void patientManagement() {
        int choice;
        do {
            System.out.println("\n------ PATIENT MANAGEMENT (BST) ------");
            System.out.println("1. Add New Patient\n2. Search Patient\n3. Delete Patient\n4. Display All Patients (In-order)\n5. Back");
            choice = getIntInput("Enter your choice: ");
            switch (choice) {
                case 1: addPatient(); break;
                case 2: searchPatient(); break;
                case 3: deletePatient(); break;
                case 4: patientBST.displayInOrder(); break;
                case 5: break;
                default: System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

    private static void addPatient() {
        System.out.println("\n----- ADD NEW PATIENT -----");
        int id = getIntInput("Enter Patient ID: ");
        String name = getTextInput("Enter Patient Name: ");
        int age = getIntInput("Enter Age: ");
        String contact = getTextInput("Enter Contact Number: ");
        String condition = getTextInput("Enter Medical Condition: ");
        patientBST.insert(new Patient(id, name, age, contact, condition));
    }

    private static void searchPatient() {
        System.out.println("\n------ SEARCH PATIENT ------");
        Patient patient = patientBST.search(getIntInput("Enter Patient ID: "));
        if (patient == null) System.out.println("Patient not found.");
        else { System.out.println("\nPatient found:"); patient.displayPatient(); }
    }

    private static void deletePatient() {
        System.out.println("\n------ DELETE PATIENT ------");
        patientBST.delete(getIntInput("Enter Patient ID: "));
    }

    private static void emergencyQueueManagement() {
        int choice;
        do {
            System.out.println("\n------ EMERGENCY QUEUE (FIFO) ------");
            System.out.println("1. Add Patient to Queue\n2. Treat Next Patient\n3. Display Waiting Queue\n4. Back");
            choice = getIntInput("Enter your choice: ");
            switch (choice) {
                case 1: addPatientToQueue(); break;
                case 2: treatNextPatient(); break;
                case 3: emergencyQueue.displayQueue(); break;
                case 4: break;
                default: System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    private static void addPatientToQueue() {
        System.out.println("\n------ ADD TO EMERGENCY QUEUE ------");
        Patient patient = patientBST.search(getIntInput("Enter Patient ID: "));
        if (patient == null) { System.out.println("Patient does not exist in the patient records."); return; }
        emergencyQueue.enqueue(patient);
    }

    private static void treatNextPatient() {
        Patient patient = emergencyQueue.dequeue();
        if (patient == null) return;
        System.out.println("\nEnter completed-treatment details for " + patient.getPatientName() + ".");
        addTreatmentRecord(patient);
    }

    private static void treatmentManagement() {
        int choice;
        do {
            System.out.println("\n------ TREATMENT HISTORY (LIFO STACK) ------");
            System.out.println("1. Add Completed Treatment Record\n2. Remove Latest Treatment Record\n3. Display Treatment History\n4. Back");
            choice = getIntInput("Enter your choice: ");
            switch (choice) {
                case 1:
                    Patient patient = patientBST.search(getIntInput("Enter Patient ID: "));
                    if (patient == null) System.out.println("Patient not found."); else addTreatmentRecord(patient);
                    break;
                case 2: treatmentStack.pop(); break;
                case 3: treatmentStack.displayStack(); break;
                case 4: break;
                default: System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    private static void addTreatmentRecord(Patient patient) {
        System.out.println("\n------ COMPLETE TREATMENT ------");
        int treatmentId = getIntInput("Enter Treatment ID: ");
        String doctor = getTextInput("Enter Doctor Name: ");
        String diagnosis = getTextInput("Enter Diagnosis: ");
        String treatment = getTextInput("Enter Treatment: ");
        String date = getTextInput("Enter Treatment Date: ");
        treatmentStack.push(new TreatmentRecord(treatmentId, patient.getPatientId(), patient.getPatientName(), doctor, diagnosis, treatment, date));
    }

    private static void visitHistoryManagement() {
        int choice;
        do {
            System.out.println("\n------ PATIENT VISIT HISTORY (LINKED LIST) ------");
            System.out.println("1. Add New Visit\n2. Remove Visit\n3. Search Visit\n4. Display Visit History\n5. Back");
            choice = getIntInput("Enter your choice: ");
            switch (choice) {
                case 1: addVisit(); break;
                case 2: removeVisit(); break;
                case 3: searchVisit(); break;
                case 4: displayVisitHistory(); break;
                case 5: break;
                default: System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

    private static Patient getPatientForVisitHistory() {
        Patient patient = patientBST.search(getIntInput("Enter Patient ID: "));
        if (patient == null) System.out.println("Patient not found.");
        return patient;
    }

    private static void addVisit() {
        System.out.println("\n------ ADD NEW VISIT ------");
        Patient patient = getPatientForVisitHistory();
        if (patient == null) return;
        int visitId = getIntInput("Enter Visit ID: ");
        String date = getTextInput("Enter Visit Date: ");
        String doctor = getTextInput("Enter Doctor Name: ");
        String diagnosis = getTextInput("Enter Diagnosis: ");
        String treatment = getTextInput("Enter Treatment: ");
        patient.getVisitHistory().addVisit(new Visit(visitId, date, doctor, diagnosis, treatment));
    }

    private static void removeVisit() {
        System.out.println("\n------ REMOVE VISIT ------");
        Patient patient = getPatientForVisitHistory();
        if (patient != null) patient.getVisitHistory().removeVisit(getIntInput("Enter Visit ID: "));
    }

    private static void searchVisit() {
        System.out.println("\n------ SEARCH VISIT ------");
        Patient patient = getPatientForVisitHistory();
        if (patient == null) return;
        Visit visit = patient.getVisitHistory().searchVisit(getIntInput("Enter Visit ID: "));
        if (visit == null) System.out.println("Visit not found.");
        else { System.out.println("\nVisit found:"); visit.displayVisit(); }
    }

    private static void displayVisitHistory() {
        System.out.println("\n------ DISPLAY VISIT HISTORY ------");
        Patient patient = getPatientForVisitHistory();
        if (patient != null) patient.getVisitHistory().displayHistory();
    }

    private static int getIntInput(String message) {
        while (true) {
            System.out.print(message);
            try { return Integer.parseInt(scanner.nextLine().trim()); }
            catch (NumberFormatException exception) { System.out.println("Invalid input. Please enter a whole number."); }
        }
    }

    private static String getTextInput(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) return input;
            System.out.println("This value cannot be empty.");
        }
    }
}
