// Elijah Bastien
// 3/20/26

package contact;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
    // In memory storage uses a Map (Key = ID, Value = Contact Object)
    private final Map<String, Contact> contactList = new HashMap<>();

    // Add Contact with a Unique ID
    public void addContact(Contact contact) {
        if (contact == null || contactList.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact already exists or is invalid");
        }
        contactList.put(contact.getContactId(), contact);
    }

    // Delete Contact by ID
    public void deleteContact(String contactId) {
        if (!contactList.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID not found");
        }
        contactList.remove(contactId);
    }

    // Update Contact Fields by ID
    public void updateContact(String contactId, String firstName, String lastName, String phone, String address) {
        Contact contact = contactList.get(contactId);
        
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID not found");
        }

        // Only update if the new value is not null
        // The Contact object's own setters will handle the length validation
        
        if (firstName != null) {
            contact.setFirstName(firstName);
        }
        if (lastName != null) {
            contact.setLastName(lastName);
        }
        if (phone != null) {
            contact.setPhone(phone);
        }
        if (address != null) {
            contact.setAddress(address);
        }
    }

    // Helper method for testing returns the map or a specific contact
    public Contact getContact(String contactId) {
        return contactList.get(contactId);
    }
}