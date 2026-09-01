public class TreatmentStack {

    private class StackNode {

        TreatmentRecord treatment;
        StackNode next;

        StackNode(TreatmentRecord treatment) {
            this.treatment = treatment;
            this.next = null;
        }
    }

    private StackNode top;

    public TreatmentStack() {
        top = null;
    }

    // PUSH

    public void push(TreatmentRecord treatment) {

        StackNode newNode = new StackNode(treatment);

        newNode.next = top;

        top = newNode;

        System.out.println(
                "Treatment record added successfully."
        );
    }

    // POP

    public TreatmentRecord pop() {

        if (top == null) {

            System.out.println(
                    "Treatment history stack is empty."
            );

            return null;
        }

        TreatmentRecord treatment = top.treatment;

        top = top.next;

        System.out.println(
                "Latest treatment record removed."
        );

        return treatment;
    }

    // DISPLAY

    public void displayStack() {

        if (top == null) {

            System.out.println(
                    "Treatment history stack is empty."
            );

            return;
        }

        System.out.println("\n------ TREATMENT HISTORY -------");

        StackNode current = top;

        while (current != null) {

            current.treatment.displayTreatment();

            current = current.next;
        }

        System.out.println("-----------------------------");
    }


    // CHECK EMPTY

    public boolean isEmpty() {

        return top == null;
    }
}