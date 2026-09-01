# Mini Hospital Emergency Management System

A Java console application for the CIT300 Data Structures and Algorithms individual mid-assignment. The system manages hospital patients, emergency waiting requests, completed treatments, and visit histories using custom data structures.

## Features and data structures

| Feature | Data structure | Supported operations |
| --- | --- | --- |
| Patient records | Binary Search Tree (BST) | Add, search, delete, and display patients in ascending patient-ID order |
| Emergency patients | Queue | Enqueue, dequeue, display waiting patients, and empty-queue handling |
| Completed treatments | Stack | Push, pop, display treatment records, and empty-stack handling |
| Patient visit history | Singly linked list | Add, remove, search, and display visits for each patient |



Each patient's visit list is kept separately through a patient ID to `VisitHistory` mapping. The `VisitHistory` class itself is implemented as a singly linked list.

## Project structure

```text

─── src/
    ├── Main.java     # Console menus and application flow
    ├── Patient.java   # Patient model
    ├── PatientBST.java   # BST patient records
    ├── EmergencyQueue.java  # FIFO emergency queue
    ├── TreatmentRecord.java  # Treatment model
    ├── TreatmentStack.java  # LIFO treatment history
    ├── Visit.java    # Visit model
    └── VisitHistory.java  # Singly linked-list visit history
```

## Requirements

- Java Development Kit (JDK) 8 or newer
- A terminal or command prompt

## Compile and run

From the project root, run:

```bash
mkdir -p out
javac -d out src/*.java
java -cp out Main
```

Use the numbered menus to register patients, manage the emergency queue, record completed treatments, and manage visit histories. Enter `5` on the main menu to exit the program.

## Testing

The functional test suite checks the important operations and edge cases:

- BST insertion, search, duplicate IDs, and deletion of a node with two children
- Queue FIFO order and dequeueing an empty queue
- Stack LIFO order and popping an empty stack
- Visit-history add, search, remove, and missing-visit handling


## Design decisions

- Patient IDs are the BST keys, so in-order traversal displays records in ascending ID order.
- The emergency queue stores `Patient` objects and processes the first arrival first (FIFO).
- Completed treatment records are placed on top of a stack, so the latest treatment is removed first (LIFO).
- Each visit history uses nodes containing a `Visit` and a reference to the next node, fulfilling the singly linked-list requirement.

## Learning reflection

This assignment demonstrates how the choice of data structure affects the operations of a real system. 
The BST supports organised patient retrieval, the queue models emergency arrival order, the stack retains the most recent treatment first, and the linked list allows each patient to maintain a flexible visit history.

