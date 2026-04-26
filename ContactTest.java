// Elijah Bastien
// 3/20/26

package contact;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ContactServiceTest {

    @Test
    void testAddContact() {
        ContactService service = new ContactService();
        Contact c1 = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(c1);
        assertNotNull(service.getContact("1"));
    }

    @Test
    void testAddDuplicateId() {
        ContactService service = new ContactService();
        Contact c1 = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        Contact c2 = new Contact("1", "Jane", "Smith", "0987654321", "456 Oak Ave");
        service.addContact(c1);
        
        // This should fail because ID "1" is already in the system
        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(c2);
        });
    }

    @Test
    void testDeleteContact() {
        ContactService service = new ContactService();
        Contact c1 = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(c1);
        service.deleteContact("1");
        assertNull(service.getContact("1"));
    }

    @Test
    void testUpdateContact() {
        ContactService service = new ContactService();
        Contact c1 = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(c1);
        
        service.updateContact("1", "Johnny", "Silver", "1112223333", "789 Pine Rd");
        
        assertEquals("Johnny", service.getContact("1").getFirstName());
        assertEquals("Silver", service.getContact("1").getLastName());
        assertEquals("1112223333", service.getContact("1").getPhone());
    }
}