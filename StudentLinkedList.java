package College;

// Importing required classes
import java.util.LinkedList;
import java.util.Scanner;

// Class representing each student record
class Record {
    private String name;
    private int idNumber;
    private long contactNumber;

    // Constructor
    public Record() {
    }

    public Record(String name, int idNumber, long contactNumber) {
        this.name = name;
        this.idNumber = idNumber;
        this.contactNumber = contactNumber;
    }

    // Mutators (Setters)
    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public void setContactNumber(long contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Accessors (Getters)
    public int getIdNumber() {
        return idNumber;
    }

    public long getContactNumber() {
        return contactNumber;
    }

    public String getName() {
        return name;
    }

    // Overriding toString method
    @Override
    public String toString() {
        return "ID: " + idNumber + ", Name: " + name + ", Contact: " + contactNumber;
    }
}

// Class for managing student records using a LinkedList
class StudentRecordManagement {
    private LinkedList<Record> studentRecords;

    // Constructor
    public StudentRecordManagement() {
        studentRecords = new LinkedList<>();
    }

    // Method to add a student record
    public void add(Record record) {
        studentRecords.add(record);
    }

    // Method to delete a student record by ID
    public void delete(int idNumber) {
        boolean removed = studentRecords.removeIf(record -> record.getIdNumber() == idNumber);
        if (removed) {
            System.out.println("Student record with ID " + idNumber + " has been deleted.");
        } else {
            System.out.println("Student record not found.");
        }
    }

    // Method to update a student record
    public void update(int idNumber, Scanner input) {
        for (Record record : studentRecords) {
            if (record.getIdNumber() == idNumber) {
                System.out.print("Enter new contact number: ");
                long newContact = input.nextLong();
                input.nextLine();  // Consume newline
                System.out.print("Enter new name: ");
                String newName = input.nextLine();

                record.setContactNumber(newContact);
                record.setName(newName);

                System.out.println("Record updated: " + record);
                return;
            }
        }
        System.out.println("Student record not found.");
    }

    // Method to find a student record by ID
    public boolean find(int idNumber) {
        for (Record record : studentRecords) {
            if (record.getIdNumber() == idNumber) {
                System.out.println("Record found: " + record);
                return true;
            }
        }
        return false;
    }

    // Method to display all student records
    public void display() {
        if (studentRecords.isEmpty()) {
            System.out.println("No student records available.");
        } else {
            System.out.println("Student Records:");
            for (Record record : studentRecords) {
                System.out.println(record);
            }
        }
    }
}

// Main class
public class StudentLinkedList {

    // Main driver method
    public static void main(String[] args) {

        // Creating StudentRecordManagement Object.
        StudentRecordManagement hr = new StudentRecordManagement();

        // Creating a default Record object
        Record record = new Record();
        
        // Initial Student record (Hardcoded data)
        record.setIdNumber(6862);
        record.setContactNumber(911);
        record.setName("Ankit");
        
        // Adding static data to the list
        hr.add(record);

        // Creating Scanner Object to read input
        Scanner input = new Scanner(System.in);

        // Creating option integer variable
        int option;

        // Do - While loop
        do {
            menu();
            option = input.nextInt();

            // Switch case
            switch (option) {

                // Case 1: Add Student
                case 1:
                    System.out.print("What is the Student ID number? ");
                    int idNumber = input.nextInt();

                    System.out.print("What is the Student contact number? ");
                    long contactNumber = input.nextLong();
                    input.nextLine(); // Consume newline

                    System.out.print("What is the Student Name? ");
                    String name = input.nextLine();

                    // Create record object and pass constructor parameters.
                    record = new Record(name, idNumber, contactNumber);
                    hr.add(record);
                    System.out.println("Added record: " + record);
                    break;

                // Case 2: Delete Student
                case 2:
                    System.out.print("What is the Student ID number? ");
                    int rId = input.nextInt();
                    hr.delete(rId);
                    break;

                // Case 3: Update Student
                case 3:
                    System.out.print("What is the Student ID number? ");
                    int rIdNo = input.nextInt();
                    hr.update(rIdNo, input);
                    break;

                // Case 4: Search Student
                case 4:
                    System.out.print("What is the Student ID? ");
                    int bookId = input.nextInt();
                    if (!hr.find(bookId)) {
                        System.out.println("Student ID does not exist\n");
                    }
                    break;

                // Case 5: Display all Students
                case 5:
                    hr.display();
                    break;

                // Case 9: Exit the program
                case 9:
                    System.out.println("\nThank you for using the program. Goodbye!\n");
                    System.exit(0);
                    break;

                // Default case: Invalid input
                default:
                    System.out.println("\nInvalid input\n");
                    break;
            }
        }
        // Keep looping until the user selects option 9 (Exit)
        while (option != 9);
    }

    // Menu method to display options
    public static void menu() {
        System.out.println("\nMENU");
        System.out.println("1: Add Student");
        System.out.println("2: Delete Student");
        System.out.println("3: Update Student");
        System.out.println("4: Search Student");
        System.out.println("5: Display Students");
        System.out.println("9: Exit program");
        System.out.print("Enter your selection: ");
    }
}
