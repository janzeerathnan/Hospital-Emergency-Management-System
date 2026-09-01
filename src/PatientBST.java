public class PatientBST {

    // class for Binary Search Tree
    private class Node {

        Patient patient;
        Node left;
        Node right;

        Node(Patient patient) {
            this.patient = patient;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    // Constructor
    public PatientBST() {
        root = null;
    }

    // INSERT

    public void insert(Patient patient) {

        root = insertHelper(root, patient);

        System.out.println("Patient added successfully.");
    }

    private Node insertHelper(Node node, Patient patient) {

        // If position empty, create a new node
        if (node == null) {
            return new Node(patient);
        }

        // Smaller Patient ID goes to the left
        if (patient.getPatientId() < node.patient.getPatientId()) {

            node.left = insertHelper(node.left, patient);

        }
        // Larger Patient ID goes to the right
        else if (patient.getPatientId() > node.patient.getPatientId()) {

            node.right = insertHelper(node.right, patient);

        }
        // Duplicate ID
        else {

            System.out.println("Patient ID already exists.");
        }

        return node;
    }


    // SEARCH

    public Patient search(int patientId) {

        Node result = searchHelper(root, patientId);

        if (result != null) {
            return result.patient;
        }

        return null;
    }

    private Node searchHelper(Node node, int patientId) {

        // Patient not found
        if (node == null) {
            return null;
        }

        // Patient found
        if (patientId == node.patient.getPatientId()) {
            return node;
        }

        // Search left
        if (patientId < node.patient.getPatientId()) {
            return searchHelper(node.left, patientId);
        }

        // Search right
        return searchHelper(node.right, patientId);
    }


    // DELETE

    public void delete(int patientId) {

        if (search(patientId) == null) {

            System.out.println("Patient not found.");
            return;
        }

        root = deleteHelper(root, patientId);

        System.out.println("Patient deleted successfully.");
    }

    private Node deleteHelper(Node node, int patientId) {

        if (node == null) {
            return null;
        }

        // Search left
        if (patientId < node.patient.getPatientId()) {

            node.left = deleteHelper(node.left, patientId);
        }

        // Search right
        else if (patientId > node.patient.getPatientId()) {

            node.right = deleteHelper(node.right, patientId);
        }

        // Patient found
        else {

            // Case 1: No child
            if (node.left == null && node.right == null) {

                return null;
            }

            // Case 2: Only right child
            if (node.left == null) {

                return node.right;
            }

            // Case 3: Only left child
            if (node.right == null) {

                return node.left;
            }

            // Case 4: Two children
            Node successor = findMin(node.right);

            node.patient = successor.patient;

            node.right = deleteHelper(
                    node.right,
                    successor.patient.getPatientId()
            );
        }

        return node;
    }

    // Find smallest node in a subtree
    private Node findMin(Node node) {

        while (node.left != null) {
            node = node.left;
        }

        return node;
    }


    // IN-ORDER TRAVERSAL

    public void displayInOrder() {

        if (root == null) {

            System.out.println("No patients found.");
            return;
        }

        System.out.println("\n===== PATIENT RECORDS =====");

        inOrder(root);
    }

    private void inOrder(Node node) {

        if (node != null) {

            // Left
            inOrder(node.left);

            // Root
            node.patient.displayPatient();

            // Right
            inOrder(node.right);
        }
    }
}