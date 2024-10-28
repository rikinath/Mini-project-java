package College;

// Class to represent a student record
public class Record {

    // Instance variables
    private String name;
    private int idNumber;
    private long contactNumber; // Changed to long for larger numbers

    // Default Constructor
    public Record() {}

    // Parameterized Constructor
    // @param name - Student's name
    // @param idNumber - Student's ID
    // @param contactNumber - Student's contact number
    public Record(String name, int idNumber, long contactNumber) {
        this.name = name;
        this.idNumber = idNumber;
        this.contactNumber = contactNumber;
    }

    // Getter for contactNumber
    public long getContactNumber() { 
        return contactNumber; 
    }

    // Setter for contactNumber
    public void setContactNumber(long contactNumber) {
        this.contactNumber = contactNumber;
    }

    // Getter for idNumber
    public int getIdNumber() { 
        return idNumber; 
    }

    // Setter for idNumber
    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    // Getter for name
    public String getName() { 
        return name; 
    }

    // Setter for name
    public void setName(String name) { 
        this.name = name; 
    }

    // Overriding toString() method for a meaningful output
    @Override 
    public String toString() {
        return "Record { " +
               "Name = '" + name + '\'' +
               ", ID Number = " + idNumber +
               ", Contact Number = " + contactNumber +
               " }";
    }
}
