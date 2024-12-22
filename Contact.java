public class Contact {
    // MEMBER VARIABLES
    private final String contactID;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;

    // CONSTANTS
    private static final int MAX_FIELD_LENGTH = 10; // For standard fields (not the address)
    private static final int MAX_ADDRESS_LENGTH = 30;

    // CONSTRUCTOR
    public Contact(String contactID, String firstName, String lastName, String phoneNumber, String address) {
        // setContactID(contactID) {
        if (contactID == null || contactID.length() > MAX_FIELD_LENGTH) {
            throw new IllegalArgumentException("Contact ID must be 10 characters or less");
        }
        setFirstName(firstName);
        setLastName(lastName);
        setPhoneNumber(phoneNumber);
        setAddress(address);

        this.contactID = contactID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    // GETTERS
    public String getContactID() {
        return contactID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    // SETTERS
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > MAX_FIELD_LENGTH) {
            throw new IllegalArgumentException("First name must be 10 characters or less");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > MAX_FIELD_LENGTH) {
            throw new IllegalArgumentException("Last name must be 10 characters or less");
        }
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.length() != MAX_FIELD_LENGTH) {
            throw new IllegalArgumentException("Phone number must be exactly 10 numbers");
        }
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        if (address == null || address.length() > MAX_ADDRESS_LENGTH) {
            throw new IllegalArgumentException("Address must be less than 30 characters");
        }
        this.address = address;
    }
}
