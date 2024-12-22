import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {
    @Test
    public void testValidContactCreation() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        assertEquals("1234567890", contact.getContactID());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhoneNumber());
        assertEquals("123 Main St", contact.getAddress());
    }

    @Test
    public void testValidContactUpdate() {
        Contact contact = new Contact("0987654321", "John", "Doe", "1234567890", "123 Main St");

        contact.setFirstName("Daniel");
        contact.setLastName("Aguiar");
        contact.setPhoneNumber("0987654321");
        contact.setAddress("321 Main St");

        assertEquals("0987654321", contact.getContactID());
        assertEquals("Daniel", contact.getFirstName());
        assertEquals("Aguiar", contact.getLastName());
        assertEquals("0987654321", contact.getPhoneNumber());
        assertEquals("321 Main St", contact.getAddress());
    }

    @Test
    public void testInvalidContactId() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact(null, "John", "Doe", "1234567890", "123 Main St"));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St"));
    }

    @Test
    public void testInvalidPhone() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1234567890", "John", "Doe", "12345678", "123 Main St"));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("1234567890", "John", "Doe", "12345678901", "123 Main St"));
    }
}
