public class EmergencyQueue {

    // Node class
    private class QueueNode {

        Patient patient;
        QueueNode next;

        QueueNode(Patient patient) {
            this.patient = patient;
            this.next = null;
        }
    }

    private QueueNode front;
    private QueueNode rear;

    // Constructor
    public EmergencyQueue() {

        front = null;
        rear = null;
    }


    // ENQUEUE

    public void enqueue(Patient patient) {

        QueueNode newNode = new QueueNode(patient);

        // Queue is empty
        if (rear == null) {

            front = newNode;
            rear = newNode;

        } else {

            rear.next = newNode;
            rear = newNode;
        }

        System.out.println(
                "Patient " + patient.getPatientId()
                        + " added to emergency queue."
        );
    }


    // DEQUEUE

    public Patient dequeue() {

        // Queue is empty
        if (front == null) {

            System.out.println("Emergency queue is empty.");
            return null;
        }

        Patient patient = front.patient;

        front = front.next;

        // If queue becomes empty
        if (front == null) {

            rear = null;
        }

        System.out.println(
                "Patient " + patient.getPatientId()
                        + " removed for treatment."
        );

        return patient;
    }

    // DISPLAY QUEUE

    public void displayQueue() {

        if (front == null) {

            System.out.println("Emergency queue is empty.");
            return;
        }

        System.out.println("\n----- EMERGENCY QUEUE -----");

        QueueNode current = front;

        while (current != null) {

            System.out.println(
                    "Patient ID: "
                            + current.patient.getPatientId()
                            + " | Name: "
                            + current.patient.getPatientName()
            );

            current = current.next;
        }

        System.out.println("--------------------------");
    }

    // CHECK EMPTY

    public boolean isEmpty() {

        return front == null;
    }
}