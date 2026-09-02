# Mini Hospital Emergency Management System

A console-based Java application for managing emergency hospital patients using manually implemented data structures.

## Features

- **Patient records — Binary Search Tree:** insert, search, delete, and in-order display by patient ID.
- **Emergency waiting list — Queue:** add patients, treat the next patient using FIFO order, and display the queue.
- **Treatment history — Stack:** push completed treatment records, pop the latest record, and display records in LIFO order.
- **Patient visit history — Singly Linked List:** every patient owns a visit history; add, remove, search, and display visits.

## Run the program

From the project root:

```bash
javac -d out src/*.java
java -cp out Main
```

## Project structure

```
src/
  Main.java             # Console menus and application flow
  Patient.java          # Patient record and its visit-history list
  PatientBST.java       # Binary search tree implementation
  EmergencyQueue.java   # FIFO linked queue implementation
  TreatmentRecord.java  # Completed treatment data
  TreatmentStack.java   # LIFO linked stack implementation
  Visit.java            # Visit data
  VisitHistory.java     # Singly linked list implementation
```
