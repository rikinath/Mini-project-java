package College;

import java.util.LinkedList;
import java.util.Scanner;

// Class to manage student records
public class StudentRecordManagement {

    // LinkedList to store the student records
    LinkedList<Record> list;

    // Constructor
    public StudentRecordManagement() {
        list = new LinkedList<>();
    }

    // Method 1: Adding a record
    public void add(Record record) {
        if (!find(record.getIdNumber())) {
            list.add(record);
        } else {
            System.out.println("Record already exists in the list.");
        }
    }

    // Method 2: Find a record by ID
    public boolean find(int idNumber) {
        for (Record r : list) {
            if (r.getIdNumber() == idNumber) {
                System.out.println(r);
                return true;
            }
        }
        return false;
    }

    // Method 3: Delete a record by ID
    public void delete(int recIdNumber) {
        Record recordDel = null;
        for (Record r : list) {
            if (r.getIdNumber() == recIdNumber) {
                recordDel = r;
                break;
            }
        }
        if (recordDel != null) {
            list.remove(recordDel);
            System.out.println("Record successfully deleted.");
        } else {
            System.out.println("Invalid record ID.");
        }
    }

    // Method 4: Find and return a record object
    public Record findRecord(int idNumber) {
        for (Record r : list) {
            if (r.getIdNumber() == idNumber) {
                return r;
            }
        }
        return null;
    }

    // Method 5: Update a record by ID
    public void update(int id, Scanner input) {
        if (find(id)) {
            Record rec = findRecord(id);

            System.out.print("Enter new Student ID: ");
            int idNumber = input.nextInt();

            System.out.print("Enter new Contact Number: ");
            long contactNumber = input.nextLong();
            input.nextLine(); // Consume the newline

            System.out.print("Enter new Name: ");
            String name = input.nextLine();

            rec.setIdNumber(idNumber);
            rec.setContactNumber(contactNumber);
            rec.setName(name);
            System.out.println("Record updated successfully.");
        } else {
            System.out.println("Record not found.");
        }
    }

    // Method 6: Display all records
    public void display() {
        if (list.isEmpty()) {
            System.out.println("The list has no records.");
        } else {
            for (Record record : list) {
                System.out.println(record);
            }
        }
    }
}
