public class ContactServiceTest {
    public static void main(String[] args) {
        testAddAndDeleteContact();
        testUpdateFields();
    }

    private static void testAddAndDeleteContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");

        service.addContact(contact);
        boolean passed = service.getContact("12345") != null;

        service.deleteContact("12345");
        passed = passed && service.getContact("12345") == null;

        System.out.println("testAddAndDeleteContact: " + (passed ? "PASSED" : "FAILED"));
    }

    private static void testUpdateFields() {
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);

        service.updateFirstName("12345", "Jane");
        service.updateLastName("12345", "Smith");
        service.updatePhone("12345", "0987654321");
        service.updateAddress("12345", "456 Elm St");

        boolean passed = "Jane".equals(contact.getFirstName()) &&
                         "Smith".equals(contact.getLastName()) &&
                         "0987654321".equals(contact.getPhone()) &&
                         "456 Elm St".equals(contact.getAddress());

        System.out.println("testUpdateFields: " + (passed ? "PASSED" : "FAILED"));
    }
}
