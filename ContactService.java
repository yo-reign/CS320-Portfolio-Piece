import java.util.Map;
import java.util.HashMap;

public class ContactService {
    // In-memory map/storage of contacts
    // NOTE: This is a member variable, not a static variable so each instance of
    // the class has its own map.
    private final Map<String, Contact> contacts = new HashMap<String, Contact>();

    // Add a contact
    public void addContact(Contact contact) {
        if (contacts.containsKey(contact.getContactID())) {
            throw new IllegalArgumentException("Contact ID already exists");
        }
        contacts.put(contact.getContactID(), contact);
    }

    // Delete a contact
    public void deleteContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact not found");
        }
        contacts.remove(contactId);
    }

    // Update a contact
    public void updateContact(String contactId, String firstName, String lastName, String phone, String address) {
        // Get the contact object from the map (By Reference)
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact not found");
        }

        try { // All of these methods throw IllegalArgumentException if the field value is
            contact.setFirstName(firstName);
            contact.setLastName(lastName);
            contact.setPhoneNumber(phone);
            contact.setAddress(address);
        }
        // For assignment testing purposes, instead of handling the exception I'm just
        // re-throwing it for now.
        catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid field value");
        }
    }

    // Get a contact
    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }
}
