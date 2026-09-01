public class VisitHistory {

    private class VisitNode {

        Visit visit;
        VisitNode next;

        VisitNode(Visit visit) {
            this.visit = visit;
            this.next = null;
        }
    }

    private VisitNode head;

    public VisitHistory() {
        head = null;
    }

    // ADD VISIT

    public void addVisit(Visit visit) {

        VisitNode newNode = new VisitNode(visit);

        // Empty list
        if (head == null) {

            head = newNode;

        } else {

            VisitNode current = head;

            while (current.next != null) {

                current = current.next;
            }

            current.next = newNode;
        }

        System.out.println(
                "Visit added successfully."
        );
    }

    // REMOVE VISIT

    public boolean removeVisit(int visitId) {

        if (head == null) {

            System.out.println(
                    "Visit history is empty."
            );

            return false;
        }

        // Remove first node
        if (head.visit.getVisitId() == visitId) {

            head = head.next;

            System.out.println(
                    "Visit removed successfully."
            );

            return true;
        }

        VisitNode current = head;

        while (current.next != null) {

            if (current.next.visit.getVisitId() == visitId) {

                current.next = current.next.next;

                System.out.println(
                        "Visit removed successfully."
                );

                return true;
            }

            current = current.next;
        }

        System.out.println(
                "Visit not found."
        );

        return false;
    }

    // SEARCH VISIT

    public Visit searchVisit(int visitId) {

        VisitNode current = head;

        while (current != null) {

            if (current.visit.getVisitId() == visitId) {

                return current.visit;
            }

            current = current.next;
        }

        return null;
    }


    // DISPLAY HISTORY

    public void displayHistory() {

        if (head == null) {

            System.out.println(
                    "Visit history is empty."
            );

            return;
        }

        System.out.println("\n----- PATIENT VISIT HISTORY -----");

        VisitNode current = head;

        while (current != null) {

            current.visit.displayVisit();

            current = current.next;
        }

    }

}
