import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {
    private ContactService service;

    @BeforeEach
    public void setUp() {
        service = new ContactService();
    }

    @Test
    public void testAddContact() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        assertEquals(contact, service.getContact("1234567890"));
    }

    @Test
    public void testAddContactDuplicateId() {
        Contact contact1 = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        Contact contact2 = new Contact("1234567890", "Jane", "Smith", "0987654321", "456 Elm St");
        service.addContact(contact1);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(contact2);
        });
        assertEquals("Contact ID already exists", exception.getMessage());
    }

    @Test
    public void testDeleteContact() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        service.deleteContact("1234567890");
        assertNull(service.getContact("1234567890"));
    }

    @Test
    public void testDeleteNonexistentContact() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            service.deleteContact("9999999999");
        });
        assertEquals("Contact not found", exception.getMessage());
    }

    @Test
    public void testUpdateContact() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        service.updateContact("1234567890", "Jane", "Smith", "0987654321", "456 Elm St");

        assertEquals("Jane", service.getContact("1234567890").getFirstName());
        assertEquals("Smith", service.getContact("1234567890").getLastName());
        assertEquals("0987654321", service.getContact("1234567890").getPhoneNumber());
        assertEquals("456 Elm St", service.getContact("1234567890").getAddress());
    }

    @Test
    public void testUpdateNonexistentContact() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            service.updateContact("9999999999", "Jane", "Smith", "0987654321", "456 Elm St");
        });
        assertEquals("Contact not found", exception.getMessage());
    }

    @Test
    public void testUpdateContactInvalidFields() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);

        // Invalid firstName
        IllegalArgumentException exception1 = assertThrows(IllegalArgumentException.class, () -> {
            service.updateContact("1234567890", null, "Smith", "0987654321", "456 Elm St");
        });
        assertEquals("Invalid field value", exception1.getMessage());

        // Invalid phone number
        IllegalArgumentException exception2 = assertThrows(IllegalArgumentException.class, () -> {
            service.updateContact("1234567890", "Jane", "Smith", "123", "456 Elm St");
        });
        assertEquals("Invalid field value", exception2.getMessage());
    }

    @Test
    public void testGetContact() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        assertEquals(contact, service.getContact("1234567890"));
    }

    @Test
    public void testGetNonexistentContact() {
        assertNull(service.getContact("9999999999"));
    }
}
